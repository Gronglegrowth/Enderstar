package EsetKalenko.Enderstar.Registry;

import EsetKalenko.Enderstar.Enderstar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EnderstarCreativeTabs {
    public static final ResourceLocation CREATIVE_BACKGROUND = Enderstar.locate("textures/gui/creative_tab.png");

    public static void register(IEventBus bus) {
        var registrar = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Enderstar.MODID);

        registrar.register("machines", () -> MACHINES);
        registrar.register("materials", () -> MATERIALS);
        registrar.register("tools", () -> TOOLS);
        registrar.register(bus);

        Enderstar.logInfo("Registered Enderstar's creative tabs.");
    }

    public static final CreativeModeTab MATERIALS = CreativeModeTab.builder()
            .icon(EnderstarItems.ELEMENTAL_CONDENSATE::toStack)
            .title(Component.translatable("itemGroup.enderstar.materials"))
            .backgroundTexture(CREATIVE_BACKGROUND)
            .displayItems((displayContext, entries) -> {
                entries.accept(EnderstarItems.AIR_CONDENSATE.get());
                entries.accept(EnderstarItems.EARTH_CONDENSATE.get());
                entries.accept(EnderstarItems.FIRE_CONDENSATE.get());
                entries.accept(EnderstarItems.WATER_CONDENSATE.get());
                entries.accept(EnderstarItems.ELEMENTAL_CONDENSATE.get());
                entries.accept(EnderstarItems.ASSEMBLY_POWDER.get());
            })
            .build();

    public static final CreativeModeTab TOOLS = CreativeModeTab.builder()
            .icon(EnderstarItems.SOUL_STONE::toStack)
            .title(Component.translatable("itemGroup.enderstar.tools"))
            .backgroundTexture(CREATIVE_BACKGROUND)
            .displayItems((displayContext, entries) -> {
                entries.accept(EnderstarItems.PRIMER.get());
                entries.accept(EnderstarItems.SOUL_STONE.get());
                entries.accept(EnderstarItems.BOUND_GEM.get());
            })
            .build();

    public static final CreativeModeTab MACHINES = CreativeModeTab.builder()
            .icon(EnderstarItems.SOUL_STONE::toStack)
            .title(Component.translatable("itemGroup.enderstar.machines"))
            .backgroundTexture(CREATIVE_BACKGROUND)
            .displayItems((displayContext, entries) -> {
                entries.accept(EnderstarItems.BOUND_GEM.get());
            })
            .build();
}
