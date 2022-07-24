package com.zach2039.factorymade.data;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class FactoryMadeBlockTagsProvider extends BlockTagsProvider {
	
	public FactoryMadeBlockTagsProvider(final DataGenerator generatorIn, @Nullable final ExistingFileHelper existingFileHelper) {
		super(generatorIn, FactoryMade.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		TagsProvider.TagAppender<Block> pickaxeMinable = tag(BlockTags.MINEABLE_WITH_PICKAXE);

		// Iron Plate
		ModBlocks.IRON_PLATE_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.IRON_PLATE_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.IRON_PLATE_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Iron Non-Slip Walkway
		ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.IRON_NON_SLIP_WALKWAY_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Iron Grating
		ModBlocks.IRON_GRATING_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.IRON_GRATING_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.IRON_GRATING_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.IRON_GRATING_PANES.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Iron Truss
		ModBlocks.IRON_TRUSS_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Lead Plate
		ModBlocks.LEAD_PLATE_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.LEAD_PLATE_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.LEAD_PLATE_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Lead Non-Slip Walkway
		ModBlocks.LEAD_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.LEAD_NON_SLIP_WALKWAY_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.LEAD_NON_SLIP_WALKWAY_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Lead Grating
		ModBlocks.LEAD_GRATING_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.LEAD_GRATING_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.LEAD_GRATING_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.LEAD_GRATING_PANES.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Lead Truss
		ModBlocks.LEAD_TRUSS_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Concrete Siding
		ModBlocks.CONCRETE_SIDING_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.CONCRETE_SIDING_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.CONCRETE_SIDING_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Asbestos Tiles
		ModBlocks.ASBESTOS_TILES_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.ASBESTOS_TILES_STAIRS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});
		ModBlocks.ASBESTOS_TILES_SLABS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		// Computer
		ModBlocks.COMPUTER_BLOCKS.getBlocks().forEach(block -> {
			pickaxeMinable.add(block.get());
		});

		pickaxeMinable
				.add(ModBlocks.INDUSTRIAL_SHAPER.get())
				
				.add(ModBlocks.WHITE_CINDER_BLOCK_BRICKS.get())
				.add(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_STAIRS.get())
				.add(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_SLAB.get())
				
				.add(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS.get())
				.add(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_STAIRS.get())
				.add(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_SLAB.get())
				
				.add(ModBlocks.RED_CINDER_BLOCK_BRICKS.get())
				.add(ModBlocks.RED_CINDER_BLOCK_BRICKS_STAIRS.get())
				.add(ModBlocks.RED_CINDER_BLOCK_BRICKS_SLAB.get())
				
				.add(ModBlocks.BLUE_CINDER_BLOCK_BRICKS.get())
				.add(ModBlocks.BLUE_CINDER_BLOCK_BRICKS_STAIRS.get())
				.add(ModBlocks.BLUE_CINDER_BLOCK_BRICKS_SLAB.get())
				
				.add(ModBlocks.GREEN_CINDER_BLOCK_BRICKS.get())
				.add(ModBlocks.GREEN_CINDER_BLOCK_BRICKS_STAIRS.get())
				.add(ModBlocks.GREEN_CINDER_BLOCK_BRICKS_SLAB.get())
				
				.add(ModBlocks.BROWN_CINDER_BLOCK_BRICKS.get())
				.add(ModBlocks.BROWN_CINDER_BLOCK_BRICKS_STAIRS.get())
				.add(ModBlocks.BROWN_CINDER_BLOCK_BRICKS_SLAB.get())
				
				.add(ModBlocks.FLUORESCENT_LIGHT_PANEL.get())
				.add(ModBlocks.FLUORESCENT_LIGHT_PANEL_SLAB.get())

				.add(ModBlocks.INDUSTRIAL_WALL_LIGHT.get())
				;
		
		tag(BlockTags.MINEABLE_WITH_AXE)
				;

		tag(BlockTags.MINEABLE_WITH_SHOVEL)
				;
		
	}
}
