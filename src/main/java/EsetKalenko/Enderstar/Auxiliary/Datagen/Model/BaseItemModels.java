package EsetKalenko.Enderstar.Auxiliary.Datagen.Model;

import EsetKalenko.Enderstar.Enderstar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class BaseItemModels extends ItemModelProvider {

    public BaseItemModels(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    protected ItemModelBuilder simpleItem(Supplier<Item> item) {
        return withExistingParent(BuiltInRegistries.ITEM.getKey(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Enderstar.MODID,"item/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath()));
    }

    @Override
    protected void registerModels() {

    }
}
