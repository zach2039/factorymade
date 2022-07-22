package com.zach2039.factorymade.init;

import com.zach2039.factorymade.FactoryMade;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
		
		private static TagKey<Item> tag(final String name) {
			return ItemTags.create(new ResourceLocation(FactoryMade.MODID, name));
		}
		
		private static TagKey<Item> forgeTag(final String name) {
			return ItemTags.create(new ResourceLocation(ForgeVersion.MOD_ID, name));
		}
	}
}
