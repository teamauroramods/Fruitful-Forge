package com.epic312.fruitful.core.registry;

import com.epic312.fruitful.common.block.FruitLeafBlock;
import com.epic312.fruitful.core.Fruitful;
import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsLeavesBlock;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulBlocks {
    public static final RegistryHelper HELPER = Fruitful.REGISTRY_HELPER;

    public static final RegistryObject<Block> APPLE_OAK_LEAVES = HELPER.createBlock("apple_oak_leaves", ()->new FruitLeafBlock(Block.Properties.from(Blocks.OAK_LEAVES).notSolid().harvestTool(ToolType.HOE), (LeavesBlock)Blocks.OAK_LEAVES, ()->Items.APPLE), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PEACH_BIRCH_LEAVES = HELPER.createBlock("peach_birch_leaves", ()->new FruitLeafBlock(Block.Properties.from(Blocks.BIRCH_LEAVES).notSolid().harvestTool(ToolType.HOE), (LeavesBlock)Blocks.BIRCH_LEAVES, ()->FruitfulItems.PEACH.get()), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> ORANGE_JUNGLE_LEAVES = HELPER.createBlock("orange_jungle_leaves", ()->new FruitLeafBlock(Block.Properties.from(Blocks.JUNGLE_LEAVES).notSolid().harvestTool(ToolType.HOE), (LeavesBlock)Blocks.JUNGLE_LEAVES, ()->FruitfulItems.ORANGE.get()), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> PEACH_CRATE = HELPER.createCompatBlock("quark", "peach_crate", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(1.5F).sound(SoundType.WOOD)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> ORANGE_CRATE = HELPER.createCompatBlock("quark", "orange_crate", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).hardnessAndResistance(1.5F).sound(SoundType.WOOD)), ItemGroup.DECORATIONS);
}
