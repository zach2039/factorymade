package com.zach2039.factorymade.init;

import com.zach2039.factorymade.FactoryMade;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.versions.forge.ForgeVersion;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class ModTags {
	public static class Blocks {
		private static TagKey<Block> tag(final String name) {
			return BlockTags.create(new ResourceLocation(FactoryMade.MODID, name));
		}
	}

	public static class Items {

		// Any Tags
		public static final TagKey<Item> PLATE_BLOCKS_ANY = tag("plate_blocks/any");
		public static final TagKey<Item> NON_SLIP_WALKWAY_BLOCKS_ANY = tag("non_slip_walkway_blocks/any");
		public static final TagKey<Item> TRUSS_BLOCKS_ANY = tag("truss_blocks/any");
		public static final TagKey<Item> GRATING_BLOCKS_ANY = tag("grating_blocks/any");
		public static final TagKey<Item> GRATING_PANES_ANY = tag("grating_panes/any");
		public static final TagKey<Item> ASBESTOS_TILES_BLOCKS_ANY = tag("asbestos_tiles_blocks/any");
		public static final TagKey<Item> CINDER_BLOCK_BRICKS_BLOCKS_ANY = tag("cinder_block_bricks_blocks/any");
		public static final TagKey<Item> CONCRETE_SIDING_BLOCKS_ANY = tag("concrete_siding_blocks/any");
		public static final TagKey<Item> ASPHALT_BLOCKS_ANY = tag("asphalt_blocks/any");
		public static final TagKey<Item> COMPUTER_BLOCKS_ANY = tag("computer_blocks/any");

		// Iron
		public static final TagKey<Item> PLATE_BLOCKS_IRON = tag("plate_blocks/iron");
		public static final TagKey<Item> NON_SLIP_WALKWAY_BLOCKS_IRON = tag("non_slip_walkway_blocks/iron");
		public static final TagKey<Item> TRUSS_BLOCKS_IRON = tag("truss_blocks/iron");
		public static final TagKey<Item> GRATING_BLOCKS_IRON = tag("grating_blocks/iron");
		public static final TagKey<Item> GRATING_PANES_IRON = tag("grating_panes/iron");

		// Lead
		public static final TagKey<Item> PLATE_BLOCKS_LEAD = tag("plate_blocks/lead");
		public static final TagKey<Item> NON_SLIP_WALKWAY_BLOCKS_LEAD = tag("non_slip_walkway_blocks/lead");
		public static final TagKey<Item> TRUSS_BLOCKS_LEAD = tag("truss_blocks/lead");
		public static final TagKey<Item> GRATING_BLOCKS_LEAD = tag("grating_blocks/lead");
		public static final TagKey<Item> GRATING_PANES_LEAD = tag("grating_panes/lead");

		// Forge Tags
		public static final TagKey<Item> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");

		private static TagKey<Item> tag(final String name) {
			return ItemTags.create(new ResourceLocation(FactoryMade.MODID, name));
		}
		
		private static TagKey<Item> forgeTag(final String name) {
			return ItemTags.create(new ResourceLocation(ForgeVersion.MOD_ID, name));
		}
	}
}
