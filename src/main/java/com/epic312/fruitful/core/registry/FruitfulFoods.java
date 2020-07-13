package com.epic312.fruitful.core.registry;

import com.epic312.fruitful.core.Fruitful;
import net.minecraft.item.Food;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulFoods {
    public static Food APPLE_PIE = new Food.Builder().hunger(10).saturation(0.2F).build();
}
