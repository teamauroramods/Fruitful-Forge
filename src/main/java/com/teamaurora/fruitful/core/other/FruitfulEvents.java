package com.teamaurora.fruitful.core.other;

import com.teamaurora.fruitful.common.world.biome.FruitfulBiomeFeatures;
import com.teamaurora.fruitful.core.FruitfulConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class FruitfulEvents {
    @SubscribeEvent
    public void saplingGrowTreeEvent (SaplingGrowTreeEvent event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld world = (ServerWorld) event.getWorld();
            BlockPos pos = event.getPos();
            BlockState state = world.getBlockState(pos);
            Random rand = event.getRand();
            if (world.getBlockState(pos.down()).getBlock() == Blocks.PODZOL || FruitfulConfig.COMMON.fruitTreesNoPodzol.get()) {
                if (state.getBlock() == Blocks.OAK_SAPLING) {
                    event.setResult(Event.Result.DENY);
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredFeature;
                    if (world.getBlockState(pos.down()).getBlock() == Blocks.PODZOL) {
                        // field_236291_c_ = TREE, currently unmapped
                        configuredFeature = (rand.nextInt(10) == 0 ? Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.DENSE_APPLE_FANCY_TREE_CONFIG) : Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.DENSE_APPLE_OAK_TREE_CONFIG));
                    } else {
                        configuredFeature = (rand.nextInt(10) == 0 ? Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.APPLE_FANCY_TREE_CONFIG) : Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.APPLE_OAK_TREE_CONFIG));
                    }
                    // func_236265_a_ = place, currently unmapped
                    if (!configuredFeature.func_236265_a_(world, world.func_241112_a_(), world.getChunkProvider().getChunkGenerator(), rand, pos)) {
                        world.setBlockState(pos, state);
                    }
                } else if (state.getBlock() == Blocks.BIRCH_SAPLING) {
                    event.setResult(Event.Result.DENY);
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredFeature;
                    if (world.getBlockState(pos.down()).getBlock() == Blocks.PODZOL) {
                        // field_236291_c_ = TREE, currently unmapped
                        configuredFeature = Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.DENSE_PEACH_BIRCH_TREE_CONFIG);
                    } else {
                        configuredFeature = Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.PEACH_BIRCH_TREE_CONFIG);
                    }
                    // func_236265_a_ = place, currently unmapped
                    if (!configuredFeature.func_236265_a_(world, world.func_241112_a_(), world.getChunkProvider().getChunkGenerator(), rand, pos)) {
                        world.setBlockState(pos, state);
                    }
                } else if (state.getBlock() == Blocks.JUNGLE_SAPLING) {
                    if (
                            !(world.getBlockState(pos.north()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.east()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.north().east()).getBlock() == Blocks.JUNGLE_SAPLING) &&
                                    !(world.getBlockState(pos.north()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.west()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.north().west()).getBlock() == Blocks.JUNGLE_SAPLING) &&
                                    !(world.getBlockState(pos.south()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.east()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.south().east()).getBlock() == Blocks.JUNGLE_SAPLING) &&
                                    !(world.getBlockState(pos.south()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.west()).getBlock() == Blocks.JUNGLE_SAPLING && world.getBlockState(pos.south().west()).getBlock() == Blocks.JUNGLE_SAPLING)
                    ) { // structure for large tree does not exist
                        event.setResult(Event.Result.DENY);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());
                        ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredFeature;
                        if (world.getBlockState(pos.down()).getBlock() == Blocks.PODZOL) {
                            // field_236291_c_ = TREE, currently unmapped
                            configuredFeature = Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.DENSE_ORANGE_JUNGLE_TREE_CONFIG);
                        } else {
                            configuredFeature = Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.ORANGE_JUNGLE_SAPLING_TREE_CONFIG);
                        }
                        // func_236265_a_ = place, currently unmapped
                        if (!configuredFeature.func_236265_a_(world, world.func_241112_a_(), world.getChunkProvider().getChunkGenerator(), rand, pos)) {
                            world.setBlockState(pos, state);
                        }
                    }
                } else if (state.getBlock().getRegistryName().equals(new ResourceLocation("hanami:sakura_sapling"))) {
                    event.setResult(Event.Result.DENY);
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    ConfiguredFeature<BaseTreeFeatureConfig, ?> configuredFeature;
                    if (world.getBlockState(pos.down()).getBlock() == Blocks.PODZOL) {
                        // field_236291_c_ = TREE, currently unmapped
                        configuredFeature = Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.DENSE_PEACH_BIRCH_TREE_CONFIG);
                    } else {
                        configuredFeature = Feature.field_236291_c_.withConfiguration(FruitfulBiomeFeatures.PEACH_BIRCH_TREE_CONFIG);
                    }
                    // func_236265_a_ = place, currently unmapped
                    if (!configuredFeature.func_236265_a_(world, world.func_241112_a_(), world.getChunkProvider().getChunkGenerator(), rand, pos)) {
                        world.setBlockState(pos, state);
                    }
                }
            }
        }
    }
}
