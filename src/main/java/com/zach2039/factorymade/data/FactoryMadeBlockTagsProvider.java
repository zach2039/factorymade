package com.zach2039.factorymade.data;

import javax.annotation.Nullable;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

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
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(ModBlocks.INDUSTRIAL_SHAPER.get())
				
				.add(ModBlocks.IRON_NON_SLIP_WALKWAY.get())
				.add(ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.get())
				.add(ModBlocks.IRON_NON_SLIP_WALKWAY_SLAB.get())
				
				.add(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY.get())
				.add(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS.get())
				.add(ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_SLAB.get())
				
				.add(ModBlocks.IRON_TRUSS.get())
				
				.add(ModBlocks.RUSTED_IRON_TRUSS.get())
				
				.add(ModBlocks.WHITE_CINDER_BLOCK_BRICKS.get())
				.add(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_STAIRS.get())
				.add(ModBlocks.WHITE_CINDER_BLOCK_BRICKS_SLAB.get())
				
				.add(ModBlocks.BLACK_ASBESTOS_TILES.get())
				.add(ModBlocks.BLACK_ASBESTOS_TILES_STAIRS.get())
				.add(ModBlocks.BLACK_ASBESTOS_TILES_SLAB.get())
				;
		
		tag(BlockTags.MINEABLE_WITH_AXE)
				;

		tag(BlockTags.MINEABLE_WITH_SHOVEL)
				;
		
	}
}
