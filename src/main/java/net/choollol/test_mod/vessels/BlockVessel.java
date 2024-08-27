package net.choollol.test_mod.vessels;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class BlockVessel<T extends Block> extends Vessel {
    private DeferredBlock<T> deferredBlock;
    private List<TagKey<Block>> tags = new ArrayList<>();

    public BlockVessel(String name, String id, DeferredBlock<T> deferredBlock, List<TagKey<Block>> tags) {
        super(name, id);
        this.deferredBlock = deferredBlock;
    }

    public DeferredBlock<T> get() {return deferredBlock;}
    public List<TagKey<Block>> getTags() {return tags;}
}
