package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.GlassBlockVariantGroup;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.GlassBlock;

public class VariantGlassBlock extends GlassBlock implements IBlockVariant {
	private final GlassBlockVariantGroup<? extends StringRepresentable, ? extends VariantGlassBlock> variantGroup;
	private StringRepresentable type;
	public VariantGlassBlock(final StringRepresentable type, final GlassBlockVariantGroup<? extends StringRepresentable, ? extends VariantGlassBlock> variantGroup, final Properties properties) {
		super(properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
