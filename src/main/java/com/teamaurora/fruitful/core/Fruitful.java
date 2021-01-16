package com.teamaurora.fruitful.core;

import com.teamaurora.fruitful.core.other.FruitfulData;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.fruitful.core.registry.FruitfulEffects;
import com.teamaurora.fruitful.core.registry.FruitfulFeatures;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("fruitful")
@Mod.EventBusSubscriber(modid = "fruitful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Fruitful
{
    public static final String MODID = "fruitful";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Fruitful() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(eventBus);

        FruitfulEffects.EFFECTS.register(eventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(EventPriority.LOWEST, this::clientSetup);
        });
        eventBus.addListener(EventPriority.LOWEST, this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FruitfulConfig.COMMON_SPEC);
    }

    public static ResourceLocation resLoc(String path) {
        return new ResourceLocation(MODID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(FruitfulData::registerCommon);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            FruitfulFeatures.Configured.registerConfiguredFeatures();
            FruitfulData.registerBlockColors();
            FruitfulData.setupRenderLayer();
        });
    }
}
