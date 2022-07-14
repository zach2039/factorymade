package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.StairBlockVariantGroup;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class VariantStair extends StairBlock implements IBlockVariant {
	private final StairBlockVariantGroup<? extends StringRepresentable, ? extends VariantStair> variantGroup;
	private final StringRepresentable type;

	public VariantStair(final StringRepresentable type, final StairBlockVariantGroup<? extends StringRepresentable, ? extends VariantStair> variantGroup, final Supplier<BlockState> blockstateSupplier, final Properties properties) {
		super(blockstateSupplier, properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
