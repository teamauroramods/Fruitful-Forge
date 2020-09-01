package com.teamaurora.fruitful.core.registry;

import com.teamaurora.fruitful.common.world.biome.FruitfulBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class FruitfulFeatures {

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.getValues().forEach(FruitfulFeatures::generate);
    }

    public static void generate(Biome biome) {
        FruitfulBiomeFeatures.addFruitTrees(biome);
    }
}
