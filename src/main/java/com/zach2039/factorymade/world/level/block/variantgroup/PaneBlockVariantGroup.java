package com.zach2039.factorymade.world.level.block.variantgroup;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.zach2039.factorymade.FactoryMade;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * A group consisting of a collection of variants with a block registered for each one.
 *
 * @author Choonster
 *
 * With additions by
 * @author zach2039
 */
public class PaneBlockVariantGroup<VARIANT extends Enum<VARIANT> & StringRepresentable, PANE extends IronBarsBlock> implements IBlockVariantGroup<VARIANT, PANE> {
	private final String groupName;
	private final Iterable<VARIANT> variants;

	private final Map<VARIANT, RegistryObject<PANE>> panes;

	private PaneBlockVariantGroup(
			final String groupName, final boolean isSuffix, final Iterable<VARIANT> variants,
			final Function<VARIANT, Block.Properties> blockPropertiesFactory,
			final IronBarsBlockFactory<VARIANT, PANE> paneBlockFactory,
			final Function<VARIANT, Item.Properties> itemPropertiesFactory, final ItemFactory<VARIANT, PANE> itemFactory,
			final DeferredRegister<Block> blocks, final DeferredRegister<Item> items
	) {
		this.groupName = groupName;
		this.variants = variants;

		this.panes = register(
				groupName, isSuffix, variants,
				blockPropertiesFactory,
				paneBlockFactory, itemPropertiesFactory,
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
	 * Gets this paneblock's blocks.
	 *
	 * @return The paneblock
	 */
	@Override
	public Collection<RegistryObject<PANE>> getEntries() {
		return getBlocksMap().values();
	}

	/**
	 * Gets this group's paneblock and their corresponding variants.
	 *
	 * @return The paneblock map
	 */
	public Map<VARIANT, RegistryObject<PANE>> getBlocksMap() {
		return panes;
	}

	/**
	 * Gets the paneblock for the specified variant.
	 *
	 * @param variant The variant
	 * @return The paneblock
	 */
	public RegistryObject<PANE> getBlock(final VARIANT variant) {
		return panes.get(variant);
	}

	/**
	 * Registers the variant group's blocks and items using the provided DeferredRegister instance.
	 *
	 * @return A map of variants to their corresponding blocks
	 */
	private Map<VARIANT, RegistryObject<PANE>> register(
			final String groupName, final boolean isSuffix, final Iterable<VARIANT> variants,
			final Function<VARIANT, Block.Properties> blockPropertiesFactory,
			final IronBarsBlockFactory<VARIANT, PANE> paneFactory,
			final Function<VARIANT, Item.Properties> itemPropertiesFactory, final ItemFactory<VARIANT, PANE> itemFactory,
			final DeferredRegister<Block> blocks, final DeferredRegister<Item> items
	) {
		final ImmutableMap.Builder<VARIANT, RegistryObject<PANE>> builder = ImmutableMap.builder();

		variants.forEach(variant -> {
			final String registryName;
			if (isSuffix) {
				registryName = groupName + "_" + variant.getSerializedName();
			} else {
				registryName = variant.getSerializedName() + "_" + groupName;
			}

			final RegistryObject<PANE> block = blocks.register(registryName, () -> {
				final Block.Properties properties = blockPropertiesFactory.apply(variant);

				return paneFactory.createSlab(variant, this, properties);
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
	public interface IronBarsBlockFactory<VARIANT extends Enum<VARIANT> & StringRepresentable, PANE extends IronBarsBlock> {
		PANE createSlab(VARIANT variant, PaneBlockVariantGroup<VARIANT, PANE> variantGroup, Block.Properties properties);
	}

	/**
	 * A function that creates item blocks for a variant group.
	 *
	 * @param <VARIANT> The variant type
	 * @param <PANE>   The paneblock type
	 */
	@FunctionalInterface
	public interface ItemFactory<VARIANT extends Enum<VARIANT> & StringRepresentable, PANE extends IronBarsBlock> {
		BlockItem createItem(PANE block, Item.Properties properties, VARIANT variant);
	}

	public static class Builder<VARIANT extends Enum<VARIANT> & StringRepresentable, PANE extends IronBarsBlock> {
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
		private IronBarsBlockFactory<VARIANT, PANE> paneFactory;

		private Function<VARIANT, Item.Properties> itemPropertiesFactory = variant -> new Item.Properties().tab(FactoryMade.CREATIVE_MODE_TAB);
		private ItemFactory<VARIANT, PANE> itemFactory = (block, properties, variant) -> new BlockItem(block, properties);

		/**
		 * Creates a new variant group builder.
		 *
		 * @param blocks    The DeferredRegister instance to register the group's blocks with
		 * @param items     The DeferredRegister instance to register the group's block items with
		 * @param <VARIANT> The variant type
		 * @param <PANE>   The paneblock type
		 * @return A new Variant Group Builder
		 */
		public static <VARIANT extends Enum<VARIANT> & StringRepresentable, PANE extends IronBarsBlock> Builder<VARIANT, PANE> create(final DeferredRegister<Block> blocks, final DeferredRegister<Item> items) {
			return new Builder<>(blocks, items);
		}

		public Builder(final DeferredRegister<Block> blocks, final DeferredRegister<Item> items) {
			this.blocks = blocks;
			this.items = items;
		}

		/**
		 * Sets the variant group's name. This is used in the paneblock registry names.
		 *
		 * @param groupName The group name
		 * @return This builder
		 * @throws NullPointerException If {@code groupName} is {@code null}
		 */
		public Builder<VARIANT, PANE> groupName(final String groupName) {
			Preconditions.checkNotNull(groupName, "groupName");
			this.groupName = groupName;
			return this;
		}

		/**
		 * Configures the variant group to append the variant name as a suffix rather than a prefix.
		 *
		 * @return This builder
		 */
		public Builder<VARIANT, PANE> suffix() {
			isSuffix = true;
			return this;
		}

		/**
		 * Sets the variant group's variants. One paneblock will be created for each variant.
		 *
		 * @param variants The variants
		 * @return This builder
		 * @throws NullPointerException If {@code variants} is {@code null}
		 */
		public Builder<VARIANT, PANE> variants(final Iterable<VARIANT> variants) {
			Preconditions.checkNotNull(variants, "variants");
			this.variants = variants;
			return this;
		}

		/**
		 * Sets the variant group's variants. One paneblock will be created for each variant.
		 *
		 * @param variants The variants
		 * @return This builder
		 * @throws NullPointerException If {@code variants} is {@code null}
		 */
		public Builder<VARIANT, PANE> variants(final VARIANT[] variants) {
			Preconditions.checkNotNull(variants, "variants");
			return variants(Arrays.asList(variants));
		}

		/**
		 * Sets the factory function used to create the properties for each block.
		 *
		 * @param blockPropertiesFactory The block properties factory function
		 * @return This builder
		 * @throws NullPointerException If {@code blockPropertiesFactory} is {@code null}
		 */
		public Builder<VARIANT, PANE> blockPropertiesFactory(final Function<VARIANT, Block.Properties> blockPropertiesFactory) {
			Preconditions.checkNotNull(blockPropertiesFactory, "blockPropertiesFactory");
			this.blockPropertiesFactory = blockPropertiesFactory;
			return this;
		}

		/**
		 * Sets the factory function used to create the blocks.
		 *
		 * @param paneFactory The block factory function
		 * @return This builder
		 * @throws NullPointerException If {@code paneFactory} is {@code null}
		 */
		public Builder<VARIANT, PANE> paneFactory(final IronBarsBlockFactory<VARIANT, PANE> paneFactory) {
			Preconditions.checkNotNull(paneFactory, "paneFactory");
			this.paneFactory = paneFactory;
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
		public Builder<VARIANT, PANE> itemPropertiesFactory(final Function<VARIANT, Item.Properties> itemPropertiesFactory) {
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
		public Builder<VARIANT, PANE> itemFactory(final ItemFactory<VARIANT, PANE> itemFactory) {
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
		 * @throws IllegalStateException If the block factory hasn't been provided
		 */
		public PaneBlockVariantGroup<VARIANT, PANE> build() {
			Preconditions.checkState(groupName != null, "Group Name not provided");
			Preconditions.checkState(variants != null, "Variants not provided");
			Preconditions.checkState(blockPropertiesFactory != null, "Block Properties Factory not provided");
			Preconditions.checkState(paneFactory != null, "Block Factory not provided");

			return new PaneBlockVariantGroup<>(
					groupName, isSuffix, variants,
					blockPropertiesFactory,
					paneFactory, itemPropertiesFactory,
					itemFactory, blocks, items
			);
		}
	}
}