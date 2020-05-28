package com.epic312.fruitful.core.other;

import com.epic312.fruitful.core.registry.FruitfulBlocks;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

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
}
