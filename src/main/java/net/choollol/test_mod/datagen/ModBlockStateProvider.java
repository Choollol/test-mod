package net.choollol.test_mod.datagen;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.TMBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TM.ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }
    private void blockWithItem(Block block){
        simpleBlockWithItem(block, cubeAll(block));
    }

}
