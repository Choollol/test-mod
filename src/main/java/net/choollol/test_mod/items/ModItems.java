package net.choollol.test_mod.items;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.vessels.ItemVessel;
import net.choollol.test_mod.items.custom.Test_Item_2;
import net.choollol.test_mod.util.ModUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItems {
    public enum ModelType{
        SIMPLE, HANDHELD
    }

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TM.ID);

    public static final HashMap<ResourceLocation, ItemVessel<? extends Item>> ITEM_MAP = new HashMap<>();

    public static final ItemVessel<Item> TEST_ITEM_1 = registerItem("Test Item 1", "test_item_1",
            ModelType.SIMPLE,
            ItemParameters.of().itemConstructor(Item::new).addTags(Tags.Items.COBBLESTONE, Tags.Items.DYES_BLUE));

    public static final ItemVessel<Test_Item_2> TEST_ITEM_2 = registerItem("Test Item 2", "test_item_2",
            ModelType.HANDHELD,
            ItemParameters.of().itemConstructor(() -> new Test_Item_2(Tiers.DIAMOND,
                    20, 5,
                    new SwordItem.Properties().durability(16)))
                    .addTags(ItemTags.COALS));

    public static <T extends Item> ItemVessel<T> registerItem(String name, String id, ModelType modelType,
                                                              ItemParameters<T> parameters, boolean doAddToMap){
        ItemVessel<T> itemVessel = new ItemVessel<T>(
                name, id,
                ITEMS.registerItem(id, parameters.itemConstructor, parameters.properties), modelType,
                parameters.tags
        );
        if (doAddToMap) {
            ITEM_MAP.put(ModUtil.idFromPath(id), itemVessel);
        }
        return itemVessel;
    }
    //Adds to map
    public static <T extends Item> ItemVessel<T> registerItem(String name, String id, ModelType modelType,
                                                              ItemParameters<T> parameters){
        return registerItem(name, id, modelType, parameters, true);
    }
    //ModelType.SIMPLE
    public static <T extends Item> ItemVessel<T> registerItem(String name, String id, ItemParameters<T> parameters){
        return registerItem(name, id, ModelType.SIMPLE, parameters);
    }
    //Does not add to map
    public static <T extends Item> ItemVessel<T> registerBlockItem(String name, String id,
                                                                   ItemParameters<T> parameters){
        return registerItem(name, id, ModelType.SIMPLE, parameters, false);
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



    public static class ItemParameters<T extends Item>{
        public final Item.Properties properties;
        public final List<TagKey<Item>> tags = new ArrayList<>();
        public Function<Item.Properties, T> itemConstructor;

        protected ItemParameters(Item.Properties properties,
                                  Function<Item.Properties, T> itemConstructor,
                                  List<TagKey<Item>> tags){
            this.properties = properties;
            this.itemConstructor = itemConstructor;
            this.tags.addAll(tags);
        }

        public static ItemParameters<Item> of(){
            return of(new Item.Properties());
        }

        public static ItemParameters<Item> of(Item.Properties properties){
            return new ItemParameters<>(properties, Item::new, List.of());
        }

        @SafeVarargs
        public final ItemParameters<T> addTags(TagKey<Item>... tags){
            return addTags(Arrays.asList(tags));
        }
        public ItemParameters<T> addTags(List<TagKey<Item>> tags){
            this.tags.addAll(tags);
            return this;
        }
        public <U extends Item> ItemParameters<U> itemConstructor(Function<Item.Properties, U> itemConstructor){
            return new ItemParameters<>(properties, itemConstructor, this.tags);
        }
        public <U extends Item> ItemParameters<U> itemConstructor(Supplier<U> itemConstructor){
            return new ItemParameters<>(properties, p -> itemConstructor.get(), this.tags);
        }
        public ItemParameters<T> stackSize(int stackSize){
            this.properties.stacksTo(stackSize);
            return this;
        }
        public ItemParameters<T> durability(int durability){
            this.properties.durability(durability);
            return this;
        }
        public ItemParameters<T> rarity(Rarity rarity){
            this.properties.rarity(rarity);
            return this;
        }
        public ItemParameters<T> food(FoodProperties food){
            this.properties.food(food);
            return this;
        }
    }
}
