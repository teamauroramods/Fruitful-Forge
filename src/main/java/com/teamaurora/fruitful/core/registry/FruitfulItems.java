package com.teamaurora.fruitful.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.fruitful.core.Fruitful;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulItems {
    public static final ItemSubRegistryHelper HELPER = Fruitful.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> BAKED_APPLE = HELPER.createItem("baked_apple", ()->new Item(new Item.Properties().food(Foods.BAKED_APPLE).group(ItemGroup.FOOD)));

    public static class Foods {
        public static final Food BAKED_APPLE = new Food.Builder().hunger(6).saturation(0.4F).build();
    }
}
