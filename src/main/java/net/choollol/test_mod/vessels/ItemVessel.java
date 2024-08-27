package net.choollol.test_mod.vessels;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;

public class ItemVessel<T extends Item> extends Vessel {
    private DeferredItem<T> deferredItem;
    private List<TagKey<Item>> tags = new ArrayList<>();

    public ItemVessel(String name, String id, DeferredItem<T> deferredItem, List<TagKey<Item>> tags) {
        super(name, id);
        this.deferredItem = deferredItem;
    }

    public DeferredItem<T> get() {return deferredItem;}
    public List<TagKey<Item>> getTags() {return tags;}
}
