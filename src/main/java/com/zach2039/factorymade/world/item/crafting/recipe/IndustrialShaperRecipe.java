package com.zach2039.factorymade.world.item.crafting.recipe;

import com.google.gson.JsonObject;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.init.ModCrafting;
import com.zach2039.factorymade.init.ModRecipeTypes;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class IndustrialShaperRecipe extends SingleItemRecipe {
	public IndustrialShaperRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
		super(ModRecipeTypes.INDUSTRIAL_SHAPER.get(), ModCrafting.Recipes.INDUSTRIAL_SHAPER.get(), id, group, ingredient, result);
	}
	
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	@Override
	public boolean matches(Container container, Level level) {
		return this.ingredient.test(container.getItem(0));
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlocks.INDUSTRIAL_SHAPER.get());
	}
	
	public static class Serializer implements RecipeSerializer<IndustrialShaperRecipe> {

		public IndustrialShaperRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String s = GsonHelper.getAsString(json, "group", "");
			Ingredient ingredient;
			if (GsonHelper.isArrayNode(json, "ingredient")) {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(json, "ingredient"));
			} else {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
			}

			String s1 = GsonHelper.getAsString(json, "result");
			int i = GsonHelper.getAsInt(json, "count");
			ItemStack itemstack = new ItemStack(Registry.ITEM.get(new ResourceLocation(s1)), i);
			return new IndustrialShaperRecipe(recipeId, s, ingredient, itemstack);
		}

		public IndustrialShaperRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buf) {
			String s = buf.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(buf);
			ItemStack itemstack = buf.readItem();
			return new IndustrialShaperRecipe(recipeId, s, ingredient, itemstack);
		}

		public void toNetwork(FriendlyByteBuf buf, IndustrialShaperRecipe recipe) {
			buf.writeUtf(recipe.group);
			recipe.ingredient.toNetwork(buf);
			buf.writeItem(recipe.result);
		}
	}
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModCrafting.Recipes.INDUSTRIAL_SHAPER.get();
	}
}