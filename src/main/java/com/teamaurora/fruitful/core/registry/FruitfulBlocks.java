package com.teamaurora.fruitful.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.AbnormalsLeavesBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.wood.AbnormalsSaplingBlock;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.teamaurora.fruitful.common.block.FruitLeavesBlock;
import com.teamaurora.fruitful.common.block.OakBlossomBlock;
import com.teamaurora.fruitful.common.block.OakFlowerLeavesBlock;
import com.teamaurora.fruitful.common.block.trees.FloweringOakTree;
import com.teamaurora.fruitful.core.Fruitful;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fruitful.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class FruitfulBlocks {
    public static final BlockSubRegistryHelper HELPER = Fruitful.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> FLOWERING_OAK_LEAVES = HELPER.createBlock("flowering_oak_leaves", ()->new OakFlowerLeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES).notSolid().harvestTool(ToolType.HOE).tickRandomly()), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_OAK_LEAVES = HELPER.createBlock("budding_oak_leaves", ()->new OakFlowerLeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES).notSolid().harvestTool(ToolType.HOE).tickRandomly()), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLOSSOMING_OAK_LEAVES = HELPER.createBlock("blossoming_oak_leaves", ()->new OakBlossomBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES).notSolid().harvestTool(ToolType.HOE).tickRandomly()), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> APPLE_OAK_LEAVES = HELPER.createBlock("apple_oak_leaves", ()->new FruitLeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES).notSolid().harvestTool(ToolType.HOE).tickRandomly(), (LeavesBlock)BUDDING_OAK_LEAVES.get(), ()->Items.APPLE), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> FLOWERING_OAK_SAPLING = HELPER.createBlock("flowering_oak_sapling", ()->new AbnormalsSaplingBlock(new FloweringOakTree(), Block.Properties.create(Material.PLANTS, MaterialColor.GREEN).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)), ItemGroup.DECORATIONS);

}
