package EsetKalenko.Enderstar.Auxiliary.Mixin;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeModeInventoryScreen.class)
public class CreativeModeInventoryScreenMixin {

    @Inject(method = "renderLabels", at = @At(value = "HEAD"), cancellable = true)
    protected void changeEnderstarCreativeTabTitles(GuiGraphics guiGraphics, int mouseX, int mouseY, CallbackInfo ci) {

    }
}
