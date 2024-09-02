package net.choollol.test_mod.datagen;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.registration.ModBlocks;
import net.choollol.test_mod.registration.ModBlocks.BlockModelType;
import net.choollol.test_mod.vessels.BlockVessel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TM.ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.BLOCK_MAP.forEach((resourceLocation, blockVessel) -> {
            BlockModelType modelType = blockVessel.getModelType();
            if (modelType == BlockModelType.CUBE_ALL){
                simpleBlockWithItem(blockVessel.asBlock(), cubeAll(blockVessel.asBlock()));
            }
            else if (modelType == BlockModelType.CUBE_COLUMN){
                cubeColumn(blockVessel);
            }
        });
    }
    private <T extends Block> void cubeColumn(BlockVessel<T> blockVessel){
        simpleBlockWithItem(blockVessel.asBlock(), models().cubeColumn(blockVessel.getId(),
                new ResourceLocation(TM.ID, ModelProvider.BLOCK_FOLDER + "/" +
                        blockVessel.getId() + "/" + blockVessel.getId() + "_side"),
                new ResourceLocation(TM.ID, ModelProvider.BLOCK_FOLDER + "/" +
                        blockVessel.getId() + "/" + blockVessel.getId() + "_end")));
    }
}
