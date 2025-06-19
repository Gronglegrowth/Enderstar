package EsetKalenko.Enderstar;

import EsetKalenko.Enderstar.Registry.EnderstarBlocks;
import EsetKalenko.Enderstar.Registry.EnderstarRecipes;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Enderstar.MODID)
public class Enderstar {
    public static final String MODID = "enderstar";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void logInfo(String message) {
        LOGGER.info("[ENDERSTAR] " + message);
    }
    public static void logWarn(String message) {
        LOGGER.warn("[ENDERSTAR] " + message);
    }
    public static void logError(String message) {
        LOGGER.error("[ENDERSTAR ERROR] " + message);
    }

    public Enderstar(IEventBus modEventBus, ModContainer modContainer)
    {
        logInfo("The legend of the Enderstar lives on....");
        EnderstarBlocks.REGISTRAR.register(modEventBus);
        EnderstarRecipes.SERIALIZER_REGISTRAR.register(modEventBus);
        EnderstarRecipes.TYPE_REGISTRAR.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, EnderstarConfig.SPEC);
    }
}
