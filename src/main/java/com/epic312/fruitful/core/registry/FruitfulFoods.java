package com.epic312.fruitful.core.registry;

import com.epic312.fruitful.core.Fruitful;
import net.minecraft.item.Food;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulFoods {
    public static final Food APPLE_PIE = new Food.Builder().hunger(10).saturation(0.2F).build();

    public static final Food PEACH = (new Food.Builder()).hunger(3).saturation(0.4F).build();
    public static final Food PEACH_COBBLER = (new Food.Builder()).hunger(9).saturation(0.3F).build();
}
