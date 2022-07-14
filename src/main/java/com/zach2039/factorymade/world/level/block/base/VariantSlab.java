package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.SlabBlockVariantGroup;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.SlabBlock;

public class VariantSlab extends SlabBlock implements IBlockVariant {
	private final SlabBlockVariantGroup<? extends StringRepresentable, ? extends VariantSlab> variantGroup;
	private final StringRepresentable type;

	public VariantSlab(final StringRepresentable type, final SlabBlockVariantGroup<? extends StringRepresentable, ? extends VariantSlab> variantGroup, final Properties properties) {
		super(properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
