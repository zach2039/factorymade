package com.zach2039.factorymade.world.level.block.variant;

import net.minecraft.util.StringRepresentable;

public enum SimpleMetalBlockVariant implements StringRepresentable {
	CLEAN("clean"),
	RUSTED( "rusted")
	;

	private SimpleMetalBlockVariant(String name) {
		this.name = name;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}

	private final String name;
}
