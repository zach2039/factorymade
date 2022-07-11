package com.zach2039.factorymade.world.level.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.IBlockRenderProperties;
import net.minecraftforge.client.RenderProperties;

import javax.annotation.Nullable;
import java.util.Map;

public class IndustrialWallLightBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Block.box(5.0D, 3.0D, 5.0D, 11.0D, 11.0D, 11.0D).move(0.0D, 0.0D, 0.25D),
            Direction.SOUTH, Block.box(5.0D, 3.0D, 5.0D, 11.0D, 11.0D, 11.0D).move(0.0D, 0.0D, -0.25D),
            Direction.WEST, Block.box(5.0D, 3.0D, 5.0D, 11.0D, 11.0D, 11.0D).move(0.25D, 0.0D, 0.0D),
            Direction.EAST, Block.box(5.0D, 3.0D, 5.0D, 11.0D, 11.0D, 11.0D).move(-0.25D, 0.0D, 0.0D),
            Direction.UP, Block.box(5.0D, 6.0D, 5.0D, 11.0D, 15.0D, 11.0D)
    ));

    public IndustrialWallLightBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HANGING, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction faceDir = ctx.getClickedFace();
        LevelReader levelReader = ctx.getLevel();
        FluidState fluidstate = levelReader.getFluidState(ctx.getClickedPos());
        BlockPos blockpos = ctx.getClickedPos();
        BlockState blockstate = null;

        for(Direction direction : ctx.getNearestLookingDirections()) {
            if (direction != Direction.DOWN) {
                blockstate = this.defaultBlockState()
                        .setValue(FACING, (faceDir.getAxis().isHorizontal()) ? faceDir : Direction.NORTH)
                        .setValue(HANGING, Boolean.valueOf(faceDir == Direction.DOWN));

                if (blockstate.canSurvive(levelReader, blockpos)) {
                    blockstate.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
                }
            }
        }

        return blockstate != null && levelReader.isUnobstructed(blockstate, blockpos, CollisionContext.empty()) ? blockstate : null;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(HANGING)) {
            return AABBS.get(Direction.UP);
        } else {
            return AABBS.get(blockState.getValue(FACING));
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(FACING, HANGING, WATERLOGGED);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        Direction direction = getConnectedDirection(blockState);
        return Block.canSupportCenter(levelReader, blockPos.relative(direction), direction.getOpposite());
    }

    protected static Direction getConnectedDirection(BlockState blockState) {
        return blockState.getValue(HANGING) ? Direction.UP : blockState.getValue(FACING).getOpposite();
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.DESTROY;
    }

   @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return getConnectedDirection(blockState).getOpposite() == direction && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState1, levelAccessor, blockPos, blockPos1);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }
}
