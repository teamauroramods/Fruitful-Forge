package com.teamaurora.fruitful.core.other;

import com.teamaurora.fruitful.core.Fruitful;
import com.teamaurora.fruitful.core.registry.FruitfulEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID)
public class FruitfulEvents {

    @SubscribeEvent
    public static void livingEntityUseItemFinish(LivingEntityUseItemEvent.Finish event) {
        ItemStack item = event.getItem();

        LivingEntity entity = event.getEntityLiving();

        // NOURISHING //
        if (entity.isPotionActive(FruitfulEffects.NOURISHING.get())) {
            int amplifier = entity.getActivePotionEffect(FruitfulEffects.NOURISHING.get()).getAmplifier();
            if (item.isFood()) {
                int foodToAdd = 2 * (amplifier + 1);
                if (entity instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) entity;
                    player.getFoodStats().addStats(foodToAdd, 0);
                }
            }
        }

        // APPLES GIVE NOURISHING //
        if (item.getItem() == Items.APPLE) {
            if (entity.isPotionActive(FruitfulEffects.NOURISHING.get())) {
                int ticksRemaining = entity.getActivePotionEffect(FruitfulEffects.NOURISHING.get()).getDuration();
                entity.addPotionEffect(new EffectInstance(FruitfulEffects.NOURISHING.get(), Math.max(120, ticksRemaining), 0, false, false, true));
            } else {
                entity.addPotionEffect(new EffectInstance(FruitfulEffects.NOURISHING.get(), 120, 0, false, false, true));
            }
        }
    }
}
