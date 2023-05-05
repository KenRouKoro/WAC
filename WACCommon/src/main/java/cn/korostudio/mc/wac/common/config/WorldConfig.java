package cn.korostudio.mc.wac.common.config;

import lombok.Data;

@Data
public class WorldConfig {
    String id = "";
    int height = 1024;
    int min_y = -64;
    int logical_height = 256;

}
