package com.zach2039.factorymade;

import com.zach2039.factorymade.init.ModBlocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FactoryMadeCreativeModeTab extends CreativeModeTab {
	private final ItemStack itemstackIcon;
	
	public FactoryMadeCreativeModeTab()	{
		super(FactoryMade.MODID);
		itemstackIcon = new ItemStack(ModBlocks.INDUSTRIAL_SHAPER.get());
	}

	@Override
	public ItemStack makeIcon()	{
		return this.itemstackIcon;
	}
	
	@Override
	public void fillItemList(final NonNullList<ItemStack> items) {
		super.fillItemList(items);
	}
}
