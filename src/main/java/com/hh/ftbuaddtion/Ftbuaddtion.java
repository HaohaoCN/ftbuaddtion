package com.hh.ftbuaddtion;

import com.hh.ftbuaddtion.config.AddonConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Ftbuaddtion.MODID)
public class Ftbuaddtion {
    public static final String MODID = "ftbuaddtion";

    public Ftbuaddtion() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, AddonConfig.SERVER_SPEC);
    }
}
