package com.zach2039.factorymade.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.fluid.BasicFluidType;
import com.zach2039.factorymade.fluid.group.FluidGroup;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.util.EnumFaceRotation;
import com.zach2039.factorymade.util.ModRegistryUtil;

import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
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
			Block block = ModBlocks.IRON_NON_SLIP_WALKWAY.get();
			StairBlock stair = ModBlocks.IRON_NON_SLIP_WALKWAY_STAIRS.get();
			SlabBlock slab = ModBlocks.IRON_NON_SLIP_WALKWAY_SLAB.get();
			
			simpleBlock(block);
			simpleBlockItem(block);
			
			stairsBlock(stair, modLoc("block/iron_non_slip_walkway"));
			simpleBlockItem(stair);
			
			slabBlock(slab, modLoc("block/iron_non_slip_walkway"), modLoc("block/iron_non_slip_walkway"));
			simpleBlockItem(slab);
		}
		
		// Rusted Iron Non-Slip Walkway
		{
			Block block = ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY.get();
			StairBlock stair = ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_STAIRS.get();
			SlabBlock slab = ModBlocks.RUSTED_IRON_NON_SLIP_WALKWAY_SLAB.get();
			
			simpleBlock(block);
			simpleBlockItem(block);
			
			stairsBlock(stair, modLoc("block/rusted_iron_non_slip_walkway"));
			simpleBlockItem(stair);
			
			slabBlock(slab, modLoc("block/rusted_iron_non_slip_walkway"), modLoc("block/rusted_iron_non_slip_walkway"));
			simpleBlockItem(slab);
		}
		
		// Iron Truss
		{
			RotatedPillarBlock block = ModBlocks.IRON_TRUSS.get();

			final var model = models().cube(name(block), 
					modLoc("block/iron_truss_end"),
					modLoc("block/iron_truss_end"),
					modLoc("block/iron_truss_side"),
					modLoc("block/iron_truss_side"), 
					modLoc("block/iron_truss_side_flipped"),
					modLoc("block/iron_truss_side_flipped")
					).texture("particle", modLoc("block/iron_truss_end"));
			
			axisBlock(block, model, model);
			simpleBlockItem(block);
		}
		
		// Rusted Iron Truss
		{
			RotatedPillarBlock block = ModBlocks.RUSTED_IRON_TRUSS.get();

			final var model = models().cube(name(block), 
					modLoc("block/rusted_iron_truss_end"),
					modLoc("block/rusted_iron_truss_end"),
					modLoc("block/rusted_iron_truss_side"),
					modLoc("block/rusted_iron_truss_side"), 
					modLoc("block/rusted_iron_truss_side_flipped"),
					modLoc("block/rusted_iron_truss_side_flipped")
					).texture("particle", modLoc("block/rusted_iron_truss_end"));
			
			axisBlock(block, model, model);
			simpleBlockItem(block);
		}
		
		// White Cinder Block Bricks
		{
			Block block = ModBlocks.WHITE_CINDER_BLOCK_BRICKS.get();
			StairBlock stair = ModBlocks.WHITE_CINDER_BLOCK_BRICKS_STAIRS.get();
			SlabBlock slab = ModBlocks.WHITE_CINDER_BLOCK_BRICKS_SLAB.get();
			
			simpleBlock(block);
			simpleBlockItem(block);
			
			stairsBlock(stair, modLoc("block/white_cinder_block_bricks"));
			simpleBlockItem(stair);
			
			slabBlock(slab, modLoc("block/white_cinder_block_bricks"), modLoc("block/white_cinder_block_bricks"));
			simpleBlockItem(slab);
		}
		
		// Black Asbestos Tiles
		{
			Block block = ModBlocks.BLACK_ASBESTOS_TILES.get();
			StairBlock stair = ModBlocks.BLACK_ASBESTOS_TILES_STAIRS.get();
			SlabBlock slab = ModBlocks.BLACK_ASBESTOS_TILES_SLAB.get();
			
			simpleBlock(block);
			simpleBlockItem(block);
			
			stairsBlock(stair, modLoc("block/black_asbestos_tiles"));
			simpleBlockItem(stair);
			
			slabBlock(slab, modLoc("block/black_asbestos_tiles"), modLoc("block/black_asbestos_tiles"));
			simpleBlockItem(slab);
		}
	}

	private void blockstateError(final Block block, final String fmt, final Object... args) {
		errors.add("Generated blockstate for block " + block + " " + String.format(fmt, args));
	}

	private ResourceLocation registryName(final Block block) {
		return Preconditions.checkNotNull(ModRegistryUtil.getKey(block), "Block %s has a null registry name", block);
	}

	private ResourceLocation registryName(final Item item) {
		return Preconditions.checkNotNull(ModRegistryUtil.getKey(item), "Item %s has a null registry name", item);
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

	private void fluidBlock(final FluidGroup<?, ?, ?, ?, ?> fluidGroup) {
		// We can't use the RenderProperties for the fluid type as they're not initialised in datagen
		if (!(fluidGroup.getType().get() instanceof BasicFluidType basicFluidType)) {
			throw new IllegalArgumentException("Fluid type must extend BasicFluidType");
		}

		final var block = fluidGroup.getBlock().get();

		final var model = models().getBuilder(name(block))
				.texture("particle", basicFluidType.getStillTexture());

		simpleBlock(block, model);
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
