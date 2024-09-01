package net.choollol.test_mod.blocks.blockentities;

import net.choollol.test_mod.registration.ModBlockEntities;
import net.choollol.test_mod.screens.TestBarrelMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class TestBarrelEntity extends BlockEntity implements MenuProvider {

    private ItemStackHandler itemStackHandler = new ItemStackHandler(2);

    // ItemStackHandler indices
    private final int STACK_SIZE_MODIFIER = 0;
    private final int ITEM_STACK = 1;

    public TestBarrelEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TEST_BARREL_BE.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return null;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new TestBarrelMenu(null, pPlayerInventory, pContainerId);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("inventory", itemStackHandler.serializeNBT());
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("inventory"));
    }
}
