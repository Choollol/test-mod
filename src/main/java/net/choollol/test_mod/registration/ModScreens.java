package net.choollol.test_mod.registration;

import net.choollol.test_mod.screens.TestBarrelScreen;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class ModScreens {
    @SubscribeEvent
    private static void registerScreens(RegisterMenuScreensEvent event){
        event.register(ModMenuTypes.TEST_BARREL_MENU.get(), TestBarrelScreen::new);
    }
}
