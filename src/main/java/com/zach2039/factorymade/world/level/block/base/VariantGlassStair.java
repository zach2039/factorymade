package com.zach2039.factorymade.world.level.block.base;

import com.zach2039.factorymade.world.level.block.variant.IBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.GlassStairBlockVariantGroup;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class VariantGlassStair extends GlassStairBlock implements IBlockVariant {
	private final GlassStairBlockVariantGroup<? extends StringRepresentable, ? extends VariantGlassStair> variantGroup;
	private final StringRepresentable type;

	public VariantGlassStair(final StringRepresentable type, final GlassStairBlockVariantGroup<? extends StringRepresentable, ? extends VariantGlassStair> variantGroup, final Supplier<BlockState> blockstateSupplier, final Properties properties) {
		super(blockstateSupplier, properties);
		this.type = type;
		this.variantGroup = variantGroup;
	}

	@Override
	public StringRepresentable getType() {
		return type;
	}
}
