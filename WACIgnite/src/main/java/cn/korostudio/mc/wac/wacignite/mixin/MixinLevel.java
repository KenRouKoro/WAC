package cn.korostudio.mc.wac.wacignite.mixin;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.korostudio.mc.wac.common.WAC;
import cn.korostudio.mc.wac.common.config.WACConfig;
import cn.korostudio.mc.wac.common.config.WorldConfig;
import cn.korostudio.mc.wac.wacignite.WACIgnite;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import org.bukkit.World;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Supplier;

@Mixin(Level.class)
public abstract class MixinLevel {
    @Final
    @Shadow
    @Mutable
    private Holder<DimensionType> dimensionTypeRegistration;

    //OptionalLong fixedTime, boolean hasSkyLight, boolean hasCeiling, boolean ultraWarm, boolean natural, double coordinateScale, boolean bedWorks, boolean respawnAnchorWorks, int minY, int height, int logicalHeight, TagKey<Block> infiniburn, ResourceLocation effectsLocation, float ambientLight, DimensionType.MonsterSettings monsterSettings
    @Inject(method = "<init>",at = @At("TAIL"))
    @SuppressWarnings("all")
    private void getLevelData(WritableLevelData worlddatamutable, ResourceKey resourcekey, Holder holder, Supplier supplier, boolean flag, boolean flag1, long i, int j, ChunkGenerator gen, BiomeProvider biomeProvider, World.Environment env, Function paperWorldConfigCreator, Executor executor, CallbackInfo ci) throws Throwable {
        if(((Level)(Object)this).isClientSide()){
            return;
        }
        String id = resourcekey.location().toString();
        WorldConfig config = WAC.getInstance(id);
        DimensionType dimensionType1 = dimensionTypeRegistration.value();
        DimensionType newDimensionType = new DimensionType(dimensionType1.fixedTime(),dimensionType1.hasSkyLight(),dimensionType1.hasCeiling(),dimensionType1.ultraWarm(),dimensionType1.natural(),dimensionType1.coordinateScale(),dimensionType1.bedWorks(),dimensionType1.respawnAnchorWorks(),config.getMin_y(),config.getHeight(),config.getLogical_height(),dimensionType1.infiniburn(),dimensionType1.effectsLocation(),dimensionType1.ambientLight(),dimensionType1.monsterSettings());
        //((Holder.Reference<DimensionType>)dimensionTypeRegistration).bindValue(newDimensionType);
        Method[] methods = ReflectUtil.getMethods(Holder.Reference.class);
        Class<?> objClass = Object.class;
        for(Method method:methods){
          if(method.getName().equals("b")&&(method.getParameterTypes().length!=0)&& ArrayUtil.contains(method.getParameterTypes(),objClass)){
            WACIgnite.getLogger().info("正在注入世界对象:{}",id);
            method.setAccessible(true);
            method.invoke(dimensionTypeRegistration,newDimensionType);
          }
        }

        //ReflectUtil.invoke(dimensionTypeRegistration, "method_45918", newDimensionType);
        //method_45918
        //accessible method net/minecraft/core/Holder$Reference bindValue (Ljava/lang/Object;)V
    }

}
