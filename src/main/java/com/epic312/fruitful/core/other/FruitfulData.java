package com.epic312.fruitful.core.other;

import com.epic312.fruitful.core.registry.FruitfulBlocks;
import com.epic312.fruitful.core.registry.FruitfulItems;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;

import java.util.Arrays;

public class FruitfulData {
    public static void registerCompostables() {
        DataUtils.registerCompostable(0.95f, FruitfulBlocks.APPLE_OAK_LEAVES.get());
        DataUtils.registerCompostable(0.95f, FruitfulBlocks.PEACH_BIRCH_LEAVES.get());
        DataUtils.registerCompostable(0.95f, FruitfulBlocks.ORANGE_JUNGLE_LEAVES.get());

        DataUtils.registerCompostable(0.65f, FruitfulItems.PEACH.get());
        DataUtils.registerCompostable(0.65f, FruitfulItems.ORANGE.get());

        DataUtils.registerCompostable(1f, FruitfulBlocks.PEACH_CRATE.get());
        DataUtils.registerCompostable(1f, FruitfulBlocks.ORANGE_CRATE.get());

        DataUtils.registerCompostable(1f, FruitfulItems.APPLE_PIE.get());
    }

    public static void registerFlammables() {
        DataUtils.registerFlammable(FruitfulBlocks.APPLE_OAK_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(FruitfulBlocks.PEACH_BIRCH_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(FruitfulBlocks.ORANGE_JUNGLE_LEAVES.get(), 30, 60);
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.PEACH_BIRCH_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.ORANGE_JUNGLE_LEAVES.get(), RenderType.getCutoutMipped());
    }

    public static void registerBlockColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        DataUtils.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));
        DataUtils.registerBlockColor(blockColors, (x, world, pos, u) -> FoliageColors.getBirch(), Arrays.asList(FruitfulBlocks.PEACH_BIRCH_LEAVES));
        DataUtils.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.ORANGE_JUNGLE_LEAVES));

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DataUtils.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));
        DataUtils.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getBirch(), Arrays.asList(FruitfulBlocks.PEACH_BIRCH_LEAVES));
        DataUtils.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.ORANGE_JUNGLE_LEAVES));
    }
}
