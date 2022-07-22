package com.zach2039.factorymade.data.recipes;

import com.zach2039.factorymade.init.ModCrafting;
import com.zach2039.factorymade.world.item.crafting.recipe.IndustrialShaperRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class IndustrialShaperRecipeBuilder extends EnhancedSingleItemRecipeBuilder<IndustrialShaperRecipe, IndustrialShaperRecipeBuilder> {
	protected IndustrialShaperRecipeBuilder(final Ingredient ingredient, final ItemStack result) {
		super(ModCrafting.Recipes.INDUSTRIAL_SHAPER.get(), ingredient, result);
	}

	public static IndustrialShaperRecipeBuilder industrialshaper(final Ingredient ingredient, final ItemLike result, final int count) {
		return industrialshaper(ingredient, new ItemStack(result, count));
	}
	
	public static IndustrialShaperRecipeBuilder industrialshaper(final Ingredient ingredient, final ItemStack stack, final int count) {
		return industrialshaper(ingredient, stack, count);
	}
	
	public static IndustrialShaperRecipeBuilder industrialshaper(final Ingredient ingredient, final ItemLike result) {
		return industrialshaper(ingredient, new ItemStack(result));
	}

	public static IndustrialShaperRecipeBuilder industrialshaper(final Ingredient ingredient, final ItemStack result) {
		return new IndustrialShaperRecipeBuilder(ingredient, result);
	}
}

