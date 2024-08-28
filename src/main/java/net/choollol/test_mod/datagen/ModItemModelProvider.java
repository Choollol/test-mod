package net.choollol.test_mod.datagen;

import net.choollol.test_mod.items.ModItems;
import net.choollol.test_mod.TM;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TM.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var itemVessel : ModItems.ITEM_MAP.values()){
            ModItems.ModelType modelType = itemVessel.getModelType();
            if (modelType == ModItems.ModelType.SIMPLE) {
                simpleItem(itemVessel.getPath(), "layer0");
            }
            else if (modelType == ModItems.ModelType.HANDHELD){
                itemHandheld(itemVessel.getPath(), "layer0");
            }
        }
    }
    private ItemModelBuilder simpleItem(String path, String layer){
        return withExistingParent(path,
                new ResourceLocation("item/generated")).texture(
                        layer, new ResourceLocation(TM.ID, "item/" + path)
        );
    }
    private ItemModelBuilder itemHandheld(String path, String layer){
        return withExistingParent(path,
                new ResourceLocation("item/handheld")).texture(
                layer, new ResourceLocation(TM.ID, "item/" + path)
        );
    }
}
