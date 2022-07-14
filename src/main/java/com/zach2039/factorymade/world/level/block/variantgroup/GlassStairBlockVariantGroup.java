package com.zach2039.factorymade.world.level.block.variantgroup;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.zach2039.factorymade.FactoryMade;
import com.zach2039.factorymade.world.level.block.base.GlassStairBlock;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * A group consisting of a collection of variants with a block registered for each one.
 *
 * @author Choonster
 *
 * With additions by
 * @author zach2039
 */
public class GlassStairBlockVariantGroup<VARIANT extends Enum<VARIANT> & StringRepresentable, STAIR extends GlassStairBlock> implements IBlockVariantGroup<VARIANT, STAIR> {
	private final String groupName;
	private final Iterable<VARIANT> variants;

	private final Map<VARIANT, RegistryObject<STAIR>> stairs;

	private GlassStairBlockVariantGroup(
			final String groupName, final boolean isSuffix, final Iterable<VARIANT> variants,
			final Function<VARIANT, Block.Properties> blockPropertiesFactory,
			final Function<VARIANT, Supplier<BlockState>> blockStateSupplierFactory,
			final GlassStairBlockFactory<VARIANT, STAIR> stairBlockFactory,
			final Function<VARIANT, Item.Properties> itemPropertiesFactory, final ItemFactory<VARIANT, STAIR> itemFactory,
			final DeferredRegister<Block> blocks, final DeferredRegister<Item> items
	) {
		this.groupName = groupName;
		this.variants = variants;

		this.stairs = register(
				groupName, isSuffix, variants,
				blockPropertiesFactory, blockStateSupplierFactory,
				stairBlockFactory, itemPropertiesFactory,
				itemFactory, blocks, items
		);
	}

	/**
	 * Gets the name of this group.
	 *
	 * @return The group name
	 */
	@Override
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Gets this group's variants.
	 *
	 * @return The variants
	 */
	@Override
	public Iterable<VARIANT> getVariants() {
		return variants;
	}

	/**
	 * Gets this stairblock's blocks.
	 *
	 * @return The stairblock
	 */
	@Override
	public Collection<RegistryObject<STAIR>> getEntries() {
		return getBlocksMap().values();
	}

	/**
	 * Gets this group's stairblock and their corresponding variants.
	 *
	 * @return The stairblock map
	 */
	public Map<VARIANT, RegistryObject<STAIR>> getBlocksMap() {
		return stairs;
	}

	/**
	 * Gets the stairblock for the specified variant.
	 *
	 * @param variant The variant
	 * @return The stairblock
	 */
	public RegistryObject<STAIR> getBlock(final VARIANT variant) {
		return stairs.get(variant);
	}

	/**
	 * Registers the variant group's blocks and items using the provided DeferredRegister instance.
	 *
	 * @return A map of variants to their corresponding blocks
	 */
	private Map<VARIANT, RegistryObject<STAIR>> register(
			final String groupName, final boolean isSuffix, final Iterable<VARIANT> variants,
			final Function<VARIANT, Block.Properties> blockPropertiesFactory,
			final Function<VARIANT, Supplier<BlockState>> blockStateSupplierFactory,
			final GlassStairBlockFactory<VARIANT, STAIR> stairFactory,
			final Function<VARIANT, Item.Properties> itemPropertiesFactory, final ItemFactory<VARIANT, STAIR> itemFactory,
			final DeferredRegister<Block> blocks, final DeferredRegister<Item> items
	) {
		final ImmutableMap.Builder<VARIANT, RegistryObject<STAIR>> builder = ImmutableMap.builder();

		variants.forEach(variant -> {
			final String registryName;
			if (isSuffix) {
				registryName = groupName + "_" + variant.getSerializedName();
			} else {
				registryName = variant.getSerializedName() + "_" + groupName;
			}

			final RegistryObject<STAIR> block = blocks.register(registryName, () -> {
				final Block.Properties properties = blockPropertiesFactory.apply(variant);
				final Supplier<BlockState> blockstate = blockStateSupplierFactory.apply(variant);

				return stairFactory.createStair(variant, this, blockstate, properties);
			});

			builder.put(variant, block);

			items.register(registryName, () -> {
				final Item.Properties properties = itemPropertiesFactory.apply(variant);

				return itemFactory.createItem(block.get(), properties, variant);
			});
		});

		return builder.build();
	}

	@FunctionalInterface
	public interface GlassStairBlockFactory<VARIANT extends Enum<VARIANT> & StringRepresentable, STAIR extends GlassStairBlock> {
		STAIR createStair(VARIANT variant, GlassStairBlockVariantGroup<VARIANT, STAIR> variantGroup, Supplier<BlockState> blockStateProvider, Block.Properties properties);
	}

	/**
	 * A function that creates item blocks for a variant group.
	 *
	 * @param <VARIANT> The variant type
	 * @param <STAIR>   The stairblock type
	 */
	@FunctionalInterface
	public interface ItemFactory<VARIANT extends Enum<VARIANT> & StringRepresentable, STAIR extends GlassStairBlock> {
		BlockItem createItem(STAIR block, Item.Properties properties, VARIANT variant);
	}

	public static class Builder<VARIANT extends Enum<VARIANT> & StringRepresentable, STAIR extends GlassStairBlock> {
		private final DeferredRegister<Block> blocks;
		private final DeferredRegister<Item> items;

		@Nullable
		private String groupName;
		private boolean isSuffix;
		@Nullable
		private Iterable<VARIANT> variants;

		@Nullable
		private Function<VARIANT, Block.Properties> blockPropertiesFactory;
		@Nullable
		private Function<VARIANT, Supplier<BlockState>> blockStateSupplierFactory;
		@Nullable
		private GlassStairBlockFactory<VARIANT, STAIR> stairFactory;

		private Function<VARIANT, Item.Properties> itemPropertiesFactory = variant -> new Item.Properties().tab(FactoryMade.CREATIVE_MODE_TAB);
		private ItemFactory<VARIANT, STAIR> itemFactory = (block, properties, variant) -> new BlockItem(block, properties);

		/**
		 * Creates a new variant group builder.
		 *
		 * @param blocks    The DeferredRegister instance to register the group's blocks with
		 * @param items     The DeferredRegister instance to register the group's block items with
		 * @param <VARIANT> The variant type
		 * @param <STAIR>   The stairblock type
		 * @return A new Variant Group Builder
		 */
		public static <VARIANT extends Enum<VARIANT> & StringRepresentable, STAIR extends GlassStairBlock> Builder<VARIANT, STAIR> create(final DeferredRegister<Block> blocks, final DeferredRegister<Item> items) {
			return new Builder<>(blocks, items);
		}

		public Builder(final DeferredRegister<Block> blocks, final DeferredRegister<Item> items) {
			this.blocks = blocks;
			this.items = items;
		}

		/**
		 * Sets the variant group's name. This is used in the stairblock registry names.
		 *
		 * @param groupName The group name
		 * @return This builder
		 * @throws NullPointerException If {@code groupName} is {@code null}
		 */
		public Builder<VARIANT, STAIR> groupName(final String groupName) {
			Preconditions.checkNotNull(groupName, "groupName");
			this.groupName = groupName;
			return this;
		}

		/**
		 * Configures the variant group to append the variant name as a suffix rather than a prefix.
		 *
		 * @return This builder
		 */
		public Builder<VARIANT, STAIR> suffix() {
			isSuffix = true;
			return this;
		}

		/**
		 * Sets the variant group's variants. One stairblock will be created for each variant.
		 *
		 * @param variants The variants
		 * @return This builder
		 * @throws NullPointerException If {@code variants} is {@code null}
		 */
		public Builder<VARIANT, STAIR> variants(final Iterable<VARIANT> variants) {
			Preconditions.checkNotNull(variants, "variants");
			this.variants = variants;
			return this;
		}

		/**
		 * Sets the variant group's variants. One stairblock will be created for each variant.
		 *
		 * @param variants The variants
		 * @return This builder
		 * @throws NullPointerException If {@code variants} is {@code null}
		 */
		public Builder<VARIANT, STAIR> variants(final VARIANT[] variants) {
			Preconditions.checkNotNull(variants, "variants");
			return variants(Arrays.asList(variants));
		}

		/**
		 * Sets the factory function used to create the blockstate provider for each block.
		 *
		 * @param blockStateSupplierFactory The blockstate provider factory function
		 * @return This builder
		 * @throws NullPointerException If {@code blockStateProviderFactory} is {@code null}
		 */
		public Builder<VARIANT, STAIR> blockStateProviderFactory(final Function<VARIANT, Supplier<BlockState>> blockStateSupplierFactory) {
			Preconditions.checkNotNull(blockStateSupplierFactory, "blockStateProviderFactory");
			this.blockStateSupplierFactory = blockStateSupplierFactory;
			return this;
		}

		/**
		 * Sets the factory function used to create the properties for each block.
		 *
		 * @param blockPropertiesFactory The block properties factory function
		 * @return This builder
		 * @throws NullPointerException If {@code blockPropertiesFactory} is {@code null}
		 */
		public Builder<VARIANT, STAIR> blockPropertiesFactory(final Function<VARIANT, Block.Properties> blockPropertiesFactory) {
			Preconditions.checkNotNull(blockPropertiesFactory, "blockPropertiesFactory");
			this.blockPropertiesFactory = blockPropertiesFactory;
			return this;
		}

		/**
		 * Sets the factory function used to create the blocks.
		 *
		 * @param stairFactory The block factory function
		 * @return This builder
		 * @throws NullPointerException If {@code stairFactory} is {@code null}
		 */
		public Builder<VARIANT, STAIR> stairFactory(final GlassStairBlockFactory<VARIANT, STAIR> stairFactory) {
			Preconditions.checkNotNull(stairFactory, "stairFactory");
			this.stairFactory = stairFactory;
			return this;
		}

		/**
		 * Sets the factory function used to create the properties for each block item.
		 * <p>
		 * If no item properties factory is specified, a factory producing item properties with the {@link CreativeModeTab}
		 * set to {@link FactoryMade#CREATIVE_MODE_TAB} is used.
		 *
		 * @param itemPropertiesFactory The item properties factory function
		 * @return This builder
		 * @throws NullPointerException If {@code itemPropertiesFactory} is {@code null}
		 */
		public Builder<VARIANT, STAIR> itemPropertiesFactory(final Function<VARIANT, Item.Properties> itemPropertiesFactory) {
			Preconditions.checkNotNull(itemPropertiesFactory, "itemPropertiesFactory");
			this.itemPropertiesFactory = itemPropertiesFactory;
			return this;
		}

		/**
		 * Sets the factory function used to create the block items.
		 * <p>
		 * If no item factory is specified, a factory producing {@link BlockItem} is used.
		 *
		 * @param itemFactory The item factory function
		 * @return This builder
		 * @throws NullPointerException If {@code itemFactory} is {@code null}
		 */
		public Builder<VARIANT, STAIR> itemFactory(final ItemFactory<VARIANT, STAIR> itemFactory) {
			Preconditions.checkNotNull(itemFactory, "itemFactory");
			this.itemFactory = itemFactory;
			return this;
		}

		/**
		 * Creates a block variant group based on the data in this builder.
		 *
		 * @return The variant group
		 * @throws IllegalStateException If the group name hasn't been provided
		 * @throws IllegalStateException If the variants haven't been provided
		 * @throws IllegalStateException If the blockPropertiesFactory hasn't been provided
		 * @throws IllegalStateException If the blockStateSupplierFactory hasn't been provided
		 * @throws IllegalStateException If the block factory hasn't been provided
		 */
		public GlassStairBlockVariantGroup<VARIANT, STAIR> build() {
			Preconditions.checkState(groupName != null, "Group Name not provided");
			Preconditions.checkState(variants != null, "Variants not provided");
			Preconditions.checkState(blockPropertiesFactory != null, "Block Properties Factory not provided");
			Preconditions.checkState(blockStateSupplierFactory != null, "BlockState Supplier Factory not provided");
			Preconditions.checkState(stairFactory != null, "Block Factory not provided");

			return new GlassStairBlockVariantGroup<>(
					groupName, isSuffix, variants,
					blockPropertiesFactory,	blockStateSupplierFactory,
					stairFactory, itemPropertiesFactory,
					itemFactory, blocks, items
			);
		}
	}
}