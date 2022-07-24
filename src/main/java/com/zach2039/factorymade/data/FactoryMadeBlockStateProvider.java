package com.zach2039.factorymade.data;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.util.EnumFaceRotation;
import com.zach2039.factorymade.util.RegistryUtil;
import com.zach2039.factorymade.world.level.block.variant.ComputerBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleConcreteBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleMetalBlockVariant;
import com.zach2039.factorymade.world.level.block.variant.SimpleNonCorrosiveMetalBlockVariant;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.util.Lazy;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Taken from <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3">TestMod3</a> on Github
 * 
 * @author Choonster
 *
 * With additions by:
 * @author zach2039
 */
public class FactoryMadeBlockStateProvider extends BlockStateProvider {
	private static final int DEFAULT_ANGLE_OFFSET = 180;

	private final List<String> errors = new ArrayList<>();

	/**
	 * Orientable models for each {@link EnumFaceRotation} value.
	 */
	private final Supplier<Map<EnumFaceRotation, ModelFile>> rotatedOrientables = Lazy.of(() -> {
		Map<EnumFaceRotation, ModelFile> map = new EnumMap<>(EnumFaceRotation.class);
		map.put(EnumFaceRotation.UP, existingMcModel("orientable"));

		Arrays.stream(EnumFaceRotation.values())
				.filter(faceRotation -> faceRotation != EnumFaceRotation.UP)
				.forEach(faceRotation -> {
					final ModelFile cube = models().getBuilder("cube_rotated_" + faceRotation.getSerializedName())
							.parent(existingMcModel("block"))
							.element()
							.allFaces((direction, faceBuilder) ->
									faceBuilder
											.texture("#" + direction.getSerializedName())
											.cullface(direction)
							)
							.allFaces((direction, faceBuilder) ->
									faceBuilder.rotation(
											switch (faceRotation) {
												case LEFT -> ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90;
												case RIGHT -> ModelBuilder.FaceRotation.CLOCKWISE_90;
												case DOWN -> ModelBuilder.FaceRotation.UPSIDE_DOWN;
												default -> throw new IllegalStateException("Invalid rotation: " + faceRotation);
											}
									)
							)
							.end();

					final ModelFile orientableWithBottom = models().getBuilder("orientable_with_bottom_rotated_" + faceRotation.getSerializedName())
							.parent(cube)

							.transforms()

							.transform(TransformType.FIRST_PERSON_RIGHT_HAND)
							.rotation(0, 135, 0)
							.scale(0.40f)
							.end()

							.end()

							.texture("particle", "#front")
							.texture("down", "#bottom")
							.texture("up", "#top")
							.texture("north", "#front")
							.texture("east", "#side")
							.texture("south", "#side")
							.texture("west", "#side");

					final ModelFile orientable = models().getBuilder("orientable_rotated_" + faceRotation.getSerializedName())
							.parent(orientableWithBottom)
							.texture("bottom", "#top");

					map.put(faceRotation, orientable);
				});

		return ImmutableMap.copyOf(map);
	});

	public FactoryMadeBlockStateProvider(final DataGenerator gen, final ExistingFileHelper exFileHelper) {
		super(gen, FactoryMade.MODID, exFileHelper);
	}

	@Override
	public String getName() {
		return "FactoryMadeBlockStates";
	}

	@Override
	protected void registerStatesAndModels() {
		
		// Industrial Shaper models are manual
		
		// Iron Non-Slip Walkway
		{
			ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.IRON_NON_SLIP_WALKWAY_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.IRON_NON_SLIP_WALKWAY_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});
		}

		// Iron Plate
		{
			ModBlocks.IRON_PLATE_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.IRON_PLATE_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.IRON_PLATE_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.IRON_PLATE_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.IRON_PLATE_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});
		}

		// Iron Grating
		{
			ModBlocks.IRON_GRATING_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.IRON_GRATING_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.IRON_GRATING_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.IRON_GRATING_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.IRON_GRATING_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.IRON_GRATING_PANES
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.IRON_GRATING_BLOCKS.getBlock((SimpleMetalBlockVariant) block.get().getType()).get()
						);

						paneBlock(block.get(), baseTexture, baseTexture);
					});
		}

		// Iron Truss
		{
			ModBlocks.IRON_TRUSS_BLOCKS
					.getBlocks()
					.forEach(block -> {
						final var model = models().cube(name(block.get()),
								modLoc("block/" + name(block.get()) + "_end"),
								modLoc("block/" + name(block.get()) + "_end"),
								modLoc("block/" + name(block.get()) + "_side"),
								modLoc("block/" + name(block.get()) + "_side"),
								modLoc("block/" + name(block.get()) + "_side_flipped"),
								modLoc("block/" + name(block.get()) + "_side_flipped")
						).texture("particle", modLoc( "block/" + name(block.get()) + "_end"));

						axisBlock(block.get(), model, model);
						simpleBlockItem(block.get());
					});
		}

		// Lead Non-Slip Walkway
		{
			ModBlocks.LEAD_NON_SLIP_WALKWAY_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.LEAD_NON_SLIP_WALKWAY_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.LEAD_NON_SLIP_WALKWAY_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.LEAD_NON_SLIP_WALKWAY_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.LEAD_NON_SLIP_WALKWAY_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});
		}

		// Lead Plate
		{
			ModBlocks.LEAD_PLATE_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.LEAD_PLATE_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.LEAD_PLATE_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.LEAD_PLATE_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.LEAD_PLATE_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});
		}

		// Lead Grating
		{
			ModBlocks.LEAD_GRATING_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.LEAD_GRATING_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.LEAD_GRATING_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.LEAD_GRATING_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.LEAD_GRATING_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.LEAD_GRATING_PANES
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.LEAD_GRATING_BLOCKS.getBlock((SimpleNonCorrosiveMetalBlockVariant) block.get().getType()).get()
						);

						paneBlock(block.get(), baseTexture, baseTexture);
					});
		}

		// Lead Truss
		{
			ModBlocks.LEAD_TRUSS_BLOCKS
					.getBlocks()
					.forEach(block -> {
						final var model = models().cube(name(block.get()),
								modLoc("block/" + name(block.get()) + "_end"),
								modLoc("block/" + name(block.get()) + "_end"),
								modLoc("block/" + name(block.get()) + "_side"),
								modLoc("block/" + name(block.get()) + "_side"),
								modLoc("block/" + name(block.get()) + "_side_flipped"),
								modLoc("block/" + name(block.get()) + "_side_flipped")
						).texture("particle", modLoc( "block/" + name(block.get()) + "_end"));

						axisBlock(block.get(), model, model);
						simpleBlockItem(block.get());
					});
		}

		// Cinder Block Bricks
		{
			blockStairSlab(
					ModBlocks.WHITE_CINDER_BLOCK_BRICKS.get(),
					ModBlocks.WHITE_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.WHITE_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			blockStairSlab(
					ModBlocks.YELLOW_CINDER_BLOCK_BRICKS.get(),
					ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.YELLOW_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			blockStairSlab(
					ModBlocks.RED_CINDER_BLOCK_BRICKS.get(),
					ModBlocks.RED_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.RED_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			blockStairSlab(
					ModBlocks.BLUE_CINDER_BLOCK_BRICKS.get(),
					ModBlocks.BLUE_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.BLUE_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			blockStairSlab(
					ModBlocks.GREEN_CINDER_BLOCK_BRICKS.get(),
					ModBlocks.GREEN_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.GREEN_CINDER_BLOCK_BRICKS_SLAB.get()
					);
			
			blockStairSlab(
					ModBlocks.BROWN_CINDER_BLOCK_BRICKS.get(),
					ModBlocks.BROWN_CINDER_BLOCK_BRICKS_STAIRS.get(),
					ModBlocks.BROWN_CINDER_BLOCK_BRICKS_SLAB.get()
					);
		}
		
		// Concrete Siding
		{
			ModBlocks.CONCRETE_SIDING_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.CONCRETE_SIDING_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.CONCRETE_SIDING_BLOCKS.getBlock((SimpleConcreteBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.CONCRETE_SIDING_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.CONCRETE_SIDING_BLOCKS.getBlock((SimpleConcreteBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});
		}

		// Asphalt
		{
			ModBlocks.ASPHALT_BLOCKS
					.getBlocks()
					.forEach(block -> {
						simpleBlock(block.get());
						simpleBlockItem(block.get());
					});

			ModBlocks.ASPHALT_STAIRS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.ASPHALT_BLOCKS.getBlock((SimpleConcreteBlockVariant) block.get().getType()).get()
						);

						stairsBlock(block.get(), baseTexture);
						simpleBlockItem(block.get());
					});

			ModBlocks.ASPHALT_SLABS
					.getBlocks()
					.forEach(block -> {
						ResourceLocation baseTexture = blockTexture(
								ModBlocks.ASPHALT_BLOCKS.getBlock((SimpleConcreteBlockVariant) block.get().getType()).get()
						);

						slabBlock(block.get(), baseTexture, baseTexture);
						simpleBlockItem(block.get());
					});
		}

		// Asbestos Tiles
		{
			ModBlocks.ASBESTOS_TILES_BLOCKS
					.getBlocks()
					.forEach(blockReg -> {
						final var block = blockReg.get();

						final var modelFile = models().cubeAll(
								"block/asbestos_tiles/" + name(block),
								modLoc("block/asbestos_tiles/" + name(block))
						);

						simpleBlock(block, modelFile);
						simpleBlockItem(block, modelFile);
					});

			ModBlocks.ASBESTOS_TILES_STAIRS
					.getBlocks()
					.forEach(blockReg -> {
						final var block = blockReg.get();
						final var baseBlock = ModBlocks.ASBESTOS_TILES_BLOCKS.getBlock((DyeColor) block.getType()).get();

						ResourceLocation baseTexture = modLoc("block/asbestos_tiles/" + name(baseBlock));

						stairsBlock(block, baseTexture);
						simpleBlockItem(block);
					});

			ModBlocks.ASBESTOS_TILES_SLABS
					.getBlocks()
					.forEach(blockReg -> {
						final var block = blockReg.get();
						final var baseBlock = ModBlocks.ASBESTOS_TILES_BLOCKS.getBlock((DyeColor) block.getType()).get();

						ResourceLocation baseTexture = modLoc("block/asbestos_tiles/" + name(baseBlock));

						slabBlock(block, baseTexture, baseTexture);
						simpleBlockItem(block);
					});
		}

		// Computer
		{
			ModBlocks.COMPUTER_BLOCKS
					.getBlocks()
					.forEach(blockReg -> {
						final var block = blockReg.get();

						final var sideTexture = (block.getType() == ComputerBlockVariant.CASING_BASE) ?
								modLoc("block/computer/computer_casing_base") : modLoc("block/computer/computer_casing");

						final var model = models().cube(name(block),
								modLoc("block/computer/computer_casing"),
								modLoc("block/computer/computer_casing"),
								modLoc("block/computer/" + name(block)),
								sideTexture,
								sideTexture,
								sideTexture
						).texture("particle", modLoc("block/computer/computer_casing"));

						horizontalBlock(block, model);
						simpleBlockItem(block);
					});
		}
		
		// Fluorescent Light Panel
		{
			Block block = ModBlocks.FLUORESCENT_LIGHT_PANEL.get();
			SlabBlock slab = ModBlocks.FLUORESCENT_LIGHT_PANEL_SLAB.get();

			simpleBlock(block);
			simpleBlockItem(block);
			
			slabBlock(slab, modLoc("block/fluorescent_light_panel"), modLoc("block/fluorescent_light_panel"));
			simpleBlockItem(slab);
		}

		// Industrial Wall Light models are manual
	}

	private void blockstateError(final Block block, final String fmt, final Object... args) {
		errors.add("Generated blockstate for block " + block + " " + String.format(fmt, args));
	}

	private ResourceLocation registryName(final Block block) {
		return Preconditions.checkNotNull(RegistryUtil.getKey(block), "Block %s has a null registry name", block);
	}

	private ResourceLocation registryName(final Item item) {
		return Preconditions.checkNotNull(RegistryUtil.getKey(item), "Item %s has a null registry name", item);
	}

	private String name(final Block block) {
		return registryName(block).getPath();
	}

	/**
	 * Gets an existing model with the block's registry name.
	 * <p>
	 * Note: This isn't guaranteed to be the actual model used by the block.
	 *
	 * @param block The block
	 * @return The model
	 */
	private ModelFile existingModel(final Block block) {
		return models().getExistingFile(registryName(block));
	}

	/**
	 * Gets an existing model with the item's registry name.
	 * <p>
	 * Note: This isn't guaranteed to be the actual model used by the item.
	 *
	 * @param item The item
	 * @return The model
	 */
	private ModelFile existingModel(final Item item) {
		return itemModels().getExistingFile(registryName(item));
	}

	/**
	 * Gets an existing model in the {@code minecraft} namespace with the specified name.
	 *
	 * @param name The model name
	 * @return The model
	 */
	private ModelFile existingMcModel(final String name) {
		return models().getExistingFile(new ResourceLocation("minecraft", name));
	}

	private void simpleBlockItem(final Block block) {
		simpleBlockItem(block, existingModel(block));
	}

	private void simpleBlockItemWithExistingParent(final Block block, final Item item) {
		simpleBlockItem(block, existingModel(item));
	}

	private ModelFile orientableSingle(final String name, final ResourceLocation side, final ResourceLocation front) {
		return models().orientable(name, side, front, side);
	}

	private void simpleBlockWithExistingParent(final Block block, final Block parentBlock) {
		simpleBlockWithExistingParent(block, existingModel(parentBlock));
	}

	private void simpleBlockWithExistingParent(final Block block, final ModelFile parentModel) {
		simpleBlock(
				block,
				models().getBuilder(name(block))
						.parent(parentModel)
		);
	}

	protected void directionalBlockUvLock(final Block block, final ModelFile model) {
		directionalBlockUvLock(block, $ -> model);
	}

	protected void directionalBlockUvLock(final Block block, final Function<BlockState, ModelFile> modelFunc) {
		getVariantBuilder(block)
				.forAllStates(state -> {
					final Direction direction = state.getValue(BlockStateProperties.FACING);
					return ConfiguredModel.builder()
							.modelFile(modelFunc.apply(state))
							.rotationX(getRotationX(direction))
							.rotationY(getRotationY(direction))
							.build();
				});
	}

	private void blockStairSlab(final Block block, final StairBlock stair, final SlabBlock slab) {		
		simpleBlock(block);
		simpleBlockItem(block);
		
		stairsBlock(stair, blockTexture(block));
		simpleBlockItem(stair);
		
		slabBlock(slab, blockTexture(block), blockTexture(block));
		simpleBlockItem(slab);
	}
	
	private int getRotationX(final Direction direction) {
		return direction == Direction.DOWN ? 90 : direction.getAxis().isHorizontal() ? 0 : -90;
	}

	private int getRotationY(final Direction direction) {
		return getRotationY(direction, DEFAULT_ANGLE_OFFSET);
	}

	private int getRotationY(final Direction direction, final int offset) {
		return direction.getAxis().isVertical() ? 0 : (((int) direction.toYRot()) + offset) % 360;
	}
}
