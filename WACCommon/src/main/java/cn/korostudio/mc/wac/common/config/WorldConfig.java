package cn.korostudio.mc.wac.common.config;

import cn.korostudio.ctoml.OutputAnnotation;
import lombok.Data;

@Data
@OutputAnnotation("世界配置文件")
public class WorldConfig {
    @OutputAnnotation("世界ID，使用MJ格式")
    String id = "";
    @OutputAnnotation("世界高度，调整该值可以修改建筑高度，必须在16和4064之间，并且是16的倍数，最大高度=最小y+高度-1，且不能超过2031")
    int height = 1024;
    @OutputAnnotation("世界最低高度。必须在-2032和2031之间，并且是16的倍数")
    int min_y = -64;
    @OutputAnnotation("世界逻辑高度，紫颂果和地狱门能把玩家传送到这个维度的最大高度，不能大于height。")
    int logical_height = 256;

}
