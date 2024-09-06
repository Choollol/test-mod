package net.choollol.test_mod.vessels;

import net.choollol.test_mod.util.ModUtil;
import net.minecraft.resources.ResourceLocation;

public class Vessel {
    protected String name;
    protected ResourceLocation path;

    protected Vessel(String name, String path){
        this.name = name;
        this.path = ModUtil.pathFromId(path);
    }

    public String getName() {return name;}
    public ResourceLocation getPath() {return path;}
    public String getId() {return path.toString().split(":")[1];}
}
