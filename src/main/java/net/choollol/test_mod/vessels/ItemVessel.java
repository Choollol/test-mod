package net.choollol.test_mod.vessels;

import net.choollol.test_mod.registration.ModItems;
import net.choollol.test_mod.registration.ModItems.ItemModelType;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;

public class ItemVessel<T extends Item> extends Vessel {
    private DeferredItem<T> deferredItem;
    private List<TagKey<Item>> tags = new ArrayList<>();
    private ItemModelType modelType;

    public ItemVessel(String name, String id, DeferredItem<T> deferredItem, ItemModelType modelType,
                      List<TagKey<Item>> tags) {
        super(name, id);
        this.deferredItem = deferredItem;
        this.modelType = modelType;
        this.tags = tags;
    }

    public DeferredItem<T> get() {return deferredItem;}
    public T asItem() {return deferredItem.get();}
    public ItemModelType getModelType() {return modelType;}
    public List<TagKey<Item>> getTags() {return tags;}
}
