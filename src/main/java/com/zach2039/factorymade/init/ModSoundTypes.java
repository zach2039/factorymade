package com.zach2039.factorymade.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;

public class ModSoundTypes {

	public static final ForgeSoundType METAL = new ForgeSoundType(1.0F, 0.8F, () -> SoundEvents.COPPER_BREAK, () -> SoundEvents.COPPER_STEP, () -> SoundEvents.COPPER_PLACE, () -> SoundEvents.COPPER_HIT, () -> SoundEvents.COPPER_FALL);
	public static final ForgeSoundType GRATING = new ForgeSoundType(1.0F, 0.8F, () -> SoundEvents.CHAIN_BREAK, () -> SoundEvents.CHAIN_STEP, () -> SoundEvents.CHAIN_PLACE, () -> SoundEvents.CHAIN_HIT, () -> SoundEvents.CHAIN_FALL);

}
