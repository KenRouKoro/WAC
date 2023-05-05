package cn.korostudio.mc.wac.common.config;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class WACConfig {
    Map<String,WorldConfig> worldConfigs = new HashMap<>();
}
