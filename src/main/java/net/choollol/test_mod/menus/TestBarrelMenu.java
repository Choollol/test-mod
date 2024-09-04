package net.choollol.test_mod.menus;

import net.choollol.test_mod.blocks.blockentities.TestBarrelBlockEntity;
import net.choollol.test_mod.items.itemstackhandlers.TestBarrelItemStackHandler;
import net.choollol.test_mod.registration.ModBlocks;
import net.choollol.test_mod.registration.ModMenuTypes;
import net.choollol.test_mod.screens.TestBarrelScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.items.ItemStackHandler;

public class TestBarrelMenu extends ModMenu {

    // Full middleHeight = 168
    public static int guiHeight = 80;

    public TestBarrelMenu(int containerId, Inventory inv, ItemStackHandler itemStackHandler){
        super(ModMenuTypes.TEST_BARREL_MENU.get(), containerId, inv, itemStackHandler, guiHeight);
        addXCenteredSlot(itemStackHandler, 20);
        addXCenteredSlot(itemStackHandler, 40);
    }
    public TestBarrelMenu(int containerId, Inventory inv){
        this(containerId, inv, new TestBarrelItemStackHandler(TestBarrelBlockEntity.SLOT_COUNT));
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(pPlayer, ModBlocks.TEST_BARREL);
    }

}
