package net.choollol.test_mod.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.choollol.test_mod.TM;
import net.choollol.test_mod.menus.ModMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ModScreen <T extends ModMenu> extends AbstractContainerScreen<T> {

    protected String textureBasePath = "textures/gui/";
    protected ResourceLocation backgroundTexture = new ResourceLocation(TM.ID, textureBasePath + "menu_background.png");

    public ModScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        pGuiGraphics.blit(backgroundTexture, (width - 256) / 2, 20, 0, 0, 256, 256);
    }
    protected void drawBackground(GuiGraphics guiGraphics, int height){

    }
}
