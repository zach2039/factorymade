package com.zach2039.factorymade.data;

import java.util.function.Consumer;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.data.recipes.IndustrialShaperRecipeBuilder;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.util.ModRegistryUtil;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;

public class FactoryMadeRecipeProvider extends RecipeProvider {

	public FactoryMadeRecipeProvider(final DataGenerator dataGenerator) {
		super(dataGenerator);
	}
	
	@Override
	protected void buildCraftingRecipes(final Consumer<FinishedRecipe> recipeConsumer) {
		// Industrial Shaper
		{
			ShapedRecipeBuilder.shaped(ModBlocks.INDUSTRIAL_SHAPER.get())
						.pattern(" I")
						.pattern("IL")
						.pattern(" S")
						.define('I', Ingredient.of(Items.IRON_INGOT))
						.define('L', Ingredient.of(Items.LEVER))
						.define('S', Ingredient.of(Blocks.SMITHING_TABLE))
						.unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
						.unlockedBy("has_lever", has(Items.LEVER))
						.unlockedBy("has_smithing_table", has(Blocks.SMITHING_TABLE))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "industrial_shaper"));
		}
		
		// Iron Non-Slip Walkway
		{
			IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(Blocks.IRON_BLOCK), ModBlocks.IRON_NON_SLIP_WALKWAY.get(), 16)
						.unlockedBy("has_iron_block", has(Blocks.IRON_BLOCK))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "iron_non_slip_walkway"));			
			addSlabRecipes(recipeConsumer, ModBlocks.IRON_NON_SLIP_WALKWAY.get(), ModBlocks.IRON_NON_SLIP_WALKWAY_SLAB.get());
			addStairRecipes(recipeConsumer, ModBlocks.IRON_NON_SLIP_WALKWAY.get(), ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.get());
		}
		
		// Rusted Iron Non-Slip Walkway
		{
			IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(Blocks.IRON_BLOCK), ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY.get(), 16)
						.unlockedBy("has_iron_block", has(Blocks.IRON_BLOCK))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "rusted_iron_non_slip_walkway"));			
			addSlabRecipes(recipeConsumer, ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY.get(), ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_SLAB.get());
			addStairRecipes(recipeConsumer, ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY.get(), ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS.get());
		}
		
		// Iron Truss
		{
			IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(Blocks.IRON_BLOCK), ModBlocks.IRON_TRUSS.get(), 16)
						.unlockedBy("has_iron_block", has(Blocks.IRON_BLOCK))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "iron_truss"));			
		}
		
		// Rusted Iron Truss
		{
			IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(Blocks.IRON_BLOCK), ModBlocks.RUSTED_IRON_TRUSS.get(), 16)
						.unlockedBy("has_iron_block", has(Blocks.IRON_BLOCK))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "rusted_iron_truss"));			
		}
	}

	private void addSlabRecipes(final Consumer<FinishedRecipe> recipeConsumer, Block inputBlock, SlabBlock outputSlab) {
		ShapedRecipeBuilder.shaped(outputSlab, 3)
						.pattern("BBB")
						.define('B', Ingredient.of(inputBlock))
						.unlockedBy("has_block", has(inputBlock))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, ModRegistryUtil.getKey(inputBlock).getPath() + "_slab"));
		
		IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(inputBlock), outputSlab, 2)
						.unlockedBy("has_block", has(inputBlock))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, ModRegistryUtil.getKey(inputBlock).getPath() + "_slab_from_shaper"));
	}
	
	private void addStairRecipes(final Consumer<FinishedRecipe> recipeConsumer, Block inputBlock, StairBlock outputStair) {
		ShapedRecipeBuilder.shaped(outputStair, 4)
						.pattern("B  ")
						.pattern("BB ")
						.pattern("BBB")
						.define('B', Ingredient.of(inputBlock))
						.unlockedBy("has_block", has(inputBlock))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, ModRegistryUtil.getKey(inputBlock).getPath() + "_stair"));
		
		IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(inputBlock), outputStair, 1)
						.unlockedBy("has_block", has(inputBlock))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, ModRegistryUtil.getKey(inputBlock).getPath() + "_stair_from_shaper"));
	}
	
	@Override
	public String getName() {
		return "FactoryMadeRecipes";
	}
}
