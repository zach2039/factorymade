package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.PaneBlockVariantGroup;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.IronBarsBlock;

public class VariantPane extends IronBarsBlock implements IBlockVariant {
	private final PaneBlockVariantGroup<? extends StringRepresentable, ? extends VariantPane> variantGroup;
	private final StringRepresentable type;

	public VariantPane(final StringRepresentable type, final PaneBlockVariantGroup<? extends StringRepresentable, ? extends VariantPane> variantGroup, final Properties properties) {
		super(properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
