package cn.korostudio.mc.wac.wacfabric.mixin;

import cn.korostudio.mc.wac.common.WAC;
import cn.korostudio.mc.wac.common.config.WorldConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(Level.class)
public abstract class MixinLevel {
    @Final
    @Shadow
    @Mutable
    private Holder<DimensionType> dimensionTypeRegistration;

    //OptionalLong fixedTime, boolean hasSkyLight, boolean hasCeiling, boolean ultraWarm, boolean natural, double coordinateScale, boolean bedWorks, boolean respawnAnchorWorks, int minY, int height, int logicalHeight, TagKey<Block> infiniburn, ResourceLocation effectsLocation, float ambientLight, DimensionType.MonsterSettings monsterSettings
    @Inject(method = "<init>",at = @At("TAIL"))
    private void getLevelData(WritableLevelData writableLevelData, ResourceKey resourceKey, RegistryAccess registryAccess, Holder holder, Supplier supplier, boolean bl, boolean bl2, long l, int i, CallbackInfo ci) throws Throwable {
        if(((Level)(Object)this).isClientSide()){
            return;
        }
        String id = resourceKey.location().toString();
        WorldConfig config = WAC.getInstance(id);
        DimensionType dimensionType1 = dimensionTypeRegistration.value();
        DimensionType newDimensionType = new DimensionType(dimensionType1.fixedTime(),dimensionType1.hasSkyLight(),dimensionType1.hasCeiling(),dimensionType1.ultraWarm(),dimensionType1.natural(),dimensionType1.coordinateScale(),dimensionType1.bedWorks(),dimensionType1.respawnAnchorWorks(),config.getMin_y(),config.getHeight(),config.getLogical_height(),dimensionType1.infiniburn(),dimensionType1.effectsLocation(),dimensionType1.ambientLight(),dimensionType1.monsterSettings());
        ((Holder.Reference<DimensionType>)dimensionTypeRegistration).bindValue(newDimensionType);
        //accessible method net/minecraft/core/Holder$Reference bindValue (Ljava/lang/Object;)V
    }

}
