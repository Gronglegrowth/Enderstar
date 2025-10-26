package EsetKalenko.Enderstar.Auxiliary.Datagen.Model;

import EsetKalenko.Enderstar.Enderstar;
import EsetKalenko.Enderstar.Registry.EnderstarItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class ToolModels extends BaseItemModels {

    public ToolModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Enderstar.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(EnderstarItems.PRIMER);
        simpleItem(EnderstarItems.SOUL_STONE);
        simpleItem(EnderstarItems.BOUND_GEM);
    }
}
