package net.choollol.test_mod.vessels;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class BlockVessel<T extends Block> extends Vessel {
    private DeferredBlock<T> deferredBlock;
    private List<TagKey<Block>> tags = new ArrayList<>();
    private ItemVessel<BlockItem> blockItemVessel;

    public BlockVessel(String name, String id, DeferredBlock<T> deferredBlock, List<TagKey<Block>> tags) {
        super(name, id);
        this.deferredBlock = deferredBlock;
        this.tags = tags;
    }

    public DeferredBlock<T> get() {return deferredBlock;}
    public T asBlock() {return deferredBlock.get();}
    public Item asItem() {return blockItemVessel.asItem();}
    public List<TagKey<Block>> getTags() {return tags;}

    public void setBlockItemVessel(ItemVessel<BlockItem> itemVessel){
        blockItemVessel = itemVessel;
    }
    public ItemVessel<BlockItem> getBlockItemVessel(){
        return blockItemVessel;
    }
}
