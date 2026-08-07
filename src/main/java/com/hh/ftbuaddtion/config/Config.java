package com.hh.ftbuaddtion.config;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Set;

public class Config {
    public static final ForgeConfigSpec SPEC;
    public static final CommonConfig COMMON;

    public static boolean logDirtBlock;
    public static String magicNumberIntroduction;
    public static int magicNumber;
    public static Set<Item> items;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }



    public static class CommonConfig {
        //public final ForgeConfigSpec.BooleanValue logDirtBlock;
        //public final ForgeConfigSpec.ConfigValue<String> magicNumberIntroduction;
        //public final ForgeConfigSpec.IntValue magicNumber;
        //public final ForgeConfigSpec.ConfigValue<List<? extends String>> items;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            //logDirtBlock = builder.comment("是否在日志中输出泥土方块信息").define("logDirtBlock", true);
            //magicNumberIntroduction = builder.comment("魔法数字介绍").define("magicNumberIntroduction", "The magic number is ");
            //magicNumber = builder.comment("魔法数字").defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
            //items = builder.comment("物品列表").defineList("items", new ArrayList<>(), o -> o instanceof String);
            builder.pop();
        }
    }
}