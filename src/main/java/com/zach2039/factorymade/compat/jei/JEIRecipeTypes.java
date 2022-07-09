package com.zach2039.factorymade.compat.jei;

import com.zach2039.factorymade.init.ModRecipeTypes;
import com.zach2039.factorymade.world.item.crafting.recipe.IndustrialShaperRecipe;

import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.Recipe;

public class JEIRecipeTypes {
	public static final RecipeType<IndustrialShaperRecipe> INDUSTRIAL_SHAPER = create(ModRecipeTypes.INDUSTRIAL_SHAPER);
	
	private static <T extends Recipe<?>> RecipeType<T> create(ModRecipeTypes.TypeWithClass<T> type)
	{
		return new RecipeType<>(type.type().getId(), type.recipeClass());
	}
}
