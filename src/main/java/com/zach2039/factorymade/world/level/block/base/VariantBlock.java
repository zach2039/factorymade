package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.BlockVariantGroup;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;

public class VariantBlock extends Block implements IBlockVariant {
	private final BlockVariantGroup<? extends StringRepresentable, ? extends VariantBlock> variantGroup;
	private StringRepresentable type;
	public VariantBlock(final StringRepresentable type, final BlockVariantGroup<? extends StringRepresentable, ? extends VariantBlock> variantGroup, final Block.Properties properties) {
		super(properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
