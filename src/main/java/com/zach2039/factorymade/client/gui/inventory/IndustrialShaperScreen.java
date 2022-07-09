package com.zach2039.factorymade.client.gui.inventory;

import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.zach2039.factorymade.world.inventory.menu.IndustrialShaperMenu;
import com.zach2039.factorymade.world.item.crafting.recipe.IndustrialShaperRecipe;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IndustrialShaperScreen extends AbstractContainerScreen<IndustrialShaperMenu> {
   private static final ResourceLocation BG_LOCATION = new ResourceLocation("textures/gui/container/stonecutter.png");
   private float scrollOffs;
   /** Is {@code true} if the player clicked on the scroll wheel in the GUI. */
   private boolean scrolling;
   /**
    * The index of the first recipe to display.
    * The number of recipes displayed at any time is 12 (4 recipes per row, and 3 rows). If the player scrolled down one
    * row, this value would be 4 (representing the index of the first slot on the second row).
    */
   private int startIndex;
   private boolean displayRecipes;

   public IndustrialShaperScreen(IndustrialShaperMenu menu, Inventory playerInv, Component title) {
      super(menu, playerInv, title);
      menu.registerUpdateListener(this::containerChanged);
      --this.titleLabelY;
   }

   public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
      super.render(poseStack, mouseX, mouseY, partialTick);
      this.renderTooltip(poseStack, mouseX, mouseY);
   }

   protected void renderBg(PoseStack poseStack, float partialTick, int x, int y) {
      this.renderBackground(poseStack);
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.setShaderTexture(0, BG_LOCATION);
      int i = this.leftPos;
      int j = this.topPos;
      this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
      int k = (int)(41.0F * this.scrollOffs);
      this.blit(poseStack, i + 119, j + 15 + k, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);
      int l = this.leftPos + 52;
      int i1 = this.topPos + 14;
      int j1 = this.startIndex + 12;
      this.renderButtons(poseStack, x, y, l, i1, j1);
      this.renderRecipes(l, i1, j1);
   }

   protected void renderTooltip(PoseStack poseStack, int x, int y) {
      super.renderTooltip(poseStack, x, y);
      if (this.displayRecipes) {
         int i = this.leftPos + 52;
         int j = this.topPos + 14;
         int k = this.startIndex + 12;
         List<IndustrialShaperRecipe> list = this.menu.getRecipes();

         for(int l = this.startIndex; l < k && l < this.menu.getNumRecipes(); ++l) {
            int i1 = l - this.startIndex;
            int j1 = i + i1 % 4 * 16;
            int k1 = j + i1 / 4 * 18 + 2;
            if (x >= j1 && x < j1 + 16 && y >= k1 && y < k1 + 18) {
               this.renderTooltip(poseStack, list.get(l).getResultItem(), x, y);
            }
         }
      }

   }

   private void renderButtons(PoseStack poseStack, int mouseX, int mouseY, int x, int y, int lastVisibleElementIndex) {
      for(int i = this.startIndex; i < lastVisibleElementIndex && i < this.menu.getNumRecipes(); ++i) {
         int j = i - this.startIndex;
         int k = x + j % 4 * 16;
         int l = j / 4;
         int i1 = y + l * 18 + 2;
         int j1 = this.imageHeight;
         if (i == this.menu.getSelectedRecipeIndex()) {
            j1 += 18;
         } else if (mouseX >= k && mouseY >= i1 && mouseX < k + 16 && mouseY < i1 + 18) {
            j1 += 36;
         }

         this.blit(poseStack, k, i1 - 1, 0, j1, 16, 18);
      }

   }

   private void renderRecipes(int left, int top, int recipeIndexOffsetMax) {
      List<IndustrialShaperRecipe> list = this.menu.getRecipes();

      for(int i = this.startIndex; i < recipeIndexOffsetMax && i < this.menu.getNumRecipes(); ++i) {
         int j = i - this.startIndex;
         int k = left + j % 4 * 16;
         int l = j / 4;
         int i1 = top + l * 18 + 2;
         this.minecraft.getItemRenderer().renderAndDecorateItem(list.get(i).getResultItem(), k, i1);
      }

   }

   public boolean mouseClicked(double mouseX, double mouseY, int button) {
      this.scrolling = false;
      if (this.displayRecipes) {
         int i = this.leftPos + 52;
         int j = this.topPos + 14;
         int k = this.startIndex + 12;

         for(int l = this.startIndex; l < k; ++l) {
            int i1 = l - this.startIndex;
            double d0 = mouseX - (double)(i + i1 % 4 * 16);
            double d1 = mouseY - (double)(j + i1 / 4 * 18);
            if (d0 >= 0.0D && d1 >= 0.0D && d0 < 16.0D && d1 < 18.0D && this.menu.clickMenuButton(this.minecraft.player, l)) {
               Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
               this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, l);
               return true;
            }
         }

         i = this.leftPos + 119;
         j = this.topPos + 9;
         if (mouseX >= (double)i && mouseX < (double)(i + 12) && mouseY >= (double)j && mouseY < (double)(j + 54)) {
            this.scrolling = true;
         }
      }

      return super.mouseClicked(mouseX, mouseY, button);
   }

   public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
      if (this.scrolling && this.isScrollBarActive()) {
         int i = this.topPos + 14;
         int j = i + 54;
         this.scrollOffs = ((float)mouseY - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
         this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
         this.startIndex = (int)((double)(this.scrollOffs * (float)this.getOffscreenRows()) + 0.5D) * 4;
         return true;
      } else {
         return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
      }
   }

   public boolean mouseScrolled(double mousX, double mouseY, double delta) {
      if (this.isScrollBarActive()) {
         int i = this.getOffscreenRows();
         float f = (float)delta / (float)i;
         this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
         this.startIndex = (int)((double)(this.scrollOffs * (float)i) + 0.5D) * 4;
      }

      return true;
   }

   private boolean isScrollBarActive() {
      return this.displayRecipes && this.menu.getNumRecipes() > 12;
   }

   protected int getOffscreenRows() {
      return (this.menu.getNumRecipes() + 4 - 1) / 4 - 3;
   }

   /**
    * Called every time this screen's container is changed (is marked as dirty).
    */
   private void containerChanged() {
      this.displayRecipes = this.menu.hasInputItem();
      if (!this.displayRecipes) {
         this.scrollOffs = 0.0F;
         this.startIndex = 0;
      }

   }
}