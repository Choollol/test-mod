package net.choollol.test_mod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TMCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TM.ID);

    public static final Supplier<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TAB.register("test_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(TMItems.TEST_ITEM_1.get()))
            .title(Component.translatable("creativetab.test_mod.test_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(TMItems.TEST_ITEM_1);
                        output.accept(TMItems.TEST_ITEM_2);
                        output.accept(TMBlocks.TEST_BLOCK_1);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
