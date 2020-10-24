package com.teamaurora.fruitful.core.compatibility;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ObjectHolder;

public class Hanami {
    @ObjectHolder("hanami:sakura_tree")
    public static final Feature<BaseTreeFeatureConfig> SAKURA_TREE = null;
    @ObjectHolder("hanami:sakura_tree_with_fallen_leaves")
    public static final Feature<BaseTreeFeatureConfig> SAKURA_TREE_WITH_FALLEN_LEAVES = null;

    @ObjectHolder("hanami:sakura_log")
    public static final Block SAKURA_LOG_BLOCK = null;
    @ObjectHolder("hanami:sakura_leaves")
    public static final Block SAKURA_LEAVES_BLOCK = null;
    @ObjectHolder("hanami:cherry_sakura_leaves")
    public static final Block CHERRY_SAKURA_LEAVES_BLOCK = null;

    public static boolean isInstalled()
    {
        return ModList.get() != null && ModList.get().getModContainerById("hanami").isPresent();
    }
}
