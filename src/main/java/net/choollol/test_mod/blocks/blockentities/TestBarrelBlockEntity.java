package net.choollol.test_mod.blocks.blockentities;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.itemstackhandlers.TestBarrelItemStackHandler;
import net.choollol.test_mod.menus.TestBarrelMenu;
import net.choollol.test_mod.registration.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class TestBarrelBlockEntity extends ModInventoryBlockEntity {

    // ItemStackHandler indices
    private final int STACK_SIZE_MODIFIER = 0;
    private final int ITEM_STACK = 1;

    public TestBarrelBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TEST_BARREL_BE.get(), pPos, pBlockState);
        itemStackHandler = new TestBarrelItemStackHandler();
    }

    @Override
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++){
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }
        Containers.dropContents(level, worldPosition, inventory);
    }
}
