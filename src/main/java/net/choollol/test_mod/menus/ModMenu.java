package net.choollol.test_mod.menus;

import net.choollol.test_mod.vessels.BlockVessel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class ModMenu extends AbstractContainerMenu {

    private int index = 0;

    protected Level level;
    protected BlockEntity blockEntity;

    protected final ContainerLevelAccess access;

    public ModMenu(MenuType<?> pMenuType, int pContainerId, Inventory inv, int slotCount) {
        this(pMenuType, pContainerId, inv, new ItemStackHandler(slotCount), ContainerLevelAccess.NULL);
    }
    public ModMenu(MenuType<?> pMenuType, int pContainerId, Inventory inv, IItemHandler dataInventory) {
        this(pMenuType, pContainerId, inv, dataInventory, ContainerLevelAccess.NULL);
    }
    public ModMenu(MenuType<?> menuType, int containerId, Inventory inv,
                   IItemHandler dataInventory, ContainerLevelAccess containerLevelAccess){
        super(menuType, containerId);
        index = 0;
        addPlayerInventoryAndHotbar(inv);
        this.access = containerLevelAccess;
        //addDataSlot(dataSingle);
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int TE_INVENTORY_SLOT_COUNT = 2;
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }

    public <T extends Block> boolean stillValid(Player pPlayer, BlockVessel<T> blockVessel) {
        /*return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, blockVessel.asBlock());*/
        return AbstractContainerMenu.stillValid(access, pPlayer, blockVessel.asBlock());
    }

    private void addPlayerInventoryAndHotbar(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    protected void addSlot(IItemHandler dataInventory, int xPos, int yPos){
        addSlot(new SlotItemHandler(dataInventory, index, xPos, yPos));
        index++;
    }
    protected void addXCenteredSlot(IItemHandler itemHandler, int yPos){
        addSlot(itemHandler, 128 - 18 / 2, yPos);
    }
}
