package net.choollol.test_mod;

import net.choollol.test_mod.items.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TM.ID);

    public static final DeferredItem<Item> TEST_ITEM_1 = ITEMS.register("test_item_1",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TEST_ITEM_2 = ITEMS.register("test_item_2",
            () -> new Test_Item_2(Tiers.DIAMOND, 20, 5,
                    new SwordItem.Properties().durability(16)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
