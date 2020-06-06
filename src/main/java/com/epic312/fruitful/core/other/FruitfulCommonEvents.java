package com.epic312.fruitful.core.other;

import com.epic312.fruitful.common.world.biome.FruitfulBiomeFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class FruitfulCommonEvents {
    @SubscribeEvent
    public void saplingGrowTreeEvent (SaplingGrowTreeEvent event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld world = (ServerWorld) event.getWorld();
            BlockPos pos = event.getPos();
            BlockState state = world.getBlockState(pos);
            Random rand = event.getRand();
            if (state.getBlock() == Blocks.OAK_SAPLING) {
                event.setResult(Event.Result.DENY);
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
                ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature;
                configuredFeature = (rand.nextInt(10) == 0 ? Feature.FANCY_TREE.withConfiguration(FruitfulBiomeFeatures.DENSE_APPLE_FANCY_TREE_CONFIG) : Feature.NORMAL_TREE.withConfiguration(FruitfulBiomeFeatures.DENSE_APPLE_OAK_TREE_CONFIG));
                if (!configuredFeature.place(world, world.getChunkProvider().getChunkGenerator(), rand, pos)) {
                    world.setBlockState(pos, state);
                }
            }
        }
    }
}
