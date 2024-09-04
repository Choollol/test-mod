package net.choollol.test_mod.items.itemstackhandlers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBarrelItemStackHandler extends ItemStackHandler {

    private int stackLimit = 8;
    private int[] stackLimits = { 16, 32, 64 };

    private List<Item> stackLimitUpgrades = new ArrayList<>();

    public TestBarrelItemStackHandler(int size){
        super(size);
        Item[] upgrades = { Items.IRON_BLOCK, Items.GOLD_BLOCK, Items.DIAMOND_BLOCK };
        stackLimitUpgrades.addAll(Arrays.asList(upgrades));
    }

    @Override
    protected int getStackLimit(int slot, ItemStack stack){
        if (slot == 1) {
            return stackLimit;
        }
        else {
            return 1;
        }
    }

    @Override
    protected void onContentsChanged(int slot) {
        if (slot != 0){
            return;
        }
        for (int i = 0; i < stackLimitUpgrades.size(); i++){
            if (getStackInSlot(slot).getItem().equals(stackLimitUpgrades.get(i))){
                stackLimit = stackLimits[i];
            }
        }
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        if (stack.isEmpty()){
            return true;
        }
        if (slot == 0){
            for (Item stackLimitUpgrade : stackLimitUpgrades) {
                if (stack.getItem().equals(stackLimitUpgrade)) {
                    return true;
                }
            }
        }
        else if (slot == 1){
            if (stack.getItem().equals(getStackInSlot(1).getItem())){
                return true;
            }
        }
        return false;
    }
}
