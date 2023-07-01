package cn.korostudio.mc.wac.common.config;

import cn.korostudio.ctoml.OutputAnnotation;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@OutputAnnotation("WAC配置文件")
public class WACConfig {
    Map<String,WorldConfig> worldConfigs = new HashMap<>();
}
