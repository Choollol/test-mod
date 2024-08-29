package net.choollol.test_mod.registries;

import net.choollol.test_mod.TM;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TM.ID);

    public static final Supplier<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TAB.register("test_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TEST_ITEM_1.get().get()))
            .title(Component.translatable("creativetab.test_mod.test_items"))
                    .displayItems((itemDisplayParameters, output) -> {output.acceptAll(getItems());
                    }).build());

    private static List<ItemStack> getItems(){
        List<ItemStack> items = new ArrayList<>();
        for (var itemVessel : ModItems.ITEM_MAP.values()){
            items.add(new ItemStack(itemVessel.asItem()));
        }
        for (var blockVessel : ModBlocks.BLOCK_MAP.values()){
            items.add(new ItemStack(blockVessel.asItem()));
        }
        return items;
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
