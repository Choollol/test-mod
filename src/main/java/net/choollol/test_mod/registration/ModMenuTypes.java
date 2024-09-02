package net.choollol.test_mod.registration;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.menus.ModMenu;
import net.choollol.test_mod.menus.TestBarrelMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, TM.ID);

    public static final Supplier<MenuType<TestBarrelMenu>> TEST_BARREL_MENU =
            registerMenuType("test_barrel_menu", TestBarrelMenu::new);

    private static <T extends ModMenu> Supplier<MenuType<T>> registerMenuType(String id,
                                                                              MenuType.MenuSupplier<T> constructor, FeatureFlagSet featureFlags){
        return MENUS.register(id, () -> new MenuType<>(constructor, featureFlags));
    }
    private static <T extends ModMenu> Supplier<MenuType<T>> registerMenuType(String id,
                                                                              MenuType.MenuSupplier<T> constructor){
        return registerMenuType(id, constructor, FeatureFlags.DEFAULT_FLAGS);
    }
}
