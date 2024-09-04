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

    protected int guiHeight;

    protected String textureBasePath = "textures/gui/";
    protected ResourceLocation backgroundTexture = new ResourceLocation(TM.ID, textureBasePath + "menu_background.png");

    public ModScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        this.imageHeight = 4 + guiHeight + 84;
        super.init();
        this.inventoryLabelY = this.imageHeight - 104;
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        drawBackground(pGuiGraphics, guiHeight);
    }

    protected void drawBackground(GuiGraphics guiGraphics, int middleHeight){
        int invHeight = 84;
        int topHeight = 4;
        int imageWidth = 256;
        int x = (width - imageWidth) / 2;
        int y = (256 - invHeight - middleHeight - topHeight) / 2;

        // Top
        guiGraphics.blit(backgroundTexture, x, y, 0, 0, imageWidth, topHeight);
        // Middle
        guiGraphics.blit(backgroundTexture, x, y + topHeight, 0, topHeight, imageWidth, middleHeight);
        // Inventory
        guiGraphics.blit(backgroundTexture, x, y + topHeight + middleHeight, 0,
                168 + topHeight, imageWidth, invHeight);
    }
}
