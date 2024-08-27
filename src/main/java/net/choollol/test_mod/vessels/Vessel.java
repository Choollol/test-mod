package net.choollol.test_mod.vessels;

import net.choollol.test_mod.util.ModUtil;
import net.minecraft.resources.ResourceLocation;

public class Vessel {
    protected String name;
    protected ResourceLocation id;

    protected Vessel(String name, String id){
        this.name = name;
        this.id = ModUtil.idFromPath(id);
    }

    public String getName() {return name;}
    public ResourceLocation getId() {return id;}
    public String getPath() {return id.toString().split(":")[1];}
}
