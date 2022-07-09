package com.zach2039.factorymade.fluid;

import java.util.function.Consumer;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.IFluidTypeRenderProperties;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidType.Properties;

/**
 * Basic implementation of {@link FluidType} that supports specifying still and flowing textures in the constructor.
 *
 * @author Choonster
 */
public class BasicFluidType extends FluidType {
	private final ResourceLocation stillTexture;
	private final ResourceLocation flowingTexture;

	public BasicFluidType(final ResourceLocation stillTexture, final ResourceLocation flowingTexture, final Properties properties) {
		super(properties);
		this.stillTexture = stillTexture;
		this.flowingTexture = flowingTexture;
	}

	public ResourceLocation getStillTexture() {
		return stillTexture;
	}

	public ResourceLocation getFlowingTexture() {
		return flowingTexture;
	}

	@Override
	public void initializeClient(final Consumer<IFluidTypeRenderProperties> consumer) {
		consumer.accept(new IFluidTypeRenderProperties() {
			@Override
			public ResourceLocation getStillTexture() {
				return stillTexture;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return flowingTexture;
			}
		});
	}
}
