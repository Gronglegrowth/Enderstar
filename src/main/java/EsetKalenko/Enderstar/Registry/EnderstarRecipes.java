package EsetKalenko.Enderstar.Registry;

import EsetKalenko.Enderstar.Enderstar;
import EsetKalenko.Enderstar.Recipe.InWorldCraftingRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EnderstarRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTRAR = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Enderstar.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPE_REGISTRAR = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, Enderstar.MODID);

    public static final Supplier<RecipeType<InWorldCraftingRecipe>> IN_WORLD_CRAFTING_TYPE = registerType("in_world_crafting");
    public static final Supplier<RecipeSerializer<InWorldCraftingRecipe>> IN_WORLD_CRAFTING = registerSerializer("in_world_crafting", () -> InWorldCraftingRecipe.Serializer.INSTANCE);

    private static <T extends RecipeSerializer<?>> Supplier<T> registerSerializer(final String name, final Supplier<T> recipe) {
        return SERIALIZER_REGISTRAR.register(name, recipe);
    }

    static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> registerType(final String id) {
        return TYPE_REGISTRAR.register(id, () -> new RecipeType<T>() {
            public String toString() {
                return id;
            }
        });
    }
}
