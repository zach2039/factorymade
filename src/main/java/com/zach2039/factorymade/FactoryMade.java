package com.zach2039.factorymade;

import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.init.ModCrafting;
import com.zach2039.factorymade.init.ModMenuTypes;
import com.zach2039.factorymade.init.ModRecipeTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@Mod(FactoryMade.MODID)
@Mod.EventBusSubscriber(modid = FactoryMade.MODID, bus = Bus.MOD)
public class FactoryMade
{
    public static Logger LOGGER = LogManager.getLogger(FactoryMade.MODID);
	
	public static final String MODID = "factorymade";
	public static final String NAME = "Factory Made";

	//public static final SimpleChannel NETWORK = ModNetwork.getNetworkChannel();

    public FactoryMade() {
    	//FactoryMadeConfig.register(ModLoadingContext.get());

		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModBlocks.initialize(modEventBus);
		ModMenuTypes.initialize(modEventBus);
		ModRecipeTypes.initialize(modEventBus);
		ModCrafting.Recipes.initialize(modEventBus);
    }

    @SubscribeEvent
	public static void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
		
		});
	}

	@SubscribeEvent
	public static void enqueue(final InterModEnqueueEvent event) {

	}

	public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab(MODID)
	{
		@Override
		@Nonnull
		public ItemStack makeIcon()
		{
			return new ItemStack(ModBlocks.INDUSTRIAL_SHAPER.get());
		}
	};
}
