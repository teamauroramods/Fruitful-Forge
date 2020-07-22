package com.epic312.fruitful.common.world.biome;

import com.epic312.fruitful.core.registry.FruitfulBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.*;

public class FruitfulBiomeFeatures {
    public static BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
    public static BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
    public static BlockState APPLE_OAK_LEAVES = FruitfulBlocks.APPLE_OAK_LEAVES.get().getDefaultState();

    public static BlockState BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState();
    public static BlockState BIRCH_LEAVES = Blocks.BIRCH_LEAVES.getDefaultState();
    public static BlockState PEACH_BIRCH_LEAVES = FruitfulBlocks.PEACH_BIRCH_LEAVES.get().getDefaultState();

    private static Random probeRand = new Random();
    private static BlockPos probePos = new BlockPos(0,0,0);

    private static final BeehiveTreeDecorator FruitfulBeehiveDecorator1 = new BeehiveTreeDecorator(0.002F);
    private static final BeehiveTreeDecorator FruitfulBeehiveDecorator2 = new BeehiveTreeDecorator(0.02F);
    private static final BeehiveTreeDecorator FruitfulBeehiveDecorator3 = new BeehiveTreeDecorator(0.05F);

    public static final BaseTreeFeatureConfig APPLE_OAK_TREE_CONFIG = (
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).addWeightedBlockstate(OAK_LEAVES,99).addWeightedBlockstate(APPLE_OAK_LEAVES,1),
                    new BlobFoliagePlacer(2, 0, 0, 0, 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
            .func_236700_a_().build();

    public static final BaseTreeFeatureConfig APPLE_OAK_TREE_CONFIG_1 = APPLE_OAK_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator1));
    public static final BaseTreeFeatureConfig APPLE_OAK_TREE_CONFIG_2 = APPLE_OAK_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator2));
    public static final BaseTreeFeatureConfig APPLE_OAK_TREE_WITH_MORE_BEEHIVES_CONFIG = APPLE_OAK_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator3));

    public static final BaseTreeFeatureConfig DENSE_APPLE_OAK_TREE_CONFIG = (
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).addWeightedBlockstate(OAK_LEAVES,8).addWeightedBlockstate(APPLE_OAK_LEAVES,2),
                    new BlobFoliagePlacer(2, 0, 0, 0, 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
            .func_236700_a_().build();

    public static final BaseTreeFeatureConfig APPLE_FANCY_TREE_CONFIG = (
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).addWeightedBlockstate(OAK_LEAVES,99).addWeightedBlockstate(APPLE_OAK_LEAVES,1),
                    new FancyFoliagePlacer(2, 0, 4, 0, 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
            .func_236700_a_().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();

    public static final BaseTreeFeatureConfig APPLE_FANCY_TREE_CONFIG_1 = APPLE_FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator1));
    public static final BaseTreeFeatureConfig APPLE_FANCY_TREE_CONFIG_2 = APPLE_FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator2));
    public static final BaseTreeFeatureConfig APPLE_FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = APPLE_FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator3));

    public static final BaseTreeFeatureConfig DENSE_APPLE_FANCY_TREE_CONFIG = (
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(OAK_LOG),
                    (new WeightedBlockStateProvider()).addWeightedBlockstate(OAK_LEAVES,8).addWeightedBlockstate(APPLE_OAK_LEAVES,2),
                    new FancyFoliagePlacer(2, 0, 4, 0, 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4))))
            .func_236700_a_().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();

    public static final BaseTreeFeatureConfig PEACH_BIRCH_TREE_CONFIG = (
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BIRCH_LOG),
                    (new WeightedBlockStateProvider()).addWeightedBlockstate(BIRCH_LEAVES,149).addWeightedBlockstate(PEACH_BIRCH_LEAVES,1),
                    new BlobFoliagePlacer(2, 0, 0, 0, 3),
                    new StraightTrunkPlacer(5, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
            .func_236700_a_().build();

    public static final BaseTreeFeatureConfig PEACH_BIRCH_TREE_CONFIG_1 = PEACH_BIRCH_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator1));
    public static final BaseTreeFeatureConfig PEACH_BIRCH_TREE_CONFIG_2 = PEACH_BIRCH_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator2));
    public static final BaseTreeFeatureConfig PEACH_BIRCH_TREE_WITH_MORE_BEEHIVES_CONFIG = PEACH_BIRCH_TREE_CONFIG.func_236685_a_(ImmutableList.of(FruitfulBeehiveDecorator3));

    public static final BaseTreeFeatureConfig TALL_PEACH_BIRCH_TREE_CONFIG = (
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BIRCH_LOG),
                    (new WeightedBlockStateProvider()).addWeightedBlockstate(BIRCH_LEAVES,149).addWeightedBlockstate(PEACH_BIRCH_LEAVES,1),
                    new BlobFoliagePlacer(2, 0, 0, 0, 3),
                    new StraightTrunkPlacer(5, 2, 6),
                    new TwoLayerFeature(1, 0, 1)))
            .func_236700_a_().func_236703_a_(ImmutableList.of(FruitfulBeehiveDecorator1)).build();

    public static final BaseTreeFeatureConfig DENSE_PEACH_BIRCH_TREE_CONFIG = (
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BIRCH_LOG),
                    (new WeightedBlockStateProvider()).addWeightedBlockstate(BIRCH_LEAVES,10).addWeightedBlockstate(PEACH_BIRCH_LEAVES,2),
                    new BlobFoliagePlacer(2, 0, 0, 0, 3),
                    new StraightTrunkPlacer(5, 2, 0),
                    new TwoLayerFeature(1, 0, 1)))
            .func_236700_a_().build();

    public static void addFruitTrees(Biome biome) {
        List<ConfiguredFeature<?, ?>> list = biome.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
        List<ConfiguredFeature<?, ?>> toRemove = new ArrayList<>();
        int listSize = list.size();
        if (biome == Biomes.BIRCH_FOREST) {
            int i2 = 1;
        }
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
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_OAK_TREE_CONFIG), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230132_o_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_OAK_TREE_CONFIG_1), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230133_p_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_OAK_TREE_CONFIG_2), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_OAK_TREE_WITH_MORE_BEEHIVES_CONFIG), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.FANCY_TREE_CONFIG) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_FANCY_TREE_CONFIG), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230131_m_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_FANCY_TREE_CONFIG_1), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230134_q_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_FANCY_TREE_CONFIG_2), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(APPLE_FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.BIRCH_TREE_CONFIG) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(PEACH_BIRCH_TREE_CONFIG), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230129_h_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(PEACH_BIRCH_TREE_CONFIG_1), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230135_r_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(PEACH_BIRCH_TREE_CONFIG_2), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230136_s_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(PEACH_BIRCH_TREE_WITH_MORE_BEEHIVES_CONFIG), crfl.chance));
                            } else if (crfl.feature.config == DefaultBiomeFeatures.field_230130_i_) {
                                tempFeatures.add(new ConfiguredRandomFeatureList<BaseTreeFeatureConfig>(Feature.field_236291_c_.withConfiguration(TALL_PEACH_BIRCH_TREE_CONFIG), crfl.chance));
                            } else {
                                tempFeatures.add(crfl);
                            }
                        } else {
                            tempFeatures.add(crfl);
                        }
                    }
                    if (tree.defaultFeature.feature instanceof TreeFeature) {
                        BaseTreeFeatureConfig tempDefCfg = (BaseTreeFeatureConfig) tree.defaultFeature.config;
                        //if (((BaseTreeFeatureConfig) tree.defaultFeature.config).leavesProvider.getBlockState(probeRand, probePos).getBlock() == Blocks.OAK_LEAVES) {
                        BaseTreeFeatureConfig treeCfg = (BaseTreeFeatureConfig) tree.defaultFeature.config;
                        if (treeCfg == DefaultBiomeFeatures.OAK_TREE_CONFIG) {
                            tempDefCfg = APPLE_OAK_TREE_CONFIG;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230132_o_) {
                            tempDefCfg = APPLE_OAK_TREE_CONFIG_1;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230133_p_) {
                            tempDefCfg = APPLE_OAK_TREE_CONFIG_2;
                        } else if (treeCfg == DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG) {
                            tempDefCfg = APPLE_OAK_TREE_WITH_MORE_BEEHIVES_CONFIG;
                        } else if (treeCfg == DefaultBiomeFeatures.FANCY_TREE_CONFIG) {
                            tempDefCfg = APPLE_FANCY_TREE_CONFIG;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230131_m_) {
                            tempDefCfg = APPLE_FANCY_TREE_CONFIG_1;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230134_q_) {
                            tempDefCfg = APPLE_FANCY_TREE_CONFIG_2;
                        } else if (treeCfg == DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG) {
                            tempDefCfg = APPLE_FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG;
                        } else if (treeCfg == DefaultBiomeFeatures.BIRCH_TREE_CONFIG) {
                            tempDefCfg = PEACH_BIRCH_TREE_CONFIG;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230129_h_) {
                            tempDefCfg = PEACH_BIRCH_TREE_CONFIG_1;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230135_r_) {
                            tempDefCfg = PEACH_BIRCH_TREE_CONFIG_2;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230136_s_) {
                            tempDefCfg = PEACH_BIRCH_TREE_WITH_MORE_BEEHIVES_CONFIG;
                        } else if (treeCfg == DefaultBiomeFeatures.field_230130_i_) {
                            tempDefCfg = TALL_PEACH_BIRCH_TREE_CONFIG;
                        }
                        ConfiguredFeature<?,?> tempDef = new ConfiguredFeature<BaseTreeFeatureConfig, Feature<BaseTreeFeatureConfig>>((Feature<BaseTreeFeatureConfig>) tree.defaultFeature.feature, tempDefCfg);
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
                } else if (decorated.feature.config instanceof BaseTreeFeatureConfig) {
                    BaseTreeFeatureConfig tempDefCfg = (BaseTreeFeatureConfig) decorated.feature.config;
                    BaseTreeFeatureConfig treeCfg = (BaseTreeFeatureConfig) decorated.feature.config;
                    if (treeCfg == DefaultBiomeFeatures.OAK_TREE_CONFIG) {
                        tempDefCfg = APPLE_OAK_TREE_CONFIG;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230132_o_) {
                        tempDefCfg = APPLE_OAK_TREE_CONFIG_1;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230133_p_) {
                        tempDefCfg = APPLE_OAK_TREE_CONFIG_2;
                    } else if (treeCfg == DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG) {
                        tempDefCfg = APPLE_OAK_TREE_WITH_MORE_BEEHIVES_CONFIG;
                    } else if (treeCfg == DefaultBiomeFeatures.FANCY_TREE_CONFIG) {
                        tempDefCfg = APPLE_FANCY_TREE_CONFIG;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230131_m_) {
                        tempDefCfg = APPLE_FANCY_TREE_CONFIG_1;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230134_q_) {
                        tempDefCfg = APPLE_FANCY_TREE_CONFIG_2;
                    } else if (treeCfg == DefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG) {
                        tempDefCfg = APPLE_FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG;
                    } else if (treeCfg == DefaultBiomeFeatures.BIRCH_TREE_CONFIG) {
                        tempDefCfg = PEACH_BIRCH_TREE_CONFIG;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230129_h_) {
                        tempDefCfg = PEACH_BIRCH_TREE_CONFIG_1;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230135_r_) {
                        tempDefCfg = PEACH_BIRCH_TREE_CONFIG_2;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230136_s_) {
                        tempDefCfg = PEACH_BIRCH_TREE_WITH_MORE_BEEHIVES_CONFIG;
                    } else if (treeCfg == DefaultBiomeFeatures.field_230130_i_) {
                        tempDefCfg = TALL_PEACH_BIRCH_TREE_CONFIG;
                    }
                    ConfiguredFeature<DecoratedFeatureConfig, ?> tempFeature = new ConfiguredFeature<DecoratedFeatureConfig, DecoratedFeature>(
                            (DecoratedFeature) configuredFeature.feature, new DecoratedFeatureConfig(
                                new ConfiguredFeature<BaseTreeFeatureConfig, Feature<BaseTreeFeatureConfig>>(
                                        (Feature<BaseTreeFeatureConfig>) decorated.feature.feature,
                                        tempDefCfg
                                ), decorated.decorator
                    ));
                    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, tempFeature);
                    toRemove.add(configuredFeature);
                }
            }
        }
        for (int i = 0; i < toRemove.size(); i++) {
            list.remove(toRemove.get(i));
        }
    }
}
