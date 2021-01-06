package com.teamaurora.fruitful.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class FruitfulConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> whitelist;
        public final ForgeConfigSpec.ConfigValue<ArrayList<String>> appleBiomes;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configurations for Fruitful").push("common");

            ArrayList<String> defaultAppleBiomes = new ArrayList<String>();
            defaultAppleBiomes.add("minecraft:forest");
            defaultAppleBiomes.add("minecraft:wooded_hills");
            defaultAppleBiomes.add("minecraft:flower_forest");

            whitelist = builder.define("Whether the lists below are a blacklist or whitelist", true);
            appleBiomes = builder.define("Biomes apples can spawn/not spawn in", defaultAppleBiomes);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
