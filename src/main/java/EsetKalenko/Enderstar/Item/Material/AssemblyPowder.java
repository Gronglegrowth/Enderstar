package EsetKalenko.Enderstar.Item.Material;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class AssemblyPowder extends Item {

    public AssemblyPowder(Properties properties) {
        super(properties);
    }
    // TODO when used on a block, tries to craft all inworld crafting recipes on items in the block space above it.

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();

        return InteractionResult.PASS;
    }
}
