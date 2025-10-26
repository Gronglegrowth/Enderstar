package EsetKalenko.Enderstar.Item.Tool;

import EsetKalenko.Enderstar.Enderstar;
import com.cmdpro.databank.interfaces.item.AdjustableAttributes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

import java.util.List;

public class Primer extends Item implements AdjustableAttributes {

    public Primer(Properties properties) {
        super(properties);
        this.craftingRemainingItem = this;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack is = player.getItemInHand(usedHand);

        return InteractionResultHolder.pass(is);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add( Component.translatable("item.enderstar.primer.tooltip").withColor(0x458a6b) );
    }

    @Override
    public void adjustAttributes(ItemAttributeModifierEvent event) {
        event.replaceModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(Enderstar.locate("primer_damage"), 1.0f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
        event.replaceModifier(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(Enderstar.locate("primer_knockback"), 0.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
    }
}
