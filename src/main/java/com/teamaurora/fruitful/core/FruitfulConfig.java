package com.teamaurora.fruitful.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class FruitfulConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> whitelist;
        public final ForgeConfigSpec.ConfigValue<ArrayList<String>> flowerBiomes;
        public final ForgeConfigSpec.ConfigValue<ArrayList<String>> fullFlowerBiomes;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configurations for Fruitful").push("common");

            ArrayList<String> defaultFlowerBiomes = new ArrayList<String>();
            defaultFlowerBiomes.add("minecraft:forest");
            defaultFlowerBiomes.add("minecraft:wooded_hills");

            ArrayList<String> defaultFullFlowerBiomes = new ArrayList<String>();
            defaultFullFlowerBiomes.add("minecraft:flower_forest");

            whitelist = builder.define("Whether the lists below are a blacklist or whitelist", true);
            flowerBiomes = builder.define("Biomes flowering oak trees can spawn in", defaultFlowerBiomes);
            fullFlowerBiomes = builder.define("Biomes where all oaks will be flowering", defaultFullFlowerBiomes);

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
