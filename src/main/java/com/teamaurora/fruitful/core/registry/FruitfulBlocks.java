package com.teamaurora.fruitful.core.registry;

import com.teamaurora.fruitful.common.block.FruitLeafBlock;
import com.teamaurora.fruitful.core.Fruitful;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulBlocks {
    public static final RegistryHelper HELPER = Fruitful.REGISTRY_HELPER;

    public static final RegistryObject<Block> APPLE_OAK_LEAVES = HELPER.createBlock("apple_oak_leaves", ()->new FruitLeafBlock(Block.Properties.from(Blocks.OAK_LEAVES).notSolid().harvestTool(ToolType.HOE), (LeavesBlock)Blocks.OAK_LEAVES, ()->Items.APPLE), ItemGroup.DECORATIONS);
    }
