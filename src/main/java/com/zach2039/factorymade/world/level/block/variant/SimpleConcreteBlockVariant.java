package com.zach2039.factorymade.world.level.block.variant;

import net.minecraft.util.StringRepresentable;

public enum SimpleConcreteBlockVariant implements StringRepresentable {
	CLEAN("clean"),
	WEATHERED( "weathered")
	;

	private SimpleConcreteBlockVariant(String name) {
		this.name = name;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}

	private final String name;
}
