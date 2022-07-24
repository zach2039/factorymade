package com.zach2039.factorymade.init;

import com.google.common.base.Supplier;
import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.world.level.block.IndustrialShaperBlock;
import com.zach2039.factorymade.world.level.block.IndustrialWallLightBlock;
import com.zach2039.factorymade.world.level.block.base.*;
import com.zach2039.factorymade.world.level.block.variant.ComputerBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleConcreteBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleMetalBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleNonCorrosiveMetalBlockVariant;
import com.zach2039.factorymade.world.level.block.variantgroup.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FactoryMade.MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FactoryMade.MODID);

	private static boolean isInitialized = false;

	public static final RegistryObject<IndustrialShaperBlock> INDUSTRIAL_SHAPER = registerBlock("industrial_shaper",
			() -> new IndustrialShaperBlock()
	);

	// Iron Non-Slip Walkway
	public static final BlockVariantGroup<SimpleMetalBlockVariant, VariantBlock> IRON_NON_SLIP_WALKWAY_BLOCKS = BlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantBlock>create(BLOCKS, ITEMS)
			.groupName("iron_non_slip_walkway")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockFactory(VariantBlock::new)
			.build();
	public static final StairBlockVariantGroup<SimpleMetalBlockVariant, VariantStair> IRON_NON_SLIP_WALKWAY_STAIRS = StairBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantStair>create(BLOCKS, ITEMS)
			.groupName("iron_non_slip_walkway_stairs")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantStair::new)
			.build();
	public static final SlabBlockVariantGroup<SimpleMetalBlockVariant, VariantSlab> IRON_NON_SLIP_WALKWAY_SLABS = SlabBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantSlab>create(BLOCKS, ITEMS)
			.groupName("iron_non_slip_walkway_slab")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.slabFactory(VariantSlab::new)
			.build();

	// Lead Non-Slip Walkway
	public static final BlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantBlock> LEAD_NON_SLIP_WALKWAY_BLOCKS = BlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantBlock>create(BLOCKS, ITEMS)
			.groupName("lead_non_slip_walkway")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockFactory(VariantBlock::new)
			.build();
	public static final StairBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantStair> LEAD_NON_SLIP_WALKWAY_STAIRS = StairBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantStair>create(BLOCKS, ITEMS)
			.groupName("lead_non_slip_walkway_stairs")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.LEAD_NON_SLIP_WALKWAY_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantStair::new)
			.build();
	public static final SlabBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantSlab> LEAD_NON_SLIP_WALKWAY_SLABS = SlabBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantSlab>create(BLOCKS, ITEMS)
			.groupName("lead_non_slip_walkway_slab")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.slabFactory(VariantSlab::new)
			.build();

	// Iron Plate
	public static final BlockVariantGroup<SimpleMetalBlockVariant, VariantBlock> IRON_PLATE_BLOCKS = BlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantBlock>create(BLOCKS, ITEMS)
			.groupName("iron_plate")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockFactory(VariantBlock::new)
			.build();
	public static final StairBlockVariantGroup<SimpleMetalBlockVariant, VariantStair> IRON_PLATE_STAIRS = StairBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantStair>create(BLOCKS, ITEMS)
			.groupName("iron_plate_stairs")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.IRON_PLATE_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantStair::new)
			.build();
	public static final SlabBlockVariantGroup<SimpleMetalBlockVariant, VariantSlab> IRON_PLATE_SLABS = SlabBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantSlab>create(BLOCKS, ITEMS)
			.groupName("iron_plate_slab")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.slabFactory(VariantSlab::new)
			.build();

	// Lead Plate
	public static final BlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantBlock> LEAD_PLATE_BLOCKS = BlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantBlock>create(BLOCKS, ITEMS)
			.groupName("lead_plate")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockFactory(VariantBlock::new)
			.build();
	public static final StairBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantStair> LEAD_PLATE_STAIRS = StairBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantStair>create(BLOCKS, ITEMS)
			.groupName("lead_plate_stairs")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.LEAD_PLATE_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantStair::new)
			.build();
	public static final SlabBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantSlab> LEAD_PLATE_SLABS = SlabBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantSlab>create(BLOCKS, ITEMS)
			.groupName("lead_plate_slab")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.slabFactory(VariantSlab::new)
			.build();

	// Iron Grating
	public static final GlassBlockVariantGroup<SimpleMetalBlockVariant, VariantGlassBlock> IRON_GRATING_BLOCKS = GlassBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantGlassBlock>create(BLOCKS, ITEMS)
			.groupName("iron_grating")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.blockFactory(VariantGlassBlock::new)
			.build();
	public static final GlassStairBlockVariantGroup<SimpleMetalBlockVariant, VariantGlassStair> IRON_GRATING_STAIRS = GlassStairBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantGlassStair>create(BLOCKS, ITEMS)
			.groupName("iron_grating_stairs")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.IRON_GRATING_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantGlassStair::new)
			.build();
	public static final GlassSlabBlockVariantGroup<SimpleMetalBlockVariant, VariantGlassSlab> IRON_GRATING_SLABS = GlassSlabBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantGlassSlab>create(BLOCKS, ITEMS)
			.groupName("iron_grating_slab")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.slabFactory(VariantGlassSlab::new)
			.build();
	public static final PaneBlockVariantGroup<SimpleMetalBlockVariant, VariantPane> IRON_GRATING_PANES = PaneBlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantPane>create(BLOCKS, ITEMS)
			.groupName("iron_grating_pane")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.paneFactory(VariantPane::new)
			.build();

	// Lead Grating
	public static final GlassBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantGlassBlock> LEAD_GRATING_BLOCKS = GlassBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantGlassBlock>create(BLOCKS, ITEMS)
			.groupName("lead_grating")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.blockFactory(VariantGlassBlock::new)
			.build();
	public static final GlassStairBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantGlassStair> LEAD_GRATING_STAIRS = GlassStairBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantGlassStair>create(BLOCKS, ITEMS)
			.groupName("lead_grating_stairs")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.LEAD_GRATING_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantGlassStair::new)
			.build();
	public static final GlassSlabBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantGlassSlab> LEAD_GRATING_SLABS = GlassSlabBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantGlassSlab>create(BLOCKS, ITEMS)
			.groupName("lead_grating_slab")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.slabFactory(VariantGlassSlab::new)
			.build();
	public static final PaneBlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantPane> LEAD_GRATING_PANES = PaneBlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantPane>create(BLOCKS, ITEMS)
			.groupName("lead_grating_pane")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_GRATING_PROPS)
			.paneFactory(VariantPane::new)
			.build();

	// Iron Truss
	public static final BlockVariantGroup<SimpleMetalBlockVariant, VariantRotatedPillarBlock> IRON_TRUSS_BLOCKS = BlockVariantGroup.Builder.<SimpleMetalBlockVariant, VariantRotatedPillarBlock>create(BLOCKS, ITEMS)
			.groupName("iron_truss")
			.variants(SimpleMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockFactory(VariantRotatedPillarBlock::new)
			.build();

	// Lead Truss
	public static final BlockVariantGroup<SimpleNonCorrosiveMetalBlockVariant, VariantRotatedPillarBlock> LEAD_TRUSS_BLOCKS = BlockVariantGroup.Builder.<SimpleNonCorrosiveMetalBlockVariant, VariantRotatedPillarBlock>create(BLOCKS, ITEMS)
			.groupName("lead_truss")
			.variants(SimpleNonCorrosiveMetalBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.MEDIUM_METAL_PROPS)
			.blockFactory(VariantRotatedPillarBlock::new)
			.build();

	public static final RegistryObject<Block> WHITE_CINDER_BLOCK_BRICKS = registerBlock("white_cinder_block_bricks", () -> ModBlockProperties.WHITE_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> WHITE_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("white_cinder_block_bricks_stairs", () -> ModBlockProperties.WHITE_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> WHITE_CINDER_BLOCK_BRICKS_SLAB = registerBlock("white_cinder_block_bricks_slab", () -> ModBlockProperties.WHITE_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> YELLOW_CINDER_BLOCK_BRICKS = registerBlock("yellow_cinder_block_bricks", () -> ModBlockProperties.YELLOW_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> YELLOW_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("yellow_cinder_block_bricks_stairs", () -> ModBlockProperties.YELLOW_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> YELLOW_CINDER_BLOCK_BRICKS_SLAB = registerBlock("yellow_cinder_block_bricks_slab", () -> ModBlockProperties.YELLOW_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> RED_CINDER_BLOCK_BRICKS = registerBlock("red_cinder_block_bricks", () -> ModBlockProperties.RED_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> RED_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("red_cinder_block_bricks_stairs", () -> ModBlockProperties.RED_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> RED_CINDER_BLOCK_BRICKS_SLAB = registerBlock("red_cinder_block_bricks_slab", () -> ModBlockProperties.RED_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> BLUE_CINDER_BLOCK_BRICKS = registerBlock("blue_cinder_block_bricks", () -> ModBlockProperties.BLUE_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> BLUE_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("blue_cinder_block_bricks_stairs", () -> ModBlockProperties.BLUE_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> BLUE_CINDER_BLOCK_BRICKS_SLAB = registerBlock("blue_cinder_block_bricks_slab", () -> ModBlockProperties.BLUE_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> GREEN_CINDER_BLOCK_BRICKS = registerBlock("green_cinder_block_bricks", () -> ModBlockProperties.GREEN_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> GREEN_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("green_cinder_block_bricks_stairs", () -> ModBlockProperties.GREEN_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> GREEN_CINDER_BLOCK_BRICKS_SLAB = registerBlock("green_cinder_block_bricks_slab", () -> ModBlockProperties.GREEN_CINDER_BLOCK_BRICKS_SLAB);
	
	public static final RegistryObject<Block> BROWN_CINDER_BLOCK_BRICKS = registerBlock("brown_cinder_block_bricks", () -> ModBlockProperties.BROWN_CINDER_BLOCK_BRICKS);
	public static final RegistryObject<StairBlock> BROWN_CINDER_BLOCK_BRICKS_STAIRS = registerBlock("brown_cinder_block_bricks_stairs", () -> ModBlockProperties.BROWN_CINDER_BLOCK_BRICKS_STAIRS);
	public static final RegistryObject<SlabBlock> BROWN_CINDER_BLOCK_BRICKS_SLAB = registerBlock("brown_cinder_block_bricks_slab", () -> ModBlockProperties.BROWN_CINDER_BLOCK_BRICKS_SLAB);

	// Concrete Siding
	public static final BlockVariantGroup<SimpleConcreteBlockVariant, VariantBlock> CONCRETE_SIDING_BLOCKS = BlockVariantGroup.Builder.<SimpleConcreteBlockVariant, VariantBlock>create(BLOCKS, ITEMS)
			.groupName("concrete_siding")
			.variants(SimpleConcreteBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.CINDER_BLOCK_PROPS)
			.blockFactory(VariantBlock::new)
			.build();
	public static final StairBlockVariantGroup<SimpleConcreteBlockVariant, VariantStair> CONCRETE_SIDING_STAIRS = StairBlockVariantGroup.Builder.<SimpleConcreteBlockVariant, VariantStair>create(BLOCKS, ITEMS)
			.groupName("concrete_siding_stairs")
			.variants(SimpleConcreteBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.CINDER_BLOCK_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.CONCRETE_SIDING_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantStair::new)
			.build();
	public static final SlabBlockVariantGroup<SimpleConcreteBlockVariant, VariantSlab> CONCRETE_SIDING_SLABS = SlabBlockVariantGroup.Builder.<SimpleConcreteBlockVariant, VariantSlab>create(BLOCKS, ITEMS)
			.groupName("concrete_siding_slab")
			.variants(SimpleConcreteBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.CINDER_BLOCK_PROPS)
			.slabFactory(VariantSlab::new)
			.build();

	// Asbestos Tiles
	public static final BlockVariantGroup<DyeColor, VariantBlock> ASBESTOS_TILES_BLOCKS = BlockVariantGroup.Builder.<DyeColor, VariantBlock>create(BLOCKS, ITEMS)
			.groupName("asbestos_tiles")
			.variants(DyeColor.values())
			.blockPropertiesFactory(state -> ModBlockProperties.CERAMIC_TILES_PROPS)
			.blockFactory(VariantBlock::new)
			.build();
	public static final StairBlockVariantGroup<DyeColor, VariantStair> ASBESTOS_TILES_STAIRS = StairBlockVariantGroup.Builder.<DyeColor, VariantStair>create(BLOCKS, ITEMS)
			.groupName("asbestos_tiles_stairs")
			.variants(DyeColor.values())
			.blockPropertiesFactory(state -> ModBlockProperties.CERAMIC_TILES_PROPS)
			.blockStateProviderFactory(state -> () -> ModBlocks.ASBESTOS_TILES_BLOCKS.getBlock(state).get().defaultBlockState())
			.stairFactory(VariantStair::new)
			.build();
	public static final SlabBlockVariantGroup<DyeColor, VariantSlab> ASBESTOS_TILES_SLABS = SlabBlockVariantGroup.Builder.<DyeColor, VariantSlab>create(BLOCKS, ITEMS)
			.groupName("asbestos_tiles_slab")
			.variants(DyeColor.values())
			.blockPropertiesFactory(state -> ModBlockProperties.CERAMIC_TILES_PROPS)
			.slabFactory(VariantSlab::new)
			.build();

	// Computer
	public static final BlockVariantGroup<ComputerBlockVariant, VariantHorizontalDirectionalBlock> COMPUTER_BLOCKS = BlockVariantGroup.Builder.<ComputerBlockVariant, VariantHorizontalDirectionalBlock>create(BLOCKS, ITEMS)
			.groupName("computer")
			.suffix()
			.variants(ComputerBlockVariant.values())
			.blockPropertiesFactory(state -> ModBlockProperties.ELECTRONICS_PROPS)
			.blockFactory(VariantHorizontalDirectionalBlock::new)
			.build();

	public static final RegistryObject<Block> FLUORESCENT_LIGHT_PANEL = registerBlock("fluorescent_light_panel", () -> ModBlockProperties.FLUORESCENT_LIGHT_PANEL);
	public static final RegistryObject<SlabBlock> FLUORESCENT_LIGHT_PANEL_SLAB = registerBlock("fluorescent_light_panel_slab", () -> ModBlockProperties.FLUORESCENT_LIGHT_PANEL_SLAB);

	public static final RegistryObject<Block> INDUSTRIAL_WALL_LIGHT = registerBlock("industrial_wall_light", () -> ModBlockProperties.INDUSTRIAL_WALL_LIGHT);

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
	 * @param <BLOCK>      The block type
	 * @return A RegistryObject reference to the block
	 */
	private static <BLOCK extends Block> RegistryObject<BLOCK> registerItemlessBlock(final String name, final Supplier<BLOCK> blockFactory) {
		final RegistryObject<BLOCK> block = BLOCKS.register(name, blockFactory);

		return block;
	}

	/**
	 * Gets an {@link Item.Properties} instance with the {@link CreativeModeTab} set to {@link FactoryMade#CREATIVE_MODE_TAB}.
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

	private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos block) {
		return (boolean)false;
	}

	private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos block, EntityType<?> entityType) {
		return (boolean)false;
	}

	private static Boolean always(BlockState blockState, BlockGetter blockGetter, BlockPos block) {
		return (boolean)true;
	}

	private static class ModBlockProperties {
		private static final BlockBehaviour.Properties ELECTRONICS_PROPS = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(1.5F, 1.5F).requiresCorrectToolForDrops().sound(SoundType.COPPER);
		private static final BlockBehaviour.Properties MEDIUM_METAL_PROPS = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 4.0F).requiresCorrectToolForDrops().sound(ModSoundTypes.METAL);
		private static final BlockBehaviour.Properties MEDIUM_METAL_GRATING_PROPS = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(2.0F, 3.0F).requiresCorrectToolForDrops().sound(ModSoundTypes.GRATING).noOcclusion().isValidSpawn(ModBlocks::never).isRedstoneConductor(ModBlocks::never).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never);
		private static final BlockBehaviour.Properties CINDER_BLOCK_PROPS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 2.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS);
		private static final BlockBehaviour.Properties CERAMIC_TILES_PROPS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.0F, 2.0F).requiresCorrectToolForDrops().sound(SoundType.STONE);
		private static final BlockBehaviour.Properties FLUORESCENT_LIGHT_PROPS = BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS)
				.emissiveRendering(ModBlocks::always)
				.lightLevel((blockstate) -> { return 14; })
				;
		private static final BlockBehaviour.Properties INDUSTRIAL_LIGHT_PROPS = BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).noOcclusion()
				.lightLevel((blockstate) -> { return 14; })
				;
		
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

		public static final Block FLUORESCENT_LIGHT_PANEL = new Block(FLUORESCENT_LIGHT_PROPS);
		public static final SlabBlock FLUORESCENT_LIGHT_PANEL_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(FLUORESCENT_LIGHT_PANEL));

		public static final Block INDUSTRIAL_WALL_LIGHT = new IndustrialWallLightBlock(INDUSTRIAL_LIGHT_PROPS);
	}
}
