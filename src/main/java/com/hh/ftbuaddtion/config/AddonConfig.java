package com.hh.ftbuaddtion.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AddonConfig {
    public static final ForgeConfigSpec SERVER_SPEC;
    public static final ServerConfig SERVER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        SERVER = new ServerConfig(builder);
        SERVER_SPEC = builder.build();
    }

    public static class ServerConfig {
        public final ForgeConfigSpec.IntValue dropMode;

        ServerConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("FTB Ultimine 掉落模式设置").push("ftbuaddtion");

            dropMode = builder
                    .comment("掉落模式: 0=默认(在原方块位置掉落), 1=掉落在玩家位置, 2=直接放入玩家背包")
                    .defineInRange("dropMode", 0, 0, 2);

            builder.pop();
        }
    }
}