package cn.korostudio.mc.wac.wacignite.mixin;

import net.minecraft.core.Holder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Holder.Reference.class)
public class MixinReference<T> {
    @Shadow
    private T value;
    @Inject(method = "bindValue",at = @At("HEAD"),cancellable = true)
    private void canBind(T p_249418_, CallbackInfo ci){
        value = p_249418_;
        ci.cancel();
    }
}
