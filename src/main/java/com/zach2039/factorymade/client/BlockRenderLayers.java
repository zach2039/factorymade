package com.zach2039.factorymade.client;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = FactoryMade.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class BlockRenderLayers
{
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent ev)
	{
		setRenderLayer(ModBlocks.INDUSTRIAL_WALL_LIGHT, RenderType.translucent(), RenderType.cutoutMipped());

		// Iron Grating
		ModBlocks.IRON_GRATING_BLOCKS.getBlocks().forEach(block ->
			setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);
		ModBlocks.IRON_GRATING_STAIRS.getBlocks().forEach(block ->
			setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);
		ModBlocks.IRON_GRATING_SLABS.getBlocks().forEach(block ->
			setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);
		ModBlocks.IRON_GRATING_PANES.getBlocks().forEach(block ->
			setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);

		// Lead Grating
		ModBlocks.LEAD_GRATING_BLOCKS.getBlocks().forEach(block ->
				setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);
		ModBlocks.LEAD_GRATING_STAIRS.getBlocks().forEach(block ->
				setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);
		ModBlocks.LEAD_GRATING_SLABS.getBlocks().forEach(block ->
				setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);
		ModBlocks.LEAD_GRATING_PANES.getBlocks().forEach(block ->
				setRenderLayer(block, RenderType.translucent(), RenderType.cutoutMipped())
		);
	}

	private static void setRenderLayer(Supplier<? extends Block> supplier, RenderType type)
	{
		ItemBlockRenderTypes.setRenderLayer(supplier.get(), type);
	}

	private static void setRenderLayer(Supplier<? extends Block> supplier, RenderType... types)
	{
		ItemBlockRenderTypes.setRenderLayer(supplier.get(), t -> {
			for(RenderType allowed : types)
				if(t == allowed)
					return true;
			return false;
		});
	}
}
