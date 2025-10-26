package EsetKalenko.Enderstar.Item.Tool;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SoulStone extends Item {

    public SoulStone(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        tooltipComponents.add( Component.translatable("item.enderstar.soul_stone.tooltip1").withColor(0x458a6b) );
        tooltipComponents.add( Component.translatable("item.enderstar.soul_stone.tooltip2").withColor(0x458a6b) );
    }
}
