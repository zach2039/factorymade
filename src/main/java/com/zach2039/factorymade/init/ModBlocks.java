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
	
	public static final RegistryObject<Block> WHITE_CINDER_BLOCK_BRICKS = registerBlock("white_cinder_block_bricks", () -> ModBlockInstances.WHITE_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> WHITE_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("white_cinder_block_bricks_stairs", () -> ModBlockInstances.WHITE_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> WHITE_CINDER_BLOCK_BRICKS_SLAB = registerBlock("white_cinder_block_bricks_slab", () -> ModBlockInstances.WHITE_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> YELLOW_CINDER_BLOCK_BRICKS = registerBlock("yellow_cinder_block_bricks", () -> ModBlockInstances.YELLOW_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> YELLOW_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("yellow_cinder_block_bricks_stairs", () -> ModBlockInstances.YELLOW_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> YELLOW_CINDER_BLOCK_BRICKS_SLAB = registerBlock("yellow_cinder_block_bricks_slab", () -> ModBlockInstances.YELLOW_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> RED_CINDER_BLOCK_BRICKS = registerBlock("red_cinder_block_bricks", () -> ModBlockInstances.RED_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> RED_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("red_cinder_block_bricks_stairs", () -> ModBlockInstances.RED_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> RED_CINDER_BLOCK_BRICKS_SLAB = registerBlock("red_cinder_block_bricks_slab", () -> ModBlockInstances.RED_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> BLUE_CINDER_BLOCK_BRICKS = registerBlock("blue_cinder_block_bricks", () -> ModBlockInstances.BLUE_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> BLUE_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("blue_cinder_block_bricks_stairs", () -> ModBlockInstances.BLUE_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> BLUE_CINDER_BLOCK_BRICKS_SLAB = registerBlock("blue_cinder_block_bricks_slab", () -> ModBlockInstances.BLUE_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> GREEN_CINDER_BLOCK_BRICKS = registerBlock("green_cinder_block_bricks", () -> ModBlockInstances.GREEN_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> GREEN_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("green_cinder_block_bricks_stairs", () -> ModBlockInstances.GREEN_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> GREEN_CINDER_BLOCK_BRICKS_SLAB = registerBlock("green_cinder_block_bricks_slab", () -> ModBlockInstances.GREEN_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> BROWN_CINDER_BLOCK_BRICKS = registerBlock("brown_cinder_block_bricks", () -> ModBlockInstances.BROWN_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> BROWN_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("brown_cinder_block_bricks_stairs", () -> ModBlockInstances.BROWN_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> BROWN_CINDER_BLOCK_BRICKS_SLAB = registerBlock("brown_cinder_block_bricks_slab", () -> ModBlockInstances.BROWN_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> CONCRETE_SIDING = registerBlock("concrete_siding", () -> ModBlockInstances.CONCRETE_SIDING);
	public static final RegistryObject<StairBlock> CONCRETE_SIDING_STAIRS = registerBlock("concrete_siding_stairs", () -> ModBlockInstances.CONCRETE_SIDING_STAIRS);
	public static final RegistryObject<SlabBlock> CONCRETE_SIDING_SLAB = registerBlock("concrete_siding_slab", () -> ModBlockInstances.CONCRETE_SIDING_SLAB);
	
	public static final RegistryObject<Block> WEATHERED_CONCRETE_SIDING = registerBlock("weathered_concrete_siding", () -> ModBlockInstances.WEATHERED_CONCRETE_SIDING);
	public static final RegistryObject<StairBlock> WEATHERED_CONCRETE_SIDING_STAIRS = registerBlock("weathered_concrete_siding_stairs", () -> ModBlockInstances.WEATHERED_CONCRETE_SIDING_STAIRS);
	public static final RegistryObject<SlabBlock> WEATHERED_CONCRETE_SIDING_SLAB = registerBlock("weathered_concrete_siding_slab", () -> ModBlockInstances.WEATHERED_CONCRETE_SIDING_SLAB);
	
	public static final RegistryObject<Block> BLACK_ASBESTOS_TILES = registerBlock("black_asbestos_tiles", () -> ModBlockInstances.BLACK_ASBESTOS_TILES);
	public static final RegistryObject<StairBlock> BLACK_ASBESTOS_TILES_STAIRS = registerBlock("black_asbestos_tiles_stairs", () -> ModBlockInstances.BLACK_ASBESTOS_TILES_STAIRS);
	public static final RegistryObject<SlabBlock> BLACK_ASBESTOS_TILES_SLAB = registerBlock("black_asbestos_tiles_slab", () -> ModBlockInstances.BLACK_ASBESTOS_TILES_SLAB);
	
	public static final RegistryObject<Block> WHITE_ASBESTOS_TILES = registerBlock("white_asbestos_tiles", () -> ModBlockInstances.WHITE_ASBESTOS_TILES);
	public static final RegistryObject<StairBlock> WHITE_ASBESTOS_TILES_STAIRS = registerBlock("white_asbestos_tiles_stairs", () -> ModBlockInstances.WHITE_ASBESTOS_TILES_STAIRS);
	public static final RegistryObject<SlabBlock> WHITE_ASBESTOS_TILES_SLAB = registerBlock("white_asbestos_tiles_slab", () -> ModBlockInstances.WHITE_ASBESTOS_TILES_SLAB);
	
	public static final RegistryObject<Block> FLUORESCENT_LIGHT_PANEL = registerBlock("fluorescent_light_panel", () -> ModBlockInstances.FLUORESCENT_LIGHT_PANEL);
	public static final RegistryObject<SlabBlock> FLUORESCENT_LIGHT_PANEL_SLAB = registerBlock("fluorescent_light_panel_slab", () -> ModBlockInstances.FLUORESCENT_LIGHT_PANEL_SLAB);
	
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
		private static final BlockBehaviour.Properties CINDER_BLOCK_PROPS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 2.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS);
		private static final BlockBehaviour.Properties CERAMIC_TILES_PROPS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.0F, 2.0F).requiresCorrectToolForDrops().sound(SoundType.STONE);
		private static final BlockBehaviour.Properties FLUORESCENT_LIGHT_PROPS = BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS).lightLevel((blockstate) -> {
		      return 14;
		   });
		
		public static final Block IRON_NON_SLIP_WALKWAY = new Block(LIGHT_IRON_PROPS);
		public static final StairBlock IRON_NON_SLIP_WALKWAY_STAIRS = new StairBlock(() -> {return IRON_NON_SLIP_WALKWAY.defaultBlockState();}, BlockBehaviour.Properties.copy(IRON_NON_SLIP_WALKWAY));
		public static final SlabBlock IRON_NON_SLIP_WALKWAY_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(IRON_NON_SLIP_WALKWAY));
		
		public static final Block RUSTED_IRON_NON_SLIP_WALKWAY = new Block(LIGHT_IRON_PROPS);
		public static final StairBlock RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS = new StairBlock(() -> {return RUSTED_IRON_NON_SLIP_WALKWAY.defaultBlockState();}, BlockBehaviour.Properties.copy(IRON_NON_SLIP_WALKWAY));
		public static final SlabBlock RUSTED_IRON_NON_SLIP_WALKWAY_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(RUSTED_IRON_NON_SLIP_WALKWAY));
		
		public static final RotatedPillarBlock IRON_TRUSS = new RotatedPillarBlock(LIGHT_IRON_PROPS);
		public static final RotatedPillarBlock RUSTED_IRON_TRUSS = new RotatedPillarBlock(LIGHT_IRON_PROPS);
		
		public static final Block WHITE_CINDER_BLOCK_BRICKS = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock WHITE_CINDER_BLOCK_BRICKS_STAIRS = new StairBlock(() -> {return WHITE_CINDER_BLOCK_BRICKS.defaultBlockState();}, BlockBehaviour.Properties.copy(WHITE_CINDER_BLOCK_BRICKS));
		public static final SlabBlock WHITE_CINDER_BLOCK_BRICKS_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(WHITE_CINDER_BLOCK_BRICKS));
		
		public static final Block YELLOW_CINDER_BLOCK_BRICKS = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock YELLOW_CINDER_BLOCK_BRICKS_STAIRS = new StairBlock(() -> {return YELLOW_CINDER_BLOCK_BRICKS.defaultBlockState();}, BlockBehaviour.Properties.copy(WHITE_CINDER_BLOCK_BRICKS));
		public static final SlabBlock YELLOW_CINDER_BLOCK_BRICKS_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(YELLOW_CINDER_BLOCK_BRICKS));
		
		public static final Block RED_CINDER_BLOCK_BRICKS = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock RED_CINDER_BLOCK_BRICKS_STAIRS = new StairBlock(() -> {return RED_CINDER_BLOCK_BRICKS.defaultBlockState();}, BlockBehaviour.Properties.copy(WHITE_CINDER_BLOCK_BRICKS));
		public static final SlabBlock RED_CINDER_BLOCK_BRICKS_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(RED_CINDER_BLOCK_BRICKS));
		
		public static final Block BLUE_CINDER_BLOCK_BRICKS = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock BLUE_CINDER_BLOCK_BRICKS_STAIRS = new StairBlock(() -> {return BLUE_CINDER_BLOCK_BRICKS.defaultBlockState();}, BlockBehaviour.Properties.copy(WHITE_CINDER_BLOCK_BRICKS));
		public static final SlabBlock BLUE_CINDER_BLOCK_BRICKS_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(BLUE_CINDER_BLOCK_BRICKS));
		
		public static final Block GREEN_CINDER_BLOCK_BRICKS = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock GREEN_CINDER_BLOCK_BRICKS_STAIRS = new StairBlock(() -> {return GREEN_CINDER_BLOCK_BRICKS.defaultBlockState();}, BlockBehaviour.Properties.copy(WHITE_CINDER_BLOCK_BRICKS));
		public static final SlabBlock GREEN_CINDER_BLOCK_BRICKS_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(GREEN_CINDER_BLOCK_BRICKS));
		
		public static final Block BROWN_CINDER_BLOCK_BRICKS = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock BROWN_CINDER_BLOCK_BRICKS_STAIRS = new StairBlock(() -> {return BROWN_CINDER_BLOCK_BRICKS.defaultBlockState();}, BlockBehaviour.Properties.copy(WHITE_CINDER_BLOCK_BRICKS));
		public static final SlabBlock BROWN_CINDER_BLOCK_BRICKS_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(BROWN_CINDER_BLOCK_BRICKS));
		
		public static final Block CONCRETE_SIDING = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock CONCRETE_SIDING_STAIRS = new StairBlock(() -> {return CONCRETE_SIDING.defaultBlockState();}, BlockBehaviour.Properties.copy(CONCRETE_SIDING));
		public static final SlabBlock CONCRETE_SIDING_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(CONCRETE_SIDING));
		
		public static final Block WEATHERED_CONCRETE_SIDING = new Block(CINDER_BLOCK_PROPS);
		public static final StairBlock WEATHERED_CONCRETE_SIDING_STAIRS = new StairBlock(() -> {return WEATHERED_CONCRETE_SIDING.defaultBlockState();}, BlockBehaviour.Properties.copy(WEATHERED_CONCRETE_SIDING));
		public static final SlabBlock WEATHERED_CONCRETE_SIDING_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(WEATHERED_CONCRETE_SIDING));
		
		public static final Block BLACK_ASBESTOS_TILES = new Block(CERAMIC_TILES_PROPS);
		public static final StairBlock BLACK_ASBESTOS_TILES_STAIRS = new StairBlock(() -> {return BLACK_ASBESTOS_TILES.defaultBlockState();}, BlockBehaviour.Properties.copy(BLACK_ASBESTOS_TILES));
		public static final SlabBlock BLACK_ASBESTOS_TILES_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(BLACK_ASBESTOS_TILES));
		
		public static final Block WHITE_ASBESTOS_TILES = new Block(CERAMIC_TILES_PROPS);
		public static final StairBlock WHITE_ASBESTOS_TILES_STAIRS = new StairBlock(() -> {return WHITE_ASBESTOS_TILES.defaultBlockState();}, BlockBehaviour.Properties.copy(WHITE_ASBESTOS_TILES));
		public static final SlabBlock WHITE_ASBESTOS_TILES_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(WHITE_ASBESTOS_TILES));
		
		public static final Block FLUORESCENT_LIGHT_PANEL = new Block(FLUORESCENT_LIGHT_PROPS);
		public static final SlabBlock FLUORESCENT_LIGHT_PANEL_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(FLUORESCENT_LIGHT_PANEL));
	}
}
