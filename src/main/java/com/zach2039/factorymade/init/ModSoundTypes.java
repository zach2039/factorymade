package com.zach2039.factorymade.init;

import com.zach2039.factorymade.FactoryMade;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundTypes {

	public static final ForgeSoundType METAL = new ForgeSoundType(1.0F, 0.8F, () -> SoundEvents.COPPER_BREAK, () -> SoundEvents.COPPER_STEP, () -> SoundEvents.COPPER_PLACE, () -> SoundEvents.COPPER_HIT, () -> SoundEvents.COPPER_FALL);
	public static final ForgeSoundType GRATING = new ForgeSoundType(1.0F, 0.8F, () -> SoundEvents.CHAIN_BREAK, () -> SoundEvents.CHAIN_STEP, () -> SoundEvents.CHAIN_PLACE, () -> SoundEvents.CHAIN_HIT, () -> SoundEvents.CHAIN_FALL);

}
