package com.zach2039.factorymade.compat.jei;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.compat.jei.category.IndustrialShaperRecipeCategory;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.init.ModCrafting;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.List;
import java.util.function.Predicate;

@JeiPlugin
public class FactoryMadeJEIPlugin implements IModPlugin {
	public static final ResourceLocation ID = new ResourceLocation(FactoryMade.MODID, "jei");

	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
		
		registration.addRecipeCategories(
				new IndustrialShaperRecipeCategory(guiHelper)
			);
	}
	
	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration r) {
		r.addRecipeCatalyst(new ItemStack(ModBlocks.INDUSTRIAL_SHAPER.get()), JEIRecipeTypes.INDUSTRIAL_SHAPER);
	}
	
	@SuppressWarnings("resource")
	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		
		if (Minecraft.getInstance().level != null) {
			RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
			
			registration.addRecipes(JEIRecipeTypes.INDUSTRIAL_SHAPER, getFiltered(recipeManager, FactoryMadeJEIPlugin::isIndustrialShaperRecipe));
		}	
	}
	
	@SuppressWarnings("unchecked")
	private <T extends Recipe<?>> List<T> getFiltered(RecipeManager recipeManager, Predicate<? super Recipe<?>> include) {		
		return (List<T>) recipeManager.getRecipes().stream().filter(include).toList();
	}
	
	private static boolean isIndustrialShaperRecipe(Recipe<?> recipe) {
		RecipeSerializer<?> serializer = recipe.getSerializer();
		return (
				(serializer == ModCrafting.Recipes.INDUSTRIAL_SHAPER.get())
				);
	}
}
