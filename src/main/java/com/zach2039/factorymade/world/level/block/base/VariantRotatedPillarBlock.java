package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.BlockVariantGroup;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class VariantRotatedPillarBlock extends RotatedPillarBlock implements IBlockVariant {
	private final BlockVariantGroup<? extends StringRepresentable, ? extends VariantRotatedPillarBlock> variantGroup;
	private StringRepresentable type;

	public VariantRotatedPillarBlock(final StringRepresentable type, final BlockVariantGroup<? extends StringRepresentable, ? extends VariantRotatedPillarBlock> variantGroup, final Properties properties) {
		super(properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
