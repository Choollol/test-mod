package net.choollol.test_mod.screens;

import net.choollol.test_mod.registration.ModBlocks;
import net.choollol.test_mod.vessels.BlockVessel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import org.jetbrains.annotations.Nullable;

public class TestBarrelMenu extends ModMenu {
    public TestBarrelMenu(@Nullable MenuType<?> pMenuType, Inventory inv, int pContainerId) {
        super(pMenuType, inv, pContainerId);
        
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(pPlayer, ModBlocks.TEST_BARREL);
    }
}
