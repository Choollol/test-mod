package net.choollol.test_mod;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TM.ID);

    public static final DeferredItem<Item> TEST_ITEM_1 = ITEMS.register("test_item_1",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
