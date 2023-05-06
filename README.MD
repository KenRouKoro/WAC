# WAC World Altitude Control 世界高度控制
> 这个mod不能解决高度不能超过mc数据结构限制的问题，因为这会摧毁兼容性！    

这个Mod用于控制Minecraft维度高度，可在配置文件或在HutoolCore的Web编辑器中进行配置。

它的原理是Minecraft在创建ServerLevel（ServerWorld）时修改ServerLevel（ServerWorld）的高度配置。  

以下为对参数的解释：
|参数|注释|
|-------|-------|
|id|世界ID|
|logical_height|玩家使用紫颂果或下界传送门可以到达的总高度。不会影响超过该限制高度的既有传送门。取值为0到4064的闭区间，且不能大于 height。|
|min_y|该维度中可以存在方块的最低高度。数值必须在-2032至2031之间且为16的整数倍（也就是说，-2032是最小有效值，2016是最大有效值）。|
|height|该维度中可以存在方块的总高度。数值必须在16至4064之间且为16的整数倍。维度中可以存在方块的最大高度值为min_y与height值之和减去1，不能超过2031。|

原版与使用HutoolCoreWebConfig的配置文件样式：
```json
{
    "worldConfigs": {
        "minecraft:overworld": {
            "id": "minecraft:overworld",
            "height": 1024,
            "min_y": -64,
            "logical_height": 256
        },
        "minecraft:the_nether": {
            "id": "minecraft:the_nether",
            "height": 1024,
            "min_y": -64,
            "logical_height": 256
        },
        "minecraft:the_end": {
            "id": "minecraft:the_end",
            "height": 1024,
            "min_y": -64,
            "logical_height": 256
        }
    }
}
```
![屏幕截图 2023-05-06 173638.png](%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-05-06%20173638.png)