package com.zach2039.factorymade.world.level.block.variant;

import com.zach2039.factorymade.util.ModStringUtil;
import net.minecraft.util.StringRepresentable;

public enum ComputerBlockVariant implements StringRepresentable {
	CASING("casing"),
	CASING_BASE("casing_base"),
	TERMINAL("terminal"),
	TAPE_READER("tape_reader"),
	INSTRUMENTATION("instrumentation"),
	INTERFACE("interface")
	;

	private ComputerBlockVariant(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		String variantName = getSerializedName().replace('_', ' ');
		String displayName = ModStringUtil.capitalizeWords(variantName);
		return displayName;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}

	private final String name;
}
