package com.dragn0007.deepblue.util.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeepBlueClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Deep Blue!");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
