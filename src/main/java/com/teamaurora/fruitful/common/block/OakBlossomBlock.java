package com.teamaurora.fruitful.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.AbnormalsLeavesBlock;
import com.teamaurora.fruitful.core.registry.FruitfulBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class OakBlossomBlock extends AbnormalsLeavesBlock {
    public static final BooleanProperty POLLINATED = BooleanProperty.create("pollinated");

    public OakBlossomBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)).with(POLLINATED, Boolean.valueOf(false)));
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
        if (worldIn.getMoonFactor() <= 0.75 && !state.get(LeavesBlock.PERSISTENT)) {
            if (state.get(POLLINATED)) {
                worldIn.setBlockState(pos, FruitfulBlocks.APPLE_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.PERSISTENT, false).with(LeavesBlock.DISTANCE, state.get(LeavesBlock.DISTANCE)));
            } else if (random.nextInt(3) == 0) {
                worldIn.setBlockState(pos, FruitfulBlocks.FLOWERING_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.PERSISTENT, false).with(LeavesBlock.DISTANCE, state.get(LeavesBlock.DISTANCE)));
            } else {
                worldIn.setBlockState(pos, FruitfulBlocks.BUDDING_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.PERSISTENT, false).with(LeavesBlock.DISTANCE, state.get(LeavesBlock.DISTANCE)));
            }
        }

        super.randomTick(state, worldIn, pos, random);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POLLINATED);
        super.fillStateContainer(builder);
    }
}
