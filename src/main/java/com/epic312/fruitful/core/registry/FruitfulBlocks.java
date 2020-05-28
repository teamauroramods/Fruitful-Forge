package com.epic312.fruitful.core.registry;

import com.epic312.fruitful.core.Fruitful;
import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsLeavesBlock;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulBlocks {
    public static final RegistryHelper HELPER = Fruitful.REGISTRY_HELPER;

    public static final RegistryObject<Block> APPLE_OAK_LEAVES = HELPER.createBlock("apple_oak_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
}
