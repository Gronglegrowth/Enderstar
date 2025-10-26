package EsetKalenko.Enderstar.Auxiliary.Datagen;

import EsetKalenko.Enderstar.Auxiliary.Datagen.Model.ResourceModels;
import EsetKalenko.Enderstar.Auxiliary.Datagen.Model.ToolModels;
import EsetKalenko.Enderstar.Enderstar;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Enderstar.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EnderstarDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ResourceModels(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ToolModels(packOutput, existingFileHelper));
    }
}
