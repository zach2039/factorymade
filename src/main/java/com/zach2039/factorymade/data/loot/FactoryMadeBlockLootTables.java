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

		// Iron Non-Slip Walkway
		ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		ModBlocks.IRON_NON_SLIP_WALKWAY_SLABS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});

		// Iron Plate
		ModBlocks.IRON_PLATE_BLOCKS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		ModBlocks.IRON_PLATE_STAIRS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		ModBlocks.IRON_PLATE_SLABS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});

		// Iron Grating
		ModBlocks.IRON_GRATING_BLOCKS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		ModBlocks.IRON_GRATING_STAIRS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		ModBlocks.IRON_GRATING_SLABS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		ModBlocks.IRON_GRATING_PANES.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});

		// Iron Truss
		ModBlocks.IRON_TRUSS_BLOCKS.getBlocks().forEach(block -> {
			dropSelf(block.get());
		});
		
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

		// Concrete Siding
		ModBlocks.CONCRETE_SIDING_BLOCKS.getBlocks().forEach(blockReg -> {
			dropSelf(blockReg.get());
		});
		ModBlocks.CONCRETE_SIDING_STAIRS.getBlocks().forEach(blockReg -> {
			dropSelf(blockReg.get());
		});
		ModBlocks.CONCRETE_SIDING_SLABS.getBlocks().forEach(blockReg -> {
			dropSelf(blockReg.get());
		});

		// Asbestos Tiles
		ModBlocks.ASBESTOS_TILES_BLOCKS.getBlocks().forEach(blockReg -> {
			dropSelf(blockReg.get());
		});
		ModBlocks.ASBESTOS_TILES_STAIRS.getBlocks().forEach(blockReg -> {
			dropSelf(blockReg.get());
		});
		ModBlocks.ASBESTOS_TILES_SLABS.getBlocks().forEach(blockReg -> {
			dropSelf(blockReg.get());
		});

		// Computer
		ModBlocks.COMPUTER_BLOCKS.getBlocks().forEach(blockReg -> {
			dropSelf(blockReg.get());
		});

		dropSelf(ModBlocks.FLUORESCENT_LIGHT_PANEL.get());
		dropSelf(ModBlocks.FLUORESCENT_LIGHT_PANEL_SLAB.get());

		dropSelf(ModBlocks.INDUSTRIAL_WALL_LIGHT.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModRegistryUtil.getModRegistryEntries(ForgeRegistries.BLOCKS);
	}
}
