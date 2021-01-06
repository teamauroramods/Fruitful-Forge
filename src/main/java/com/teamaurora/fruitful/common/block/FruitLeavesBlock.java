package com.teamaurora.fruitful.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.AbnormalsLeavesBlock;
import com.teamaurora.fruitful.core.registry.FruitfulBlocks;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.function.Supplier;

public class FruitLeavesBlock extends AbnormalsLeavesBlock {
    private final LeavesBlock leavesBlock;
    private final Supplier<Item> fruitItem;

    public FruitLeavesBlock(Properties properties, LeavesBlock leaves, Supplier<Item> fruit) {
        super(properties);
        leavesBlock = leaves;
        fruitItem = fruit;
    }

    @SuppressWarnings("deprecation")
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        spawnAsEntity(worldIn, pos, new ItemStack(fruitItem.get(), 1));
        worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
        worldIn.setBlockState(pos, leavesBlock.getDefaultState().with(LeavesBlock.PERSISTENT, state.get(LeavesBlock.PERSISTENT)).with(LeavesBlock.DISTANCE, state.get(LeavesBlock.DISTANCE)), 2);
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    /**
     * Performs a random tick on a block.
     */
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.getMoonFactor() <= 0.5 && !state.get(LeavesBlock.PERSISTENT)) {
            spawnAsEntity(worldIn, pos, new ItemStack(fruitItem.get(), 1));
            worldIn.setBlockState(pos, FruitfulBlocks.BUDDING_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.PERSISTENT, false));
        }

        super.randomTick(state, worldIn, pos, random);
    }
}
