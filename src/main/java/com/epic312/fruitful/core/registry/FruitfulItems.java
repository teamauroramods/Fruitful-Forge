package com.epic312.fruitful.core.registry;

import com.epic312.fruitful.core.Fruitful;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulItems {
    public static final RegistryHelper HELPER = Fruitful.REGISTRY_HELPER;

    public static final RegistryObject<Item> APPLE_PIE = HELPER.createItem("apple_pie", ()->new Item(new Item.Properties().food(FruitfulFoods.APPLE_PIE).group(ItemGroup.FOOD)));
}
