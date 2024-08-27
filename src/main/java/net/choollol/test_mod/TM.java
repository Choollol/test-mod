package net.choollol.test_mod;

import com.mojang.logging.LogUtils;
import net.choollol.test_mod.datagen.DataGenerators;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(TM.ID)
public class TM {
    public static final String ID = "test_mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TM(IEventBus modEventBus, ModContainer modContainer){
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        NeoForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event){
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event){

    }
    @SubscribeEvent
    public void onServerStart(ServerStartingEvent event){

    }
    @Mod.EventBusSubscriber(modid = ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
