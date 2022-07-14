package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.GlassSlabBlockVariantGroup;
import net.minecraft.util.StringRepresentable;

public class VariantGlassSlab extends GlassSlabBlock implements IBlockVariant {
	private final GlassSlabBlockVariantGroup<? extends StringRepresentable, ? extends VariantGlassSlab> variantGroup;
	private final StringRepresentable type;

	public VariantGlassSlab(final StringRepresentable type, final GlassSlabBlockVariantGroup<? extends StringRepresentable, ? extends VariantGlassSlab> variantGroup, final Properties properties) {
		super(properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
