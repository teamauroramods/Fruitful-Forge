package com.epic312.fruitful.core.other;

import com.epic312.fruitful.core.registry.FruitfulBlocks;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;

import java.util.Arrays;

public class FruitfulBlockData {
    public static void registerCompostables() {
        DataUtils.registerCompostable(0.95f, FruitfulBlocks.APPLE_OAK_LEAVES.get());
    }

    public static void registerFlammables() {
        DataUtils.registerFlammable(FruitfulBlocks.APPLE_OAK_LEAVES.get(), 30, 60);
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_LEAVES.get(), RenderType.getCutoutMipped());
    }

    public static void registerBlockColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        DataUtils.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DataUtils.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));
    }
}
