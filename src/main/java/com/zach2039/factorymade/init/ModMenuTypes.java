package com.zach2039.factorymade.init;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.world.inventory.menu.IndustrialShaperMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class ModMenuTypes {
	private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, FactoryMade.MODID);

	private static boolean isInitialized;

	public static final RegistryObject<MenuType<IndustrialShaperMenu>> INDUSTRIAL_SHAPER = MENU_TYPES.register("metal_shaper",
			() -> new MenuType<>(new IndustrialShaperMenu.Factory())
	);

	/**
	 * Registers the {@link DeferredRegister} instance with the mod event bus.
	 * <p>
	 * This should be called during mod construction.
	 *
	 * @param modEventBus The mod event bus
	 */
	public static void initialize(final IEventBus modEventBus) {
		if (isInitialized) {
			throw new IllegalStateException("Already initialized");
		}

		MENU_TYPES.register(modEventBus);

		isInitialized = true;
	}
}
