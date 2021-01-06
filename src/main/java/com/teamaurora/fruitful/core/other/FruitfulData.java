package com.teamaurora.fruitful.core.other;

import com.teamaurora.fruitful.core.registry.FruitfulBlocks;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
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
        DataUtil.registerCompostable(FruitfulBlocks.APPLE_OAK_LEAVES.get(), 0.95f);
        DataUtil.registerCompostable(FruitfulBlocks.FLOWERING_OAK_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(FruitfulBlocks.BUDDING_OAK_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(FruitfulBlocks.BLOSSOMING_OAK_LEAVES.get(), 0.3f);

        DataUtil.registerCompostable(FruitfulBlocks.FLOWERING_OAK_SAPLING.get(), 0.3f);
    }

    public static void registerFlammables() {
        DataUtil.registerFlammable(FruitfulBlocks.APPLE_OAK_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(FruitfulBlocks.FLOWERING_OAK_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(FruitfulBlocks.BUDDING_OAK_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(FruitfulBlocks.BLOSSOMING_OAK_LEAVES.get(), 30, 60);
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.FLOWERING_OAK_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BUDDING_OAK_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BLOSSOMING_OAK_LEAVES.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(FruitfulBlocks.FLOWERING_OAK_SAPLING.get(), RenderType.getCutoutMipped());
    }

    public static void registerBlockColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.FLOWERING_OAK_LEAVES));
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.BUDDING_OAK_LEAVES));

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.FLOWERING_OAK_LEAVES));
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.BUDDING_OAK_LEAVES));
    }
}
