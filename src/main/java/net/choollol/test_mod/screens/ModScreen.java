package net.choollol.test_mod.screens;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.menus.ModMenu;
import net.choollol.test_mod.util.ModUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class ModScreen <T extends ModMenu> extends AbstractContainerScreen<T> {

    protected int guiHeight;

    protected String textureBasePath = "textures/gui/";
    protected ResourceLocation backgroundTexture = ModUtil.pathFromId(textureBasePath + "menu_background.png");
    protected ResourceLocation slotTexture = ModUtil.pathFromId(textureBasePath + "slot.png");

    public ModScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        this.imageHeight = 4 + guiHeight + 84;
        super.init();
        this.inventoryLabelY = this.imageHeight - 104;
        this.titleLabelY = 4;
    }

    @Override
    protected void renderSlot(GuiGraphics guiGraphics, Slot slot) {
        guiGraphics.blit(slotTexture, slot.x - 1, slot.y - 1,
                0, 0, 18, 18, 18, 18);
        super.renderSlot(guiGraphics, slot);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        drawBackground(pGuiGraphics);
    }

    // Full guiHeight = 168
    protected void drawBackground(GuiGraphics guiGraphics){
        int invHeight = 84;
        int topHeight = 4;
        int menuWidth = 176;
        int menuX = (width - menuWidth) / 2;
        int menuY = (256 - invHeight - guiHeight - topHeight) / 2;
        // Top
        guiGraphics.blit(backgroundTexture, menuX, menuY, 0, 0, menuWidth, topHeight, menuWidth, 256);
        // Middle
        guiGraphics.blit(backgroundTexture, menuX, menuY + topHeight, 0, topHeight, menuWidth, guiHeight, menuWidth, 256);
        // Inventory
        guiGraphics.blit(backgroundTexture, menuX, menuY + topHeight + guiHeight, 0,
                168 + topHeight, menuWidth, invHeight, menuWidth, 256);
    }
}
