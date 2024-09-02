package net.choollol.test_mod.screens;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.menus.ModMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ModScreen <T extends ModMenu> extends AbstractContainerScreen<T> {

    protected String textureBasePath = "textures/gui/";
    protected ResourceLocation backgroundTexture;

    public ModScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        backgroundTexture = new ResourceLocation(TM.ID, textureBasePath + "menu_background.png");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        pGuiGraphics.blitSprite(backgroundTexture, (width - imageWidth) / 2,
                (height - imageHeight) / 2, imageWidth, imageHeight);
    }
}
