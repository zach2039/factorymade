package com.zach2039.factorymade.data.recipes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.zach2039.factorymade.util.ModRegistryUtil;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

/**
 * An extension of {@link SingleItemRecipeBuilder} that allows the recipe result to have NBT and a custom group name for
 * the recipe advancement.
 *
 * @author Choonster
 * 
 * Refactored for SingleItemRecipeBuilder by
 * @author zach2039
 */
public class EnhancedSingleItemRecipeBuilder<
	RECIPE extends SingleItemRecipe,
	BUILDER extends EnhancedSingleItemRecipeBuilder<RECIPE, BUILDER>
	> extends SingleItemRecipeBuilder {

	private static final Method ENSURE_VALID = ObfuscationReflectionHelper.findMethod(SingleItemRecipeBuilder.class, /* ensureValid */ "m_126329_", ResourceLocation.class);
	private static final Field ADVANCEMENT = ObfuscationReflectionHelper.findField(SingleItemRecipeBuilder.class, /* advancement */ "f_126305_");
	private static final Field GROUP = ObfuscationReflectionHelper.findField(SingleItemRecipeBuilder.class, /* group */ "f_126306_");
	private static final Field INGREDIENT = ObfuscationReflectionHelper.findField(SingleItemRecipeBuilder.class, /* ingredient */ "f_126303_");
	
	private final ItemStack result;
	private final RecipeSerializer<? extends RECIPE> serializer;
	@Nullable
	private String itemGroup;

	public EnhancedSingleItemRecipeBuilder(RecipeSerializer<? extends RECIPE> serializer, Ingredient ingredient, ItemStack result) {
		super(serializer, ingredient, result.getItem(), 1);
		this.result = result;
		this.serializer = serializer;
	}

	/**
	 * Sets the item group name to use for the recipe advancement. This allows the result to be an item without an
	 * item group, e.g. minecraft:spawner.
	 *
	 * @param group The group name
	 * @return This builder
	 */
	@SuppressWarnings("unchecked")
	public BUILDER itemGroup(final String group) {
		itemGroup = group;
		return (BUILDER) this;
	}
	
	/**
	 * Adds a criterion needed to unlock the recipe.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BUILDER unlockedBy(final String name, final CriterionTriggerInstance criterion) {
		return (BUILDER) super.unlockedBy(name, criterion);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BUILDER group(@Nullable final String group) {
		return (BUILDER) super.group(group);
	}

	/**
	 * Builds this recipe into a {@link FinishedRecipe}.
	 */
	@Override
	public void save(final Consumer<FinishedRecipe> consumer) {
		final Item item = result.getItem();
		save(consumer, ModRegistryUtil.getKey(item));
	}
	
	/**
	 * Builds this recipe into a {@link FinishedRecipe}. Use {@link #save(Consumer)} if save is the same as the ID for
	 * the result.
	 */
	@Override
	public void save(final Consumer<FinishedRecipe> consumer, final String save) {
		final ResourceLocation key = ModRegistryUtil.getKey(result.getItem());
		if (new ResourceLocation(save).equals(key)) {
			throw new IllegalStateException("Shaped Recipe " + save + " should remove its 'save' argument");
		} else {
			save(consumer, new ResourceLocation(save));
		}
	}
	
	/**
	 * Validates that the recipe result has NBT or a custom group has been specified.
	 *
	 * @param id The recipe ID
	 */
	protected void ensureValid(final ResourceLocation id) {
		if (itemGroup == null && result.getItem().getItemCategory() == null) {
			throw new IllegalStateException("Enhanced Single Item Recipe " + id + " has result " + result + " with no item group - use EnhancedSingleItemRecipeBuilder.itemGroup to specify one");
		}
	}
	
	/**
	 * Builds this recipe into a {@link FinishedRecipe}.
	 */
	@Override
	public void save(final Consumer<FinishedRecipe> consumer, final ResourceLocation id) {
		try {
			// Perform the super class's validation
			ENSURE_VALID.invoke(this, id);

			// Perform our validation
			ensureValid(id);

			// We can't call the super method directly because it throws an exception when the result is an item that
			// doesn't belong to an item group (e.g. Mob Spawners).

			final Advancement.Builder advancementBuilder = ((Advancement.Builder) ADVANCEMENT.get(this))
					.parent(new ResourceLocation("minecraft", "recipes/root"))
					.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
					.rewards(AdvancementRewards.Builder.recipe(id))
					.requirements(RequirementsStrategy.OR);

			String group = (String) GROUP.get(this);
			if (group == null) {
				group = "";
			}

			Ingredient ingredient = (Ingredient) INGREDIENT.get(this);
			if (ingredient == null) {
				ingredient = Ingredient.EMPTY;
			}
			
			String itemGroupName = itemGroup;
			if (itemGroupName == null) {
				final CreativeModeTab itemGroup = Preconditions.checkNotNull(result.getItem().getItemCategory());
				itemGroupName = itemGroup.getRecipeFolderName();
			}

			final ResourceLocation advancementID = new ResourceLocation(id.getNamespace(), "recipes/" + itemGroupName + "/" + id.getPath());

			final Result baseRecipe = new Result(id, serializer, group, ingredient, result.getItem(), result.getCount(), advancementBuilder, advancementID); 

			consumer.accept(new SimpleFinishedRecipe(baseRecipe, result, serializer));
		} catch (final IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException("Failed to build Enhanced Shaped Recipe " + id, e);
		}
	}
}