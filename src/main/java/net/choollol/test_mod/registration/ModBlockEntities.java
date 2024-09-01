package net.choollol.test_mod.registration;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.blocks.blockentities.TestBarrelEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, TM.ID);

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TestBarrelEntity>> TEST_BARREL_BE =
            BLOCK_ENTITIES.register("test_barrel",
                    () -> BlockEntityType.Builder.of(TestBarrelEntity::new, ModBlocks.TEST_BLOCK_1.asBlock()).build(null));
}
