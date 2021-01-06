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
    }

    public static void registerFlammables() {
        DataUtil.registerFlammable(FruitfulBlocks.APPLE_OAK_LEAVES.get(), 30, 60);
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_LEAVES.get(), RenderType.getCutoutMipped());
    }

    public static void registerBlockColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(FruitfulBlocks.APPLE_OAK_LEAVES));
    }
}
