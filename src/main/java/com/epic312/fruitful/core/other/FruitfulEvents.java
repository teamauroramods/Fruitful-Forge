package com.epic312.fruitful.core.other;

import com.epic312.fruitful.core.registry.FruitfulBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.ILightReader;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FruitfulEvents {
    @SubscribeEvent
    public void colorHandler (final ColorHandlerEvent.Block event) {
        event.getBlockColors().register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
            return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getFoliageColor(p_228061_1_, p_228061_2_) : FoliageColors.getDefault();
        }, FruitfulBlocks.APPLE_OAK_LEAVES.get());
    }

    @SubscribeEvent
    public void itemColorHandler (final ColorHandlerEvent.Item event) {
        final java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Item>, IItemColor> colors = new java.util.HashMap<>();
        event.getItemColors().register((p_210235_1_, p_210235_2_) -> {
            return FoliageColors.getDefault();
        }, FruitfulBlocks.APPLE_OAK_LEAVES.get());
    }
}
