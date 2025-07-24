package EsetKalenko.Enderstar.Recipe;

import EsetKalenko.Enderstar.Registry.EnderstarRecipes;
import com.cmdpro.databank.multiblock.Multiblock;
import com.cmdpro.databank.multiblock.MultiblockManager;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class InWorldCraftingRecipe implements Recipe<RecipeInput> {
    private final Ingredient input;
    private final ResourceLocation blockPattern;
    private final ItemStack result;

    public InWorldCraftingRecipe(Ingredient input, ResourceLocation blockPattern, ItemStack result) {
        this.input = input;
        this.blockPattern = blockPattern;
        this.result = result;
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return input.test(recipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(input);
        return list;
    }

    public Multiblock getBlockPattern() {
        return MultiblockManager.multiblocks.get(blockPattern);
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return EnderstarRecipes.IN_WORLD_CRAFTING_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<InWorldCraftingRecipe> {

        public static final MapCodec<InWorldCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(r -> r.input),
                ResourceLocation.CODEC.fieldOf("block_pattern").forGetter((r) -> r.blockPattern),
                ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result)
        ).apply(instance, InWorldCraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, InWorldCraftingRecipe> STREAM_CODEC = StreamCodec.of(
                (buf, obj) -> {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, obj.input);
                    ResourceLocation.STREAM_CODEC.encode(buf, obj.blockPattern);
                    ItemStack.STREAM_CODEC.encode(buf, obj.result);
                },
                (buf) -> {
                    Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
                    ResourceLocation blockPattern = ResourceLocation.STREAM_CODEC.decode(buf);
                    ItemStack result = ItemStack.STREAM_CODEC.decode(buf);
                    return new InWorldCraftingRecipe(input, blockPattern, result);
                }
        );

        public static final Serializer INSTANCE = new Serializer();

        @Override
        public MapCodec<InWorldCraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, InWorldCraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
