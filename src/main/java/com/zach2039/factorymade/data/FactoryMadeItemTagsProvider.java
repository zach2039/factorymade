package com.zach2039.factorymade.data;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class FactoryMadeItemTagsProvider extends ItemTagsProvider {

	public FactoryMadeItemTagsProvider(final DataGenerator dataGenerator, final BlockTagsProvider blockTagProvider, @Nullable final ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, FactoryMade.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		final var plateBlocksAny = tag(ModTags.Items.PLATE_BLOCKS_ANY);
		plateBlocksAny.addTags(ModTags.Items.PLATE_BLOCKS_IRON);
		plateBlocksAny.addTags(ModTags.Items.PLATE_BLOCKS_LEAD);

		final var nonSlipWalkwayBlocksAny = tag(ModTags.Items.NON_SLIP_WALKWAY_BLOCKS_ANY);
		nonSlipWalkwayBlocksAny.addTags(ModTags.Items.NON_SLIP_WALKWAY_BLOCKS_IRON);
		nonSlipWalkwayBlocksAny.addTags(ModTags.Items.NON_SLIP_WALKWAY_BLOCKS_LEAD);

		final var trussBlocksAny = tag(ModTags.Items.TRUSS_BLOCKS_ANY);
		trussBlocksAny.addTags(ModTags.Items.TRUSS_BLOCKS_IRON);
		trussBlocksAny.addTags(ModTags.Items.TRUSS_BLOCKS_LEAD);

		final var gratingBlocksAny = tag(ModTags.Items.GRATING_BLOCKS_ANY);
		gratingBlocksAny.addTags(ModTags.Items.GRATING_BLOCKS_IRON);
		gratingBlocksAny.addTags(ModTags.Items.GRATING_BLOCKS_LEAD);

		final var gratingPanesAny = tag(ModTags.Items.GRATING_PANES_ANY);
		gratingPanesAny.addTags(ModTags.Items.GRATING_PANES_IRON);
		gratingPanesAny.addTags(ModTags.Items.GRATING_PANES_LEAD);

		final var asbestosTilesBlocksAny = tag(ModTags.Items.ASBESTOS_TILES_BLOCKS_ANY);
		ModBlocks.ASBESTOS_TILES_BLOCKS.getBlocks().forEach(block -> {
			asbestosTilesBlocksAny.add(block.get().asItem());
		});

		final var cinderBlockBricksBlocksAny = tag(ModTags.Items.CINDER_BLOCK_BRICKS_BLOCKS_ANY);
		cinderBlockBricksBlocksAny.add(ModBlocks.BLUE_CINDER_BLOCK_BRICKS.get().asItem());
		cinderBlockBricksBlocksAny.add(ModBlocks.BROWN_CINDER_BLOCK_BRICKS.get().asItem());
		cinderBlockBricksBlocksAny.add(ModBlocks.GREEN_CINDER_BLOCK_BRICKS.get().asItem());
		cinderBlockBricksBlocksAny.add(ModBlocks.RED_CINDER_BLOCK_BRICKS.get().asItem());
		cinderBlockBricksBlocksAny.add(ModBlocks.YELLOW_CINDER_BLOCK_BRICKS.get().asItem());
		cinderBlockBricksBlocksAny.add(ModBlocks.WHITE_CINDER_BLOCK_BRICKS.get().asItem());

		final var concreteSidingBlocksAny = tag(ModTags.Items.CONCRETE_SIDING_BLOCKS_ANY);
		ModBlocks.CONCRETE_SIDING_BLOCKS.getBlocks().forEach(block -> {
			concreteSidingBlocksAny.add(block.get().asItem());
		});

		final var computerBlocksAny = tag(ModTags.Items.COMPUTER_BLOCKS_ANY);
		ModBlocks.COMPUTER_BLOCKS.getBlocks().forEach(block -> {
			computerBlocksAny.add(block.get().asItem());
		});

		final var plateBlocksIron = tag(ModTags.Items.PLATE_BLOCKS_IRON);
		ModBlocks.IRON_PLATE_BLOCKS.getBlocks().forEach(block -> {
			plateBlocksIron.add(block.get().asItem());
		});

		final var nonSlipWalkwayBlocksIron = tag(ModTags.Items.NON_SLIP_WALKWAY_BLOCKS_IRON);
		ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
			nonSlipWalkwayBlocksIron.add(block.get().asItem());
		});

		final var trussBlocksIron = tag(ModTags.Items.TRUSS_BLOCKS_IRON);
		ModBlocks.IRON_TRUSS_BLOCKS.getBlocks().forEach(block -> {
			trussBlocksIron.add(block.get().asItem());
		});

		final var gratingBlocksIron = tag(ModTags.Items.GRATING_BLOCKS_IRON);
		ModBlocks.IRON_GRATING_BLOCKS.getBlocks().forEach(block -> {
			gratingBlocksIron.add(block.get().asItem());
		});

		final var gratingPanesIron = tag(ModTags.Items.GRATING_PANES_IRON);
		ModBlocks.IRON_GRATING_PANES.getBlocks().forEach(block -> {
			gratingPanesIron.add(block.get().asItem());
		});

		final var plateBlocksLead = tag(ModTags.Items.PLATE_BLOCKS_LEAD);
		ModBlocks.LEAD_PLATE_BLOCKS.getBlocks().forEach(block -> {
			plateBlocksLead.add(block.get().asItem());
		});

		final var nonSlipWalkwayBlocksLead = tag(ModTags.Items.NON_SLIP_WALKWAY_BLOCKS_LEAD);
		ModBlocks.LEAD_NON_SLIP_WALKWAY_BLOCKS.getBlocks().forEach(block -> {
			nonSlipWalkwayBlocksLead.add(block.get().asItem());
		});

		final var trussBlocksLead = tag(ModTags.Items.TRUSS_BLOCKS_LEAD);
		ModBlocks.LEAD_TRUSS_BLOCKS.getBlocks().forEach(block -> {
			trussBlocksLead.add(block.get().asItem());
		});

		final var gratingBlocksLead = tag(ModTags.Items.GRATING_BLOCKS_LEAD);
		ModBlocks.LEAD_GRATING_BLOCKS.getBlocks().forEach(block -> {
			gratingBlocksLead.add(block.get().asItem());
		});

		final var gratingPanesLead = tag(ModTags.Items.GRATING_PANES_LEAD);
		ModBlocks.LEAD_GRATING_PANES.getBlocks().forEach(block -> {
			gratingPanesLead.add(block.get().asItem());
		});
	}
}


