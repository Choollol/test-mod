package net.choollol.test_mod.menus;

import net.choollol.test_mod.blocks.blockentities.TestBarrelBlockEntity;
import net.choollol.test_mod.itemstackhandlers.TestBarrelItemStackHandler;
import net.choollol.test_mod.registration.ModBlocks;
import net.choollol.test_mod.registration.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.items.ItemStackHandler;

public class TestBarrelMenu extends ModMenu {

    public static final String TITLE = BASE_PATH + "test_barrel_menu";

    public static int guiHeight = 80;

    public static int upgradeSlotY = 20;
    public static int itemSlotY = 50;

    public static MenuProvider getServerMenuProvider(TestBarrelBlockEntity blockEntity, BlockPos pos){
        return new SimpleMenuProvider((id, inv, player) ->
                new TestBarrelMenu(id, inv, blockEntity.getItemStackHandler()).setBlockEntity(blockEntity),
                Component.translatable(TITLE));
    }

    public TestBarrelMenu(int containerId, Inventory inv, ItemStackHandler itemStackHandler){
        super(ModMenuTypes.TEST_BARREL_MENU.get(), containerId, inv, guiHeight);
        slotCount = TestBarrelItemStackHandler.SLOT_COUNT;
        addXCenteredSlot(itemStackHandler, upgradeSlotY);
        addXCenteredSlot(itemStackHandler, itemSlotY);
    }
    public TestBarrelMenu(int containerId, Inventory inv){
        this(containerId, inv, new TestBarrelItemStackHandler());
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(pPlayer, ModBlocks.TEST_BARREL);
    }

}
