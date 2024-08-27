package net.choollol.test_mod;

import net.choollol.test_mod.blocks.Test_Block_1;
import net.choollol.test_mod.vessels.BlockVessel;
import net.choollol.test_mod.util.ModTags;
import net.choollol.test_mod.util.ModUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TM.ID);

    /*public static final SortedMap<ResourceLocation, DeferredBlock<? extends Block>> BLOCK_MAP = new TreeMap<>();

    public static final HashMap<TagKey<Block>, ArrayList<Block>> BLOCK_TAGS = new HashMap<>();

    *//*public static final DeferredBlock<Block> TEST_BLOCK_1 = registerBlock("test_block_1",
            () -> new Test_Block_1(BlockBehaviour.Properties.of().
                    sound(SoundType.AMETHYST).strength(2f).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }*//*

    public static final DeferredBlock<Test_Block_1> TEST_BLOCK_1 = registerBlock("test_block_1",
            BlockParameters.defaultStone().blockConstructor(Test_Block_1::new).destroyTime(6f).
                    addTags(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE,
                            ModTags.Blocks.TEST_BLOCK, Tags.Blocks.COBBLESTONE));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, BlockParameters<T> parameters){
        DeferredBlock<T> deferredBlock = BLOCKS.registerBlock(name, parameters.blockConstructor, parameters.properties);
        BLOCK_MAP.put(new ResourceLocation(TM.ID, name), deferredBlock);
        registerBlockItem(name, deferredBlock, parameters.tags);
        //parameters.tags.forEach(tag -> BLOCK_TAGS.get(tag).add(deferredBlock.get()));
        return deferredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block,
                                                            List<TagKey<Block>> tags){
        ModItems.registerItem(name, c -> new BlockItem(block.get(), new Item.Properties()));
    }*/

    public static final HashMap<ResourceLocation, BlockVessel<? extends Block>> BLOCK_MAP = new HashMap<>();

    public static final BlockVessel<Test_Block_1> TEST_BLOCK_1 = registerBlock("Test Block 1", "test_block_1",
            BlockParameters.defaultStone().blockConstructor(Test_Block_1::new).destroyTime(6f).
                    addTags(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE,
                            ModTags.Blocks.TEST_BLOCK, Tags.Blocks.COBBLESTONE));

    private static <T extends Block> BlockVessel<T> registerBlock(String name, String id, BlockParameters<T> parameters){
        BlockVessel<T> blockVessel = new BlockVessel<T>(name, id,
                BLOCKS.registerBlock(id, parameters.blockConstructor, parameters.properties),
                parameters.tags
        );
        BLOCK_MAP.put(ModUtil.idFromPath(id), blockVessel);
        registerBlockItem(blockVessel);
        return blockVessel;
    }

    private static <T extends Block> void registerBlockItem(BlockVessel<T> blockVessel){
        var tags = new ArrayList<TagKey<Item>>();
        for (var tag : blockVessel.getTags()){
            tags.add(tag.cast(ItemTags.ACACIA_LOGS.registry()).get());
        }
        ModItems.registerItem(blockVessel.getName(), blockVessel.getPath(),
                ModItems.ItemParameters.of().itemConstructor(() -> new BlockItem(blockVessel.get().get(),
                        new Item.Properties()))
                        .addTags(tags));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }



    public static class BlockParameters<T extends Block>{
        public final BlockBehaviour.Properties properties;
        public final List<TagKey<Block>> tags = new ArrayList<>();
        public Function<BlockBehaviour.Properties, T> blockConstructor;

        protected BlockParameters(BlockBehaviour.Properties properties,
                                  Function<BlockBehaviour.Properties, T> blockConstructor,
                                  List<TagKey<Block>> tags){
            this.properties = properties;
            this.blockConstructor = blockConstructor;
            this.tags.addAll(tags);
        }

        public static BlockParameters<Block> of(){
            return of(BlockBehaviour.Properties.of());
        }

        public static BlockParameters<Block> of(BlockBehaviour.Properties properties){
            return new BlockParameters<>(properties, Block::new,
                    List.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE));
        }
        public static BlockParameters<Block> defaultStone() {
            return of(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).destroyTime(4.0f).requiresCorrectToolForDrops());
        }

        @SafeVarargs
        public final BlockParameters<T> addTags(TagKey<Block>... tags){
            return addTags(Arrays.asList(tags));
        }
        public BlockParameters<T> addTags(List<TagKey<Block>> tags){
            this.tags.addAll(tags);
            return this;
        }
        public <U extends Block> BlockParameters<U> blockConstructor(Function<BlockBehaviour.Properties, U> blockConstructor){
            return new BlockParameters<>(properties, blockConstructor, this.tags);
        }
        public <U extends Block> BlockParameters<U> blockConstructor(Supplier<U> blockConstructor){
            return new BlockParameters<>(properties, p -> blockConstructor.get(), this.tags);
        }
        public BlockParameters<T> destroyTime(float destroyTime) {
            this.properties.destroyTime(destroyTime);
            return this;
        }

        public BlockParameters<T> explosionResistance(float explosionResistance) {
            this.properties.explosionResistance(explosionResistance);
            return this;
        }

        public BlockParameters<T> sound(SoundType soundType) {
            this.properties.sound(soundType);
            return this;
        }

        public BlockParameters<T> requiresCorrectToolForDrops() {
            this.properties.requiresCorrectToolForDrops();
            return this;
        }
    }
}

