package com.zach2039.factorymade.event;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = FactoryMade.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MissingMappingsEventHandler {
	/***
	 * Replace mappings if update is made that alters registry names
	 * @param event
	 */
	@SubscribeEvent
	public static void replaceMappings(final MissingMappingsEvent event) {
		for (MissingMappingsEvent.Mapping missing : event.getAllMappings(ForgeRegistries.BLOCKS.getRegistryKey())) {
			if (missing.getKey().toString().contains(FactoryMade.MODID)) {
				FactoryMade.LOGGER.info("Missing mapping is of namespace: " + FactoryMade.MODID);
				FactoryMade.LOGGER.info("Trying to find replacement for missing block: " + missing.getKey());
				for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
					if (missing.getKey().toString().equals(block.getKey().location().toString().replace("clean_", ""))) {
						FactoryMade.LOGGER.info("Replacing " + missing.getKey() + " with " + block.getKey());
						missing.remap(block.get());
						break;
					}
				}
			}
		}
	}
}
