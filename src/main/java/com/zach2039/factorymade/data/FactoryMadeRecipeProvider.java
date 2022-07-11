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
			addBlockStairSlab(recipeConsumer, 
					Blocks.IRON_BLOCK, 
					ModBlocks.IRON_NON_SLIP_WALKWAY.get(), 16, 
					ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.get(),
					ModBlocks.IRON_NON_SLIP_WALKWAY_SLAB.get()
					);
		}
		
		// Rusted Iron Non-Slip Walkway
		{
			addBlockStairSlab(recipeConsumer, 
					Blocks.IRON_BLOCK, 
					ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY.get(), 16, 
					ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS.get(),
					ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_SLAB.get()
					);
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
		
		// Cinder Block Bricks
		{
			addBlockStairSlab(recipeConsumer, 
					Blocks.WHITE_CONCRETE, 
					ModBlocks.WHITE_CINDER_BLOCK_BRICKS.get(), 4, 
					ModBlocks.WHITE_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.WHITE_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			addBlockStairSlab(recipeConsumer, 
					Blocks.YELLOW_CONCRETE, 
					ModBlocks.YELLOW_CINDER_BLOCK_BRICKS.get(), 4, 
					ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			addBlockStairSlab(recipeConsumer, 
					Blocks.RED_CONCRETE, 
					ModBlocks.RED_CINDER_BLOCK_BRICKS.get(), 4, 
					ModBlocks.RED_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.RED_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			addBlockStairSlab(recipeConsumer, 
					Blocks.BLUE_CONCRETE, 
					ModBlocks.BLUE_CINDER_BLOCK_BRICKS.get(), 4, 
					ModBlocks.BLUE_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.BLUE_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			addBlockStairSlab(recipeConsumer, 
					Blocks.GREEN_CONCRETE, 
					ModBlocks.GREEN_CINDER_BLOCK_BRICKS.get(), 4, 
					ModBlocks.GREEN_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.GREEN_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			addBlockStairSlab(recipeConsumer, 
					Blocks.BROWN_CONCRETE, 
					ModBlocks.BROWN_CINDER_BLOCK_BRICKS.get(), 4, 
					ModBlocks.BROWN_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.BROWN_CINDER_BLOCK_BRICKS_SLAB.get()
					);
		}
		
		// Concrete Siding
		{
			addBlockStairSlab(recipeConsumer, 
					Blocks.WHITE_CONCRETE, 
					ModBlocks.CONCRETE_SIDING.get(), 4, 
					ModBlocks.CONCRETE_SIDING_STAIRS.get(),
					ModBlocks.CONCRETE_SIDING_SLAB.get()
					);
			
			addBlockStairSlab(recipeConsumer, 
					Blocks.WHITE_CONCRETE, 
					ModBlocks.WEATHERED_CONCRETE_SIDING.get(), 4, 
					ModBlocks.WEATHERED_CONCRETE_SIDING_STAIRS.get(),
					ModBlocks.WEATHERED_CONCRETE_SIDING_SLAB.get()
					);
		}
		
		// Asbestos Tiles
		{
			addBlockStairSlab(recipeConsumer, 
					Blocks.BLACK_CONCRETE, 
					ModBlocks.BLACK_ASBESTOS_TILES.get(), 4, 
					ModBlocks.BLACK_ASBESTOS_TILES_STAIRS.get(),
					ModBlocks.BLACK_ASBESTOS_TILES_SLAB.get()
					);
			
			addBlockStairSlab(recipeConsumer, 
					Blocks.WHITE_CONCRETE, 
					ModBlocks.WHITE_ASBESTOS_TILES.get(), 4, 
					ModBlocks.WHITE_ASBESTOS_TILES_STAIRS.get(),
					ModBlocks.WHITE_ASBESTOS_TILES_SLAB.get()
					);
		}
		
		// Fluorescent Light Panel
		{
			IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(Blocks.GLOWSTONE), ModBlocks.FLUORESCENT_LIGHT_PANEL.get(), 2)
						.unlockedBy("has_glowstone", has(Blocks.GLOWSTONE))
						.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "fluorescent_light_panel"));			
			addSlabRecipes(recipeConsumer, ModBlocks.FLUORESCENT_LIGHT_PANEL.get(), ModBlocks.FLUORESCENT_LIGHT_PANEL_SLAB.get());
		}

		// Industrial Wall Light
		{
			ShapedRecipeBuilder.shaped(ModBlocks.INDUSTRIAL_WALL_LIGHT.get(), 2)
					.pattern("iii")
					.pattern("ifi")
					.pattern("iii")
					.define('i', Ingredient.of(Items.IRON_NUGGET))
					.define('f', Ingredient.of(ModBlocks.FLUORESCENT_LIGHT_PANEL.get()))
					.unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
					.unlockedBy("has_fluorescent_light_panel", has(ModBlocks.FLUORESCENT_LIGHT_PANEL.get()))
					.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "industrial_wall_light"));
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
	
	private void addBlockStairSlab(final Consumer<FinishedRecipe> recipeConsumer, Block inputBlock, Block outputBlock, int count, StairBlock outputStair, SlabBlock outputSlab) {
		IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(inputBlock), outputBlock, count)
				.unlockedBy("has_block", has(inputBlock))
				.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, ModRegistryUtil.getKey(outputBlock).getPath()));			
		addStairRecipes(recipeConsumer, outputBlock, outputStair);
		addSlabRecipes(recipeConsumer, outputBlock, outputSlab);
	}
	
	@Override
	public String getName() {
		return "FactoryMadeRecipes";
	}
}
