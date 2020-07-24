package com.epic312.fruitful.core.registry;

import com.epic312.fruitful.common.world.biome.FruitfulBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class FruitfulFeatures {

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.getValues().forEach(FruitfulFeatures::generate);
    }

    public static void generate(Biome biome) {
        if (!biome.getRegistryName().getNamespace().equals("biomesoplenty")) {
            FruitfulBiomeFeatures.addFruitTrees(biome);
        }
    }
}
