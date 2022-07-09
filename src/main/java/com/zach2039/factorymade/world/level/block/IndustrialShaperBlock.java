package com.zach2039.factorymade.world.level.block;

import com.zach2039.factorymade.world.inventory.menu.IndustrialShaperMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class IndustrialShaperBlock extends Block {
	public static final Component CONTAINER_TITLE = Component.translatable("container.industrial_shaper");
	public static final Property<Direction> FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	
	public IndustrialShaperBlock() {
		super(Block.Properties
				.of(Material.METAL)
				.sound(SoundType.METAL)
				.strength(5.0F)
				.dynamicShape()
				.noOcclusion()
				);
		
		this.registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
	}
	
	@Override
	protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	@Override
	public BlockState rotate(final BlockState state, final LevelAccessor level, final BlockPos pos, final Rotation direction) {
		return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
	}
	
	@Override
	public RenderShape getRenderShape(BlockState p_51567_) {
		return RenderShape.MODEL;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		Direction direction = ctx.getHorizontalDirection().getOpposite();
		
		return this.defaultBlockState().setValue(FACING, direction);
	}
	
	@Override
	public BlockState mirror(BlockState blockstate, Mirror mirror) {
		return blockstate.setValue(FACING, mirror.mirror(blockstate.getValue(FACING)));
	}
	
	@Override
	public InteractionResult use(BlockState blockstate, Level level, BlockPos blockpos, Player player, InteractionHand hand, BlockHitResult result) {
		if (level.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			player.openMenu(blockstate.getMenuProvider(level, blockpos));
			player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
			return InteractionResult.CONSUME;
		}
	}
	
	public MenuProvider getMenuProvider(BlockState blockstate, Level level, BlockPos blockpos) {
		return new SimpleMenuProvider((id, inv, player) -> {
			return new IndustrialShaperMenu(id, inv, ContainerLevelAccess.create(level, blockpos));
			}, CONTAINER_TITLE);
	}

}
