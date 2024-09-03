package net.choollol.test_mod.blocks.blockentities;

import net.choollol.test_mod.menus.TestBarrelMenu;
import net.choollol.test_mod.registration.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TestBarrelEntity extends ModInventoryBlockEntity {

    public static final int SLOT_COUNT = 2;

    // ItemStackHandler indices
    private final int STACK_SIZE_MODIFIER = 0;
    private final int ITEM_STACK = 1;

    public TestBarrelEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TEST_BARREL_BE.get(), pPos, pBlockState);
        menuName = "test_barrel_menu";
    }

    @Override
    public @Nullable TestBarrelMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        TestBarrelMenu menu = new TestBarrelMenu(pContainerId, pPlayerInventory, itemStackHandler);
        menu.blockEntity = this;
        return menu;
    }
}
