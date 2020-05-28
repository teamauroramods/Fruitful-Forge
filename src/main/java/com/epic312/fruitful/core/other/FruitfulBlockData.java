package com.epic312.fruitful.core.other;

import com.epic312.fruitful.core.registry.FruitfulBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class FruitfulBlockData {
    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(FruitfulBlocks.APPLE_OAK_LEAVES.get(), RenderType.getCutoutMipped());
    }
}
