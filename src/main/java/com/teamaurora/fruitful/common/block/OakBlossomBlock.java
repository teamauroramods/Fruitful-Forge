package com.teamaurora.fruitful.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.AbnormalsLeavesBlock;
import com.teamaurora.fruitful.core.registry.FruitfulBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class OakBlossomBlock extends AbnormalsLeavesBlock {
    public OakBlossomBlock(AbstractBlock.Properties properties) {
        super(properties);
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
            if (random.nextInt(3) == 0) {
                worldIn.setBlockState(pos, FruitfulBlocks.FLOWERING_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.PERSISTENT, false).with(LeavesBlock.DISTANCE, state.get(LeavesBlock.DISTANCE)));
            } else {
                worldIn.setBlockState(pos, FruitfulBlocks.BUDDING_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.PERSISTENT, false).with(LeavesBlock.DISTANCE, state.get(LeavesBlock.DISTANCE)));
            }
        }

        super.randomTick(state, worldIn, pos, random);
    }

    //TODO: will probably need to mixin to BeeEntity here. Kinda a pain but oh well
    /*@Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        //List<BeeEntity> bees = worldIn.getEntitiesWithinAABB(EntityType.BEE, new AxisAlignedBB(pos.getX()-1, pos.getY()-1, pos.getZ()-1, pos.getX()+1, pos.getY()+1, pos.getZ()+1), Objects::nonNull);
        //if (!bees.isEmpty() && !state.get(LeavesBlock.PERSISTENT)) {
            worldIn.setBlockState(pos, FruitfulBlocks.APPLE_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.PERSISTENT, false).with(LeavesBlock.DISTANCE, state.get(LeavesBlock.DISTANCE)));
        //}
        super.tick(state, worldIn, pos, rand);
    }*/
}
