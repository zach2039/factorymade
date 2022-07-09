package com.zach2039.factorymade.init;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;
import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.world.level.block.IndustrialShaperBlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
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
public class ModBlocks {
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FactoryMade.MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FactoryMade.MODID);

	private static boolean isInitialized = false;

	public static final RegistryObject<IndustrialShaperBlock> INDUSTRIAL_SHAPER = registerBlock("industrial_shaper",
			() -> new IndustrialShaperBlock()
	);
	
	public static final RegistryObject<Block> IRON_NON_SLIP_WALKWAY = registerBlock("iron_non_slip_walkway", () -> ModBlockInstances.IRON_NON_SLIP_WALKWAY);
	public static final RegistryObject<StairBlock> IRON_NON_SLIP_WALKWAY_STAIRS = registerBlock("iron_non_slip_walkway_stairs", () -> ModBlockInstances.IRON_NON_SLIP_WALKWAY_STAIRS);
	public static final RegistryObject<SlabBlock> IRON_NON_SLIP_WALKWAY_SLAB = registerBlock("iron_non_slip_walkway_slab", () -> ModBlockInstances.IRON_NON_SLIP_WALKWAY_SLAB);
	
	public static final RegistryObject<Block> RUSTED_IRON_NON_SLIP_WALKWAY = registerBlock("rusted_iron_non_slip_walkway", () -> ModBlockInstances.RUSTED_IRON_NON_SLIP_WALKWAY);
	public static final RegistryObject<StairBlock> RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS = registerBlock("rusted_iron_non_slip_walkway_stairs", () -> ModBlockInstances.RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS);
	public static final RegistryObject<SlabBlock> RUSTED_IRON_NON_SLIP_WALKWAY_SLAB = registerBlock("rusted_iron_non_slip_walkway_slab", () -> ModBlockInstances.RUSTED_IRON_NON_SLIP_WALKWAY_SLAB);
	
	public static final RegistryObject<RotatedPillarBlock> IRON_TRUSS = registerBlock("iron_truss", () -> ModBlockInstances.IRON_TRUSS);
	public static final RegistryObject<RotatedPillarBlock> RUSTED_IRON_TRUSS = registerBlock("rusted_iron_truss", () -> ModBlockInstances.RUSTED_IRON_TRUSS);
	
	/**
	 * Registers the {@link DeferredRegister} instances with the mod event bus.
	 * <p>
	 * This should be called during mod construction.
	 *
	 * @param modEventBus The mod event bus
	 */
	public static void initialize(final IEventBus modEventBus) {
		if (isInitialized) {
			throw new IllegalStateException("Already initialized");
		}

		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);

		isInitialized = true;
	}

	/**
	 * Registers a block with a standard {@link BlockItem} as its block item.
	 *
	 * @param name         The registry name of the block
	 * @param blockFactory The factory used to create the block
	 * @param <BLOCK>      The block type
	 * @return A RegistryObject reference to the block
	 */
	private static <BLOCK extends Block> RegistryObject<BLOCK> registerBlock(final String name, final Supplier<BLOCK> blockFactory) {
		return registerBlock(name, blockFactory, block -> new BlockItem(block, defaultItemProperties()));
	}

	/**
	 * Registers a block and its block item.
	 *
	 * @param name         The registry name of the block
	 * @param blockFactory The factory used to create the block
	 * @param itemFactory  The factory used to create the block item
	 * @param <BLOCK>      The block type
	 * @return A RegistryObject reference to the block
	 */
	private static <BLOCK extends Block> RegistryObject<BLOCK> registerBlock(final String name, final Supplier<BLOCK> blockFactory, final IBlockItemFactory<BLOCK> itemFactory) {
		final RegistryObject<BLOCK> block = BLOCKS.register(name, blockFactory);

		ITEMS.register(name, () -> itemFactory.create(block.get()));

		return block;
	}
	
	/**
	 * Registers a block without a blockItem.
	 *
	 * @param name         The registry name of the block
	 * @param blockFactory The factory used to create the block
	 * @param itemFactory  The factory used to create the block item
	 * @param <BLOCK>      The block type
	 * @return A RegistryObject reference to the block
	 */
	private static <BLOCK extends Block> RegistryObject<BLOCK> registerItemlessBlock(final String name, final Supplier<BLOCK> blockFactory) {
		final RegistryObject<BLOCK> block = BLOCKS.register(name, blockFactory);

		return block;
	}

	/**
	 * Gets an {@link Item.Properties} instance with the {@link CreativeModeTab} set to {@link TestMod3#CREATIVE_MODE_TAB}.
	 *
	 * @return The item properties
	 */
	private static Item.Properties defaultItemProperties() {
		return new Item.Properties().tab(FactoryMade.CREATIVE_MODE_TAB);
	}

	/**
	 * A factory function used to create block items.
	 *
	 * @param <BLOCK> The block type
	 */
	@FunctionalInterface
	private interface IBlockItemFactory<BLOCK extends Block> {
		Item create(BLOCK block);
	}
	
	private class ModBlockInstances {
		private static final BlockBehaviour.Properties LIGHT_IRON_PROPS = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 4.0F).requiresCorrectToolForDrops().sound(SoundType.COPPER);
		
		public static final Block IRON_NON_SLIP_WALKWAY = new Block(LIGHT_IRON_PROPS);
		public static final StairBlock IRON_NON_SLIP_WALKWAY_STAIRS = new StairBlock(() -> {return IRON_NON_SLIP_WALKWAY.defaultBlockState();}, BlockBehaviour.Properties.copy(IRON_NON_SLIP_WALKWAY));
		public static final SlabBlock IRON_NON_SLIP_WALKWAY_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(IRON_NON_SLIP_WALKWAY));
		
		public static final Block RUSTED_IRON_NON_SLIP_WALKWAY = new Block(LIGHT_IRON_PROPS);
		public static final StairBlock RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS = new StairBlock(() -> {return RUSTED_IRON_NON_SLIP_WALKWAY.defaultBlockState();}, BlockBehaviour.Properties.copy(IRON_NON_SLIP_WALKWAY));
		public static final SlabBlock RUSTED_IRON_NON_SLIP_WALKWAY_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(RUSTED_IRON_NON_SLIP_WALKWAY));
		
		public static final RotatedPillarBlock IRON_TRUSS = new RotatedPillarBlock(LIGHT_IRON_PROPS);
		public static final RotatedPillarBlock RUSTED_IRON_TRUSS = new RotatedPillarBlock(LIGHT_IRON_PROPS);
	}
}
