package com.teamaurora.fruitful.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class FruitfulConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> fruitTreesNoPodzol;
        public final ForgeConfigSpec.ConfigValue<Boolean> whitelist;
        public final ForgeConfigSpec.ConfigValue<ArrayList<String>> appleBiomes;
        public final ForgeConfigSpec.ConfigValue<ArrayList<String>> peachBiomes;
        public final ForgeConfigSpec.ConfigValue<ArrayList<String>> orangeBiomes;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configurations for Fruitful").push("common");

            fruitTreesNoPodzol = builder.define("Whether fruit trees should grow without podzol", false);

            builder.comment("Biome lists for fruit tree spawning").push("biome_lists");

            ArrayList<String> defaultAppleBiomes = new ArrayList<String>();
            defaultAppleBiomes.add("minecraft:forest");
            defaultAppleBiomes.add("minecraft:wooded_hills");
            defaultAppleBiomes.add("minecraft:flower_forest");
            ArrayList<String> defaultPeachBiomes = new ArrayList<String>();
            defaultPeachBiomes.add("minecraft:birch_forest");
            defaultPeachBiomes.add("minecraft:birch_forest_hills");
            defaultPeachBiomes.add("minecraft:tall_birch_forest");
            defaultPeachBiomes.add("minecraft:tall_birch_hills");
            ArrayList<String> defaultOrangeBiomes = new ArrayList<String>();
            defaultOrangeBiomes.add("minecraft:jungle");
            defaultOrangeBiomes.add("minecraft:jungle_hills");
            defaultOrangeBiomes.add("minecraft:modified_jungle");
            defaultOrangeBiomes.add("minecraft:jungle_edge");
            defaultOrangeBiomes.add("minecraft:modified_jungle_edge");
            defaultOrangeBiomes.add("minecraft:bamboo_jungle");
            defaultOrangeBiomes.add("minecraft:bamboo_jungle_hills");

            whitelist = builder.define("Whether the lists below are a blacklist or whitelist", true);
            appleBiomes = builder.define("Biomes apples can spawn/not spawn in", defaultAppleBiomes);
            peachBiomes = builder.define("Biomes peaches can spawn/not spawn in", defaultPeachBiomes);
            orangeBiomes = builder.define("Biomes oranges can spawn/not spawn in", defaultOrangeBiomes);

            builder.pop();
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
