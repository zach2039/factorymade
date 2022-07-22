package com.zach2039.factorymade.world.inventory.menu;

import com.google.common.collect.Lists;
import com.zach2039.factorymade.init.ModBlocks;
import com.zach2039.factorymade.init.ModMenuTypes;
import com.zach2039.factorymade.init.ModRecipeTypes;
import com.zach2039.factorymade.world.item.crafting.recipe.IndustrialShaperRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.IContainerFactory;

import java.util.List;

public class IndustrialShaperMenu extends AbstractContainerMenu {
	public static final int INPUT_SLOT = 0;
	public static final int RESULT_SLOT = 1;

	private final ContainerLevelAccess access;
	/** The index of the selected recipe in the GUI. */
	private final DataSlot selectedRecipeIndex = DataSlot.standalone();
	private final Level level;
	private List<IndustrialShaperRecipe> recipes = Lists.newArrayList();
	/** The {@plainlink ItemStack} set in the input slot by the player. */
	private ItemStack input = ItemStack.EMPTY;
	/**
	 * Stores the game time of the last time the player took items from the the crafting result slot. This is used to
	 * prevent the sound from being played multiple times on the same tick.
	 */
	long lastSoundTime;
	final Slot inputSlot;
	/** The inventory slot that stores the output of the crafting recipe. */
	final Slot resultSlot;
	Runnable slotUpdateListener = () -> {};
	public final Container container = new SimpleContainer(1) {
		/**
		 * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think
		 * it hasn't changed and skip it.
		 */
		public void setChanged() {
			super.setChanged();
			IndustrialShaperMenu.this.slotsChanged(this);
			IndustrialShaperMenu.this.slotUpdateListener.run();
		}
	};
	/** The inventory that stores the output of the crafting recipe. */
	final ResultContainer resultContainer = new ResultContainer();

	public IndustrialShaperMenu(int id, Inventory inv) {
		this(id, inv, ContainerLevelAccess.NULL);
	}

	public IndustrialShaperMenu(int id, Inventory inv, final ContainerLevelAccess access) {
		super(ModMenuTypes.INDUSTRIAL_SHAPER.get(), id);
		this.access = access;
		this.level = inv.player.level;
		this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
		this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
			/**
			 * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
			 */
			public boolean mayPlace(ItemStack stack) {
				return false;
			}

			public void onTake(Player player, ItemStack stack) {
				stack.onCraftedBy(player.level, player, stack.getCount());
				IndustrialShaperMenu.this.resultContainer.awardUsedRecipes(player);
				ItemStack itemstack = IndustrialShaperMenu.this.inputSlot.remove(1);
				if (!itemstack.isEmpty()) {
					IndustrialShaperMenu.this.setupResultSlot();
				}

				access.execute((level, blockpos) -> {
					long l = level.getGameTime();
					if (IndustrialShaperMenu.this.lastSoundTime != l) {
						level.playSound((Player)null, blockpos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
						IndustrialShaperMenu.this.lastSoundTime = l;
					}

				});
				super.onTake(player, stack);
			}
		});

		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(inv, k, 8 + k * 18, 142));
		}

		this.addDataSlot(this.selectedRecipeIndex);
	}

	/**
	 * Returns the index of the selected recipe.
	 */
	public int getSelectedRecipeIndex() {
		return this.selectedRecipeIndex.get();
	}

	public List<IndustrialShaperRecipe> getRecipes() {
		return this.recipes;
	}

	public int getNumRecipes() {
		return this.recipes.size();
	}

	public boolean hasInputItem() {
		return this.inputSlot.hasItem() && !this.recipes.isEmpty();
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	public boolean stillValid(Player player) {
		return stillValid(this.access, player, ModBlocks.INDUSTRIAL_SHAPER.get());
	}

	/**
	 * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
	 */
	public boolean clickMenuButton(Player player, int id) {
		if (this.isValidRecipeIndex(id)) {
			this.selectedRecipeIndex.set(id);
			this.setupResultSlot();
		}

		return true;
	}

	private boolean isValidRecipeIndex(int idx) {
		return idx >= 0 && idx < this.recipes.size();
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	public void slotsChanged(Container container) {
		ItemStack itemstack = this.inputSlot.getItem();
		if (!itemstack.is(this.input.getItem())) {
			this.input = itemstack.copy();
			this.setupRecipeList(container, itemstack);
		}

	}

	private void setupRecipeList(Container container, ItemStack stack) {
		this.recipes.clear();
		this.selectedRecipeIndex.set(-1);
		this.resultSlot.set(ItemStack.EMPTY);
		if (!stack.isEmpty()) {
			this.recipes = this.level.getRecipeManager().getRecipesFor(ModRecipeTypes.INDUSTRIAL_SHAPER.get(), container, this.level);
		}

	}

	void setupResultSlot() {
		if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
			IndustrialShaperRecipe recipe = this.recipes.get(this.selectedRecipeIndex.get());
			this.resultContainer.setRecipeUsed(recipe);
			this.resultSlot.set(recipe.assemble(this.container));
		} else {
			this.resultSlot.set(ItemStack.EMPTY);
		}

		this.broadcastChanges();
	}

	public MenuType<?> getType() {
		return ModMenuTypes.INDUSTRIAL_SHAPER.get();
	}

	public void registerUpdateListener(Runnable pListener) {
		this.slotUpdateListener = pListener;
	}

	/**
	 * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is
	 * null for the initial slot that was double-clicked.
	 */
	public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
		return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
	}

	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
	 * inventory and the other inventory(s).
	 */
	public ItemStack quickMoveStack(Player player, int idx) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(idx);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			Item item = itemstack1.getItem();
			itemstack = itemstack1.copy();
			if (idx == 1) {
				item.onCraftedBy(itemstack1, player.level, player);
				if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(itemstack1, itemstack);
			} else if (idx == 0) {
				if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
					return ItemStack.EMPTY;
				}
			} else if (this.level.getRecipeManager().getRecipeFor(ModRecipeTypes.INDUSTRIAL_SHAPER.get(), new SimpleContainer(itemstack1), this.level).isPresent()) {
				if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
					return ItemStack.EMPTY;
				}
			} else if (idx >= 2 && idx < 29) {
				if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
					return ItemStack.EMPTY;
				}
			} else if (idx >= 29 && idx < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			}

			slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(player, itemstack1);
			this.broadcastChanges();
		}

		return itemstack;
	}

	/**
	 * Called when the container is closed.
	 */
	public void removed(Player player) {
		super.removed(player);
		this.resultContainer.removeItemNoUpdate(1);
		this.access.execute((p_40313_, p_40314_) -> {
			this.clearContainer(player, this.container);
		});
	}
	
	public static class Factory implements IContainerFactory<IndustrialShaperMenu> {
		@Override
		public IndustrialShaperMenu create(final int windowId, final Inventory inv, final FriendlyByteBuf data) {
			return new IndustrialShaperMenu(windowId, inv);
		}
	}
}