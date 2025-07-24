package EsetKalenko.Enderstar.Item.Material;

import EsetKalenko.Enderstar.Enderstar;
import EsetKalenko.Enderstar.Recipe.InWorldCraftingRecipe;
import EsetKalenko.Enderstar.Registry.EnderstarRecipes;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Optional;

public class AssemblyPowder extends Item {

    public AssemblyPowder(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        if (!context.getLevel().isClientSide() &&  attemptCraft(context)) {
            context.getItemInHand().shrink(1);
            context.getLevel().playSound(null, context.getClickedPos().above(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1.0f, 0.5f);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private boolean attemptCraft(UseOnContext context) {
        boolean craftedSomething = false;

        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        List<ItemEntity> ingredientStacks = context.getLevel().getEntitiesOfClass(ItemEntity.class, AABB.ofSize(pos.above().getCenter(), 1, 1, 1));

        for (ItemEntity stack : ingredientStacks) {
            var actualItem = stack.getItem();
            var in = new SingleRecipeInput(actualItem);
            Optional<RecipeHolder<InWorldCraftingRecipe>> holder = world.getRecipeManager().getRecipeFor(EnderstarRecipes.IN_WORLD_CRAFTING_TYPE.get(), in, world);

            if (holder.isPresent()) {
                var recipe = holder.get().value();
                var pattern = recipe.getBlockPattern();

                if (pattern.checkMultiblockAll(world, pos)) {
                    for (int i = 0; i < actualItem.getCount(); i++) {
                        var out = recipe.assemble(in, world.registryAccess());
                        actualItem.shrink(1);
                        world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.above().getY(), pos.getZ(), out));
                        craftedSomething = true;
                    }
                }
            }
        }

        return craftedSomething;
    }
}
