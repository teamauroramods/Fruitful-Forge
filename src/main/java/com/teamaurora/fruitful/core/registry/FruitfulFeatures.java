package com.teamaurora.fruitful.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.fruitful.core.Fruitful;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.fml.common.Mod;

import java.util.OptionalInt;

@Mod.EventBusSubscriber(modid = Fruitful.MODID)
public class FruitfulFeatures {
    public static final class BlockStates {
        public static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
        public static final BlockState FLOWERING_OAK_LEAVES = FruitfulBlocks.FLOWERING_OAK_LEAVES.get().getDefaultState();
        public static final BlockState BUDDING_OAK_LEAVES = FruitfulBlocks.BUDDING_OAK_LEAVES.get().getDefaultState();
    }

    public static final class Configs {
        public static final BaseTreeFeatureConfig FLOWERING_OAK = (new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.OAK_LOG),
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.BUDDING_OAK_LEAVES, 2).addWeightedBlockstate(BlockStates.FLOWERING_OAK_LEAVES, 1),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                new StraightTrunkPlacer(4, 2, 0),
                new TwoLayerFeature(1, 0, 1))
        ).setIgnoreVines().build();
        public static final BaseTreeFeatureConfig FLOWERING_FANCY_OAK = (new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.OAK_LOG),
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.BUDDING_OAK_LEAVES, 2).addWeightedBlockstate(BlockStates.FLOWERING_OAK_LEAVES, 1),
                new FancyFoliagePlacer(FeatureSpread.func_242252_a(2),
                FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0),
                new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
        ).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();
    }

    public static final class Configured {
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_OAK = Feature.TREE.withConfiguration(Configs.FLOWERING_OAK);
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_FANCY_OAK = Feature.TREE.withConfiguration(Configs.FLOWERING_FANCY_OAK);
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_OAK_BEES_005 = Feature.TREE.withConfiguration(Configs.FLOWERING_OAK.func_236685_a_(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT)));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_FANCY_OAK_BEES_005 = Feature.TREE.withConfiguration(Configs.FLOWERING_FANCY_OAK.func_236685_a_(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT)));


        private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Fruitful.MODID, name), configuredFeature);
        }

        public static void registerConfiguredFeatures() {
            register("flowering_oak", FLOWERING_OAK);
            register("flowering_fancy_oak", FLOWERING_FANCY_OAK);
            register("flowering_oak_bees_005", FLOWERING_OAK_BEES_005);
            register("flowering_fancy_oak_bees_005", FLOWERING_FANCY_OAK_BEES_005);
        }
    }
}
