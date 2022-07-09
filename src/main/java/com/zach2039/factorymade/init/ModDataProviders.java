package com.zach2039.factorymade.init;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.data.FactoryMadeBlockStateProvider;
import com.zach2039.factorymade.data.FactoryMadeBlockTagsProvider;
import com.zach2039.factorymade.data.FactoryMadeItemModelProvider;
import com.zach2039.factorymade.data.FactoryMadeItemTagsProvider;
import com.zach2039.factorymade.data.FactoryMadeLanguageProvider;
import com.zach2039.factorymade.data.FactoryMadeLootTableProvider;
import com.zach2039.factorymade.data.FactoryMadeRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = FactoryMade.MODID, bus = Bus.MOD)
public class ModDataProviders {

	@SubscribeEvent
	public static void registerDataProviders(final GatherDataEvent event) {
		final DataGenerator dataGenerator = event.getGenerator();
		final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		dataGenerator.addProvider(event.includeClient(), new FactoryMadeLanguageProvider(dataGenerator));
		
		final FactoryMadeItemModelProvider itemModelProvider = new FactoryMadeItemModelProvider(dataGenerator, existingFileHelper);
		dataGenerator.addProvider(event.includeClient(), itemModelProvider);

		// Let blockstate provider see generated item models by passing its existing file helper
		dataGenerator.addProvider(event.includeClient(), new FactoryMadeBlockStateProvider(dataGenerator, itemModelProvider.existingFileHelper));
		
		dataGenerator.addProvider(event.includeServer(), new FactoryMadeRecipeProvider(dataGenerator));
		dataGenerator.addProvider(event.includeServer(), new FactoryMadeLootTableProvider(dataGenerator));

		final FactoryMadeBlockTagsProvider blockTagsProvider = new FactoryMadeBlockTagsProvider(dataGenerator, existingFileHelper);
		dataGenerator.addProvider(event.includeServer(), blockTagsProvider);
		dataGenerator.addProvider(event.includeServer(), new FactoryMadeItemTagsProvider(dataGenerator, blockTagsProvider, existingFileHelper));
	}
	
}
