package com.dragn0007.deepblue.util.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeepBlueCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> GREATWHITE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAKO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> BLUEWHALE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> WHALESHARK_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> BELUGA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> LIONMANEJELLY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> COELACANTH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> HAMMERHEAD_WEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> KRILLSWARM_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHRIMPSWARM_WEIGHT;



    static {
        BUILDER.push("Configs for Deep Blue!");


        GREATWHITE_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 1.")
                .define("Great White Shark Spawn Weight", 1);

        MAKO_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 3.")
                .define("Mako Shark Spawn Weight", 3);

        BLUEWHALE_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 1.")
                .define("Blue Whale Spawn Weight", 1);

        WHALESHARK_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 1.")
                .define("Whale Shark Spawn Weight", 1);

        BELUGA_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 4.")
                .define("Beluga Whale Spawn Weight", 4);

        LIONMANEJELLY_WEIGHT = BUILDER.comment("How often should this creature? Default is 8.")
                .define("Lion's Mane Jellyfish Spawn Weight", 8);

        COELACANTH_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 3.")
                .define("Coelacanth Spawn Weight", 3);

        HAMMERHEAD_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 2.")
                .define("Hammerhead Shark Spawn Weight", 2);


        KRILLSWARM_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 3.")
                .define("Krill Spawn Weight", 3);

        SHRIMPSWARM_WEIGHT = BUILDER.comment("How often should this creature spawn? Default is 3.")
                .define("Shrimp Spawn Weight", 3);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
