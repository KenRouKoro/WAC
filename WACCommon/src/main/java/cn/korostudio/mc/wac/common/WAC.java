package cn.korostudio.mc.wac.common;

import cn.korostudio.mc.hutoolcore.common.config.ConfigUtil;
import cn.korostudio.mc.wac.common.config.WACConfig;
import cn.korostudio.mc.wac.common.config.WorldConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WAC {
    @Getter
    private static WACConfig config ;

    public static void init(){
        try {
            Class<?> hutoolcoreClass = Class.forName("cn.korostudio.mc.hutoolcore.common.HutoolCore");
        } catch (ClassNotFoundException e) {
            log.error("警告，未检测到HutoolCore！",e);
        }
        config = ConfigUtil.getInstance("WACConfig",WACConfig.class);
    }

    public static WorldConfig getInstance(String id){
        if (config.getWorldConfigs().get(id)!=null){
            log.info("读取世界配置：{}",id);
            return config.getWorldConfigs().get(id);
        }else{
            log.info("发现新世界生成，ID：{} 正在为其生成默认配置文件",id);
            WorldConfig worldConfig = new WorldConfig();
            worldConfig.setId(id);
            config.getWorldConfigs().put(id,worldConfig);
            ConfigUtil.save("WACConfig");
            log.info("配置文件如下：{} 可在{}中编辑配置文件，当前版本需要重启生效",worldConfig,System.getProperty("user.dir")+"/config/WACConfig.json");
            return worldConfig;
        }
    }

}
