package com.zach2039.factorymade.data;

import java.util.function.Consumer;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.data.recipes.IndustrialShaperRecipeBuilder;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.util.ModRegistryUtil;

import com.zach2039.factorymade.world.level.block.variant.ComputerBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleConcreteBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleMetalBlockVariant;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

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
			ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
				addBlockStairSlab(recipeConsumer,
						Blocks.IRON_BLOCK,
						block.get(), 16,
						ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get(),
						ModBlocks.IRON_NON_SLIP_WALKWAY_SLABS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
				);
			});
		}

		// Iron Plate
		{
			ModBlocks.IRON_PLATE_BLOCKS.getBlocks().forEach(block -> {
				addBlockStairSlab(recipeConsumer,
						Blocks.IRON_BLOCK,
						block.get(), 16,
						ModBlocks.IRON_PLATE_STAIRS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get(),
						ModBlocks.IRON_PLATE_SLABS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
				);
			});
		}

		// Iron Grating
		{
			ModBlocks.IRON_GRATING_BLOCKS.getBlocks().forEach(block -> {
				addBlockStairSlabPane(recipeConsumer,
						Blocks.IRON_BLOCK,
						block.get(), 16,
						ModBlocks.IRON_GRATING_STAIRS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get(),
						ModBlocks.IRON_GRATING_SLABS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get(),
						ModBlocks.IRON_GRATING_PANES.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
				);
			});
		}

		// Iron Truss
		{
			ModBlocks.IRON_TRUSS_BLOCKS.getBlocks().forEach(block -> {
				addBlockRecipe(recipeConsumer,
						Blocks.IRON_BLOCK,
						block.get(), 16
				);
			});
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
			ModBlocks.CONCRETE_SIDING_BLOCKS.getBlocks().forEach(block -> {
				addBlockStairSlab(recipeConsumer,
						Blocks.WHITE_CONCRETE,
						block.get(), 4,
						ModBlocks.CONCRETE_SIDING_STAIRS.getBlock((SimpleConcreteBlockVariant) block.get().getType()).get(),
						ModBlocks.CONCRETE_SIDING_SLABS.getBlock((SimpleConcreteBlockVariant) block.get().getType()).get()
				);
			});
		}
		
		// Asbestos Tiles
		{
			ModBlocks.ASBESTOS_TILES_BLOCKS.getBlocks().forEach(block -> {
				addBlockStairSlab(recipeConsumer,
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation(block.get().getType().getSerializedName() + "_concrete")),
						block.get(), 4,
						ModBlocks.ASBESTOS_TILES_STAIRS.getBlock((DyeColor) block.get().getType()).get(),
						ModBlocks.ASBESTOS_TILES_SLABS.getBlock((DyeColor) block.get().getType()).get()
				);
			});
		}

		// Computer
		{
			final var parentBlock = ModBlocks.COMPUTER_BLOCKS.getBlock(ComputerBlockVariant.CASING).get();
			final var ironPlateBlock = ModBlocks.IRON_PLATE_BLOCKS.getBlock(SimpleMetalBlockVariant.CLEAN).get();

			ShapedRecipeBuilder.shaped(parentBlock, 2)
					.pattern("PR")
					.pattern("RP")
					.define('P', ironPlateBlock)
					.define('R', Ingredient.of(Items.REDSTONE))
					.unlockedBy("has_iron_plate", has(ironPlateBlock))
					.unlockedBy("has_redstone", has(Items.REDSTONE))
					.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, "computer_casing"));

			ModBlocks.COMPUTER_BLOCKS.getBlocks().forEach(blockReg -> {
				final var block = blockReg.get();
				if (block.getType() != parentBlock.getType()) {
					addBlockRecipe(recipeConsumer, parentBlock, block, 1);
				}
			});
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

	private void addBlockRecipe(final Consumer<FinishedRecipe> recipeConsumer, Block inputBlock, Block outputBlock, int count) {
		IndustrialShaperRecipeBuilder.industrialshaper(Ingredient.of(inputBlock), outputBlock, count)
				.unlockedBy("has_block", has(inputBlock))
				.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, ModRegistryUtil.getKey(outputBlock).getPath()));
	}

	private void addPaneRecipe(final Consumer<FinishedRecipe> recipeConsumer, Block inputBlock, IronBarsBlock outputPane) {
		ShapedRecipeBuilder.shaped(outputPane, 16)
				.pattern("BBB")
				.pattern("BBB")
				.define('B', Ingredient.of(inputBlock))
				.unlockedBy("has_block", has(inputBlock))
				.save(recipeConsumer, new ResourceLocation(FactoryMade.MODID, ModRegistryUtil.getKey(inputBlock).getPath() + "_pane"));
	}

	private void addSlabRecipes(final Consumer<FinishedRecipe> recipeConsumer, Block inputBlock, SlabBlock outputSlab) {
		ShapedRecipeBuilder.shaped(outputSlab, 6)
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
		addBlockRecipe(recipeConsumer,inputBlock, outputBlock, count);
		addStairRecipes(recipeConsumer, outputBlock, outputStair);
		addSlabRecipes(recipeConsumer, outputBlock, outputSlab);
	}

	private void addBlockStairSlabPane(final Consumer<FinishedRecipe> recipeConsumer, Block inputBlock, Block outputBlock, int count, StairBlock outputStair, SlabBlock outputSlab, IronBarsBlock outputPane) {
		addBlockStairSlab(recipeConsumer, inputBlock, outputBlock, count, outputStair, outputSlab);
		addPaneRecipe(recipeConsumer, outputBlock, outputPane);
	}
	
	@Override
	public String getName() {
		return "FactoryMadeRecipes";
	}
}
