package cn.korostudio.mc.wac.wacfabric;

import cn.korostudio.mc.wac.common.WAC;
import net.fabricmc.api.ModInitializer;

public class WACFabric implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        WAC.init();
    }
}
