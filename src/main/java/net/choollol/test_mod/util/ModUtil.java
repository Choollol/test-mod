package net.choollol.test_mod.util;

import net.choollol.test_mod.TM;
import net.minecraft.resources.ResourceLocation;

public class ModUtil {
    public static ResourceLocation pathFromId(String id){
        return new ResourceLocation(TM.ID, id);
    }

    public static void log(String message){
        TM.LOGGER.error(message);
    }
}
