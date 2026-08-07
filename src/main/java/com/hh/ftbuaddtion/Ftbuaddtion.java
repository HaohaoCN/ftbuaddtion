package com.hh.ftbuaddtion;

import com.hh.ftbuaddtion.config.AddonConfig;
import com.hh.ftbuaddtion.config.Config;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Ftbuaddtion.MODID)
public class Ftbuaddtion {
    public static final String MODID = "ftbuaddtion";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Ftbuaddtion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        // 注册配置文件
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, AddonConfig.SERVER_SPEC);
    }
}