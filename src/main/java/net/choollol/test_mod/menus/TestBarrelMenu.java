package net.choollol.test_mod.menus;

import net.choollol.test_mod.blocks.blockentities.TestBarrelEntity;
import net.choollol.test_mod.registration.ModBlocks;
import net.choollol.test_mod.registration.ModMenuTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.items.ItemStackHandler;

public class TestBarrelMenu extends ModMenu {
    public TestBarrelMenu(int containerId, Inventory inv, ItemStackHandler itemStackHandler){
        super(ModMenuTypes.TEST_BARREL_MENU.get(), containerId, inv, itemStackHandler);
        addXCenteredSlot(itemStackHandler, 60);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(pPlayer, ModBlocks.TEST_BARREL);
    }

}
