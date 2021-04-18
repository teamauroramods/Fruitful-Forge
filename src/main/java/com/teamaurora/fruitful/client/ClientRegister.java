package com.teamaurora.fruitful.client;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.fruitful.core.Fruitful;
import com.teamaurora.fruitful.core.registry.FruitfulBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            registerBlockColors();
            setupRenderLayer();
        });
    }

    public static void registerBlockColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(
                FruitfulBlocks.BUDDING_OAK_LEAVES,
                FruitfulBlocks.FLOWERING_OAK_LEAVES,
                FruitfulBlocks.BLOSSOMING_OAK_LEAVES,
                FruitfulBlocks.APPLE_OAK_LEAVES,
                FruitfulBlocks.BUDDING_OAK_LEAF_CARPET,
                FruitfulBlocks.FLOWERING_OAK_LEAF_CARPET,
                FruitfulBlocks.BLOSSOMING_OAK_LEAF_CARPET,
                FruitfulBlocks.APPLE_OAK_LEAF_CARPET,
                FruitfulBlocks.BUDDING_OAK_HEDGE,
                FruitfulBlocks.FLOWERING_OAK_HEDGE,
                FruitfulBlocks.BLOSSOMING_OAK_HEDGE,
                FruitfulBlocks.APPLE_OAK_HEDGE
        ));

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(
                FruitfulBlocks.BUDDING_OAK_LEAVES,
                FruitfulBlocks.FLOWERING_OAK_LEAVES,
                FruitfulBlocks.BLOSSOMING_OAK_LEAVES,
                FruitfulBlocks.APPLE_OAK_LEAVES,
                FruitfulBlocks.BUDDING_OAK_LEAF_CARPET,
                FruitfulBlocks.FLOWERING_OAK_LEAF_CARPET,
                FruitfulBlocks.BLOSSOMING_OAK_LEAF_CARPET,
                FruitfulBlocks.APPLE_OAK_LEAF_CARPET,
                FruitfulBlocks.BUDDING_OAK_HEDGE,
                FruitfulBlocks.FLOWERING_OAK_HEDGE,
                FruitfulBlocks.BLOSSOMING_OAK_HEDGE,
                FruitfulBlocks.APPLE_OAK_HEDGE
        ));
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.FLOWERING_OAK_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BUDDING_OAK_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BLOSSOMING_OAK_LEAVES.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.FLOWERING_OAK_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BUDDING_OAK_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BLOSSOMING_OAK_LEAF_CARPET.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_HEDGE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.FLOWERING_OAK_HEDGE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BUDDING_OAK_HEDGE.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.BLOSSOMING_OAK_HEDGE.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(FruitfulBlocks.FLOWERING_OAK_SAPLING.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.POTTED_FLOWERING_OAK_SAPLING.get(), RenderType.getCutoutMipped());
    }
}
