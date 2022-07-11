package com.zach2039.factorymade.data.loot;

import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.util.ModRegistryUtil;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Generates this mod's block loot tables.
 */
public class FactoryMadeBlockLootTables extends BlockLoot {
	@Override
	protected void addTables() {
		dropSelf(ModBlocks.INDUSTRIAL_SHAPER.get());
		
		dropSelf(ModBlocks.IRON_NON_SLIP_WALKWAY.get());
		dropSelf(ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.get());
		dropSelf(ModBlocks.IRON_NON_SLIP_WALKWAY_SLAB.get());
		
		dropSelf(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY.get());
		dropSelf(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS.get());
		dropSelf(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_SLAB.get());

		dropSelf(ModBlocks.IRON_PLATE.get());
		dropSelf(ModBlocks.IRON_PLATE_STAIRS.get());
		dropSelf(ModBlocks.IRON_PLATE_SLAB.get());

		dropSelf(ModBlocks.RUSTED_IRON_PLATE.get());
		dropSelf(ModBlocks.RUSTED_IRON_PLATE_STAIRS.get());
		dropSelf(ModBlocks.RUSTED_IRON_PLATE_SLAB.get());

		dropSelf(ModBlocks.IRON_TRUSS.get());
		
		dropSelf(ModBlocks.RUSTED_IRON_TRUSS.get());
		
		dropSelf(ModBlocks.WHITE_CINDER_BLOCK_BRICKS.get());
		dropSelf(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_STAIRS.get());
		dropSelf(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_SLAB.get());
		
		dropSelf(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS.get());
		dropSelf(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_STAIRS.get());
		dropSelf(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_SLAB.get());
		
		dropSelf(ModBlocks.RED_CINDER_BLOCK_BRICKS.get());
		dropSelf(ModBlocks.RED_CINDER_BLOCK_BRICKS_STAIRS.get());
		dropSelf(ModBlocks.RED_CINDER_BLOCK_BRICKS_SLAB.get());
		
		dropSelf(ModBlocks.BLUE_CINDER_BLOCK_BRICKS.get());
		dropSelf(ModBlocks.BLUE_CINDER_BLOCK_BRICKS_STAIRS.get());
		dropSelf(ModBlocks.BLUE_CINDER_BLOCK_BRICKS_SLAB.get());
		
		dropSelf(ModBlocks.GREEN_CINDER_BLOCK_BRICKS.get());
		dropSelf(ModBlocks.GREEN_CINDER_BLOCK_BRICKS_STAIRS.get());
		dropSelf(ModBlocks.GREEN_CINDER_BLOCK_BRICKS_SLAB.get());
		
		dropSelf(ModBlocks.BROWN_CINDER_BLOCK_BRICKS.get());
		dropSelf(ModBlocks.BROWN_CINDER_BLOCK_BRICKS_STAIRS.get());
		dropSelf(ModBlocks.BROWN_CINDER_BLOCK_BRICKS_SLAB.get());
		
		dropSelf(ModBlocks.CONCRETE_SIDING.get());
		dropSelf(ModBlocks.CONCRETE_SIDING_STAIRS.get());
		dropSelf(ModBlocks.CONCRETE_SIDING_SLAB.get());
		
		dropSelf(ModBlocks.WEATHERED_CONCRETE_SIDING.get());
		dropSelf(ModBlocks.WEATHERED_CONCRETE_SIDING_STAIRS.get());
		dropSelf(ModBlocks.WEATHERED_CONCRETE_SIDING_SLAB.get());
		
		dropSelf(ModBlocks.BLACK_ASBESTOS_TILES.get());
		dropSelf(ModBlocks.BLACK_ASBESTOS_TILES_STAIRS.get());
		dropSelf(ModBlocks.BLACK_ASBESTOS_TILES_SLAB.get());
		
		dropSelf(ModBlocks.WHITE_ASBESTOS_TILES.get());
		dropSelf(ModBlocks.WHITE_ASBESTOS_TILES_STAIRS.get());
		dropSelf(ModBlocks.WHITE_ASBESTOS_TILES_SLAB.get());
		
		dropSelf(ModBlocks.FLUORESCENT_LIGHT_PANEL.get());
		dropSelf(ModBlocks.FLUORESCENT_LIGHT_PANEL_SLAB.get());

		dropSelf(ModBlocks.INDUSTRIAL_WALL_LIGHT.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModRegistryUtil.getModRegistryEntries(ForgeRegistries.BLOCKS);
	}
}
