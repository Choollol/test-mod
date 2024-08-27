package net.choollol.test_mod.util;

import net.choollol.test_mod.TM;
import net.minecraft.resources.ResourceLocation;

public class ModUtil {
    public static ResourceLocation idFromPath(String path){
        return new ResourceLocation(TM.ID, path);
    }
}
