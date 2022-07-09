package com.zach2039.factorymade.client.gui;

import com.zach2039.factorymade.FactoryMade;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class GuiIDs {
	/**
	 * IDs for {@link AbstractContainerScreen} classes opened with {@link NetworkHooks#openGui}/{@link PlayMessages.OpenContainer}.
	 */
	public static class Container {
		public static final ResourceLocation INDUSTRIAL_SHAPER = id("chest");
	}

	/**
	 * IDs for {@link Screen} classes opened with {@link OpenClientScreenMessage}.
	 */
	public static class Client {

	}

	private static ResourceLocation id(final String id) {
		return new ResourceLocation(FactoryMade.MODID, id);
	}
}
