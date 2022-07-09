package com.zach2039.factorymade.compat.jei.category;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.compat.jei.JEIRecipeTypes;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.world.item.crafting.recipe.IndustrialShaperRecipe;

import mezz.jei.api.constants.ModIds;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class IndustrialShaperRecipeCategory implements IRecipeCategory<IndustrialShaperRecipe> {
	public static final ResourceLocation UID = new ResourceLocation(FactoryMade.MODID, "industrial_shaper");
	
	public static final int width = 82;
	public static final int height = 34;

	private final IDrawable background;
	private final IDrawable icon;
	private final Component localizedName;

	public IndustrialShaperRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation(ModIds.JEI_ID, "textures/gui/gui_vanilla.png");
		background = guiHelper.createDrawable(location, 0, 220, width, height);
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.INDUSTRIAL_SHAPER.get()));
		localizedName = Component.translatable("block.factorymade.industrial_shaper");
	}

	@Override
	public RecipeType<IndustrialShaperRecipe> getRecipeType() {
		return JEIRecipeTypes.INDUSTRIAL_SHAPER;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, IndustrialShaperRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 9)
			.addIngredients(recipe.getIngredients().get(0));

		builder.addSlot(RecipeIngredientRole.OUTPUT, 61,  9)
			.addItemStack(recipe.getResultItem());
	}

	@Override
	public boolean isHandled(IndustrialShaperRecipe recipe) {
		return !recipe.isSpecial();
	}

}
