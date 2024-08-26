package net.choollol.test_mod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.choollol.test_mod.blocks.*;

import java.util.function.Supplier;

public class TMBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TM.ID);

    public static final DeferredBlock<Block> TEST_BLOCK_1 = registerBlock("test_block_1",
            () -> new Test_Block_1(BlockBehaviour.Properties.of().
                    sound(SoundType.AMETHYST).strength(2f).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        TMItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
