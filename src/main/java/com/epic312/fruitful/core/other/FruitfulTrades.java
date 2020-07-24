package com.epic312.fruitful.core.other;

import com.epic312.fruitful.core.Fruitful;
import com.epic312.fruitful.core.registry.FruitfulItems;
import com.teamabnormals.abnormals_core.core.utils.TradeUtils;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID)
public class FruitfulTrades {
    @SubscribeEvent
    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            event.getTrades().get(2).add(new TradeUtils.ItemsForEmeraldsTrade(FruitfulItems.PEACH.get(), 1, 3, 16, 5));
            event.getTrades().get(2).add(new TradeUtils.ItemsForEmeraldsTrade(FruitfulItems.ORANGE.get(), 1, 4, 16, 5));
        }
    }
}
