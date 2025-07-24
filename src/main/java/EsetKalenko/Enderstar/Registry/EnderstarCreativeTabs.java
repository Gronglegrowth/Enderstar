package EsetKalenko.Enderstar.Registry;

import EsetKalenko.Enderstar.Enderstar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EnderstarCreativeTabs {

    public static void register(IEventBus bus) {
        var registrar = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Enderstar.MODID);

        registrar.register("materials", () -> MATERIALS);
        registrar.register(bus);

        Enderstar.logInfo("Registered Enderstar's creative tabs.");
    }

    public static final CreativeModeTab MATERIALS = CreativeModeTab.builder()
            .icon(EnderstarItems.ELEMENTAL_CONDENSATE::toStack)
            .title(Component.translatable("itemGroup.enderstar.materials"))
            .displayItems((displayContext, entries) -> {
                entries.accept(EnderstarItems.AIR_CONDENSATE.get());
                entries.accept(EnderstarItems.EARTH_CONDENSATE.get());
                entries.accept(EnderstarItems.FIRE_CONDENSATE.get());
                entries.accept(EnderstarItems.WATER_CONDENSATE.get());
                entries.accept(EnderstarItems.ELEMENTAL_CONDENSATE.get());
                entries.accept(EnderstarItems.ASSEMBLY_POWDER.get());
            })
            .build();
}
