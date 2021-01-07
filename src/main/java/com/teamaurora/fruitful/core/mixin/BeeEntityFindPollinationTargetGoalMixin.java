package com.teamaurora.fruitful.core.mixin;

import com.teamaurora.fruitful.common.block.OakBlossomBlock;
import com.teamaurora.fruitful.core.registry.FruitfulBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.state.IntegerProperty;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeEntity.FindPollinationTargetGoal.class)
public abstract class BeeEntityFindPollinationTargetGoalMixin {

    private BeeEntity b;

    private BeeEntityFindPollinationTargetGoalMixin() {
    }

    @Inject(at = @At(value = "TAIL"), method = "<init>")
    private void registerBee(BeeEntity bee, CallbackInfo ci) {
        b = bee;
    }

    @Inject(at = @At(value = "TAIL"), method = "tick")
    public void pollinateOakBlossoms(CallbackInfo ci) {
        if (b.getRNG().nextInt(30) == 0) {
            for(int i = 1; i <= 2; ++i) {
                BlockPos blockpos = b.getPosition().down(i);
                BlockState blockstate = b.world.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                boolean flag = false;
                IntegerProperty integerproperty = null;
                if (block.isIn(BlockTags.BEE_GROWABLES)) {
                    if (block == FruitfulBlocks.BLOSSOMING_OAK_LEAVES.get() && !blockstate.get(LeavesBlock.PERSISTENT)) {
                        b.world.playEvent(2005, blockpos, 0);
                        b.world.setBlockState(blockpos, FruitfulBlocks.APPLE_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, blockstate.get(LeavesBlock.DISTANCE)));
                        b.addCropCounter();
                    }
                }
            }

        }
    }
}
