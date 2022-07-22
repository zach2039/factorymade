package com.zach2039.factorymade.init;

import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.world.item.crafting.recipe.IndustrialShaperRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class ModCrafting {
		
	public static class Brewing {
		public static void register() {}
	}
	
	public static class Ingredients {
		public static void register() {}
	}

	public static class Recipes {
		private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FactoryMade.MODID);

		private static boolean isInitialized;

		public static final RegistryObject<IndustrialShaperRecipe.Serializer> INDUSTRIAL_SHAPER = RECIPE_SERIALIZERS.register("industrial_shaper", IndustrialShaperRecipe.Serializer::new);
		
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

			RECIPE_SERIALIZERS.register(modEventBus);

			isInitialized = true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <C extends Container, T extends Recipe<C>> Map<ResourceLocation, Recipe<C>> getRecipes(Level world, RecipeType<T> type) {
		return  (Map<ResourceLocation, Recipe<C>>) world.getRecipeManager().getRecipeIds()
				.collect(Collectors.toMap(v -> v, v -> world.getRecipeManager().byKey(v).orElseThrow(IllegalArgumentException::new)));
	}
}