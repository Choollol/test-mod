package net.choollol.test_mod.screens;

import net.choollol.test_mod.menus.TestBarrelMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class TestBarrelScreen extends ModScreen<TestBarrelMenu> {
    public TestBarrelScreen(TestBarrelMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
