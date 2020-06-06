package com.epic312.fruitful.common.world.biome;

import com.epic312.fruitful.core.registry.FruitfulBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

import java.util.ArrayList;
import java.util.List;

public class FruitfulBiomeFeatures {
    public static BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
    public static BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
    public static BlockState APPLE_OAK_LEAVES = FruitfulBlocks.APPLE_OAK_LEAVES.get().getDefaultState();

    public static final TreeFeatureConfig APPLE_OAK_TREE_CONFIG = (
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).func_227407_a_(OAK_LEAVES,199).func_227407_a_(APPLE_OAK_LEAVES,1),
                    new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) Blocks.OAK_SAPLING)
            .build();

    public static final TreeFeatureConfig APPLE_OAK_TREE_WITH_MORE_BEEHIVES_CONFIG = (
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).func_227407_a_(OAK_LEAVES,199).func_227407_a_(APPLE_OAK_LEAVES,1),
                    new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING)
            .build();

    public static final TreeFeatureConfig DENSE_APPLE_OAK_TREE_CONFIG = (
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).func_227407_a_(OAK_LEAVES,1).func_227407_a_(APPLE_OAK_LEAVES,19),
                    new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) Blocks.OAK_SAPLING)
            .build();

    public static final TreeFeatureConfig APPLE_FANCY_TREE_CONFIG = (
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).func_227407_a_(OAK_LEAVES,199).func_227407_a_(APPLE_OAK_LEAVES,1),
                    new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING)
            .build();

    public static final TreeFeatureConfig DENSE_APPLE_FANCY_TREE_CONFIG = (
            new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).func_227407_a_(OAK_LEAVES,1).func_227407_a_(APPLE_OAK_LEAVES,19),
                    new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING)
            .build();

    public static void addFruitTrees(Biome biome) {
        List<ConfiguredFeature<?, ?>> list = biome.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
        List<ConfiguredFeature<?, ?>> toRemove = new ArrayList<>();
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            ConfiguredFeature<?, ?> configuredFeature = list.get(i);
            if (configuredFeature.config instanceof DecoratedFeatureConfig) {
                DecoratedFeatureConfig decorated = (DecoratedFeatureConfig) configuredFeature.config;
                if (decorated.feature.config instanceof MultipleRandomFeatureConfig) {
                    MultipleRandomFeatureConfig tree = (MultipleRandomFeatureConfig) decorated.feature.config;
                    List<ConfiguredRandomFeatureList<?>> tempFeatures = new ArrayList<>();
                    for (ConfiguredRandomFeatureList crfl : tree.features) {
                        if (crfl.feature.feature instanceof TreeFeature) {
                            if (crfl.feature.config == DefaultBiomeFeatures.OAK_TREE_CONFIG) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<TreeFeatureConfig>(Feature.NORMAL_TREE.withConfiguration(APPLE_OAK_TREE_CONFIG), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<TreeFeatureConfig>(Feature.NORMAL_TREE.withConfiguration(APPLE_OAK_TREE_WITH_MORE_BEEHIVES_CONFIG), crfl.chance));
                            }
                        } else {
                            tempFeatures.add(crfl);
                        }
                    }
                    if (tree.defaultFeature.feature instanceof TreeFeature) {
                        TreeFeatureConfig tempDefCfg = (TreeFeatureConfig) tree.defaultFeature.config;
                        if (((TreeFeatureConfig) tree.defaultFeature.config).getSapling() == Blocks.OAK_SAPLING) {
                            tempDefCfg = APPLE_OAK_TREE_CONFIG;
                        }
                        ConfiguredFeature<?,?> tempDef = new ConfiguredFeature<TreeFeatureConfig, Feature<TreeFeatureConfig>>((Feature<TreeFeatureConfig>) tree.defaultFeature.feature, tempDefCfg);
                        ConfiguredFeature<DecoratedFeatureConfig, ?> tempFeature = new ConfiguredFeature<DecoratedFeatureConfig, DecoratedFeature>(
                                (DecoratedFeature) configuredFeature.feature, new DecoratedFeatureConfig(
                                        new ConfiguredFeature<MultipleRandomFeatureConfig, Feature<MultipleRandomFeatureConfig>>((Feature<MultipleRandomFeatureConfig>) decorated.feature.feature,
                                            new MultipleRandomFeatureConfig(tempFeatures, tempDef)
                                        ), decorated.decorator
                        ));
                        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, tempFeature);
                    } else {
                        ConfiguredFeature<DecoratedFeatureConfig, ?> tempFeature = new ConfiguredFeature<DecoratedFeatureConfig, DecoratedFeature>(
                                (DecoratedFeature) configuredFeature.feature, new DecoratedFeatureConfig(
                                    new ConfiguredFeature<MultipleRandomFeatureConfig, Feature<MultipleRandomFeatureConfig>>((Feature<MultipleRandomFeatureConfig>) decorated.feature.feature,
                                            new MultipleRandomFeatureConfig(tempFeatures, tree.defaultFeature)
                                    ), decorated.decorator
                        ));
                        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, tempFeature);
                    }
                    toRemove.add(configuredFeature);
                }
            }
        }
        for (int i = 0; i < toRemove.size(); i++) {
            list.remove(toRemove.get(i));
        }
    }
}
