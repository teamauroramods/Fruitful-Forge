package com.teamaurora.fruitful.core.mixin;

import com.teamaurora.fruitful.core.registry.FruitfulBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeEntity.FindPollinationTargetGoal.class)
public abstract class BeeEntityFindPollinationTargetGoalMixin {

    @Dynamic(value = "This is from a Fruitful mixin :0")
    private BeeEntity b;

    private BeeEntityFindPollinationTargetGoalMixin() {
    }

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void onConstructed(BeeEntity outer, CallbackInfo ci) {
        b = outer;
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void onTick(CallbackInfo ci) {
        if (b.getRNG().nextInt(15) == 0) {
            for (BlockPos pos : BlockPos.getAllInBoxMutable(b.getPosition().add(1, 1, 1), b.getPosition().add(-1, -1, -1))) {
                BlockState blockstate = b.world.getBlockState(pos);
                Block block = blockstate.getBlock();

                if (block == FruitfulBlocks.BLOSSOMING_OAK_LEAVES.get() && !blockstate.get(LeavesBlock.PERSISTENT)) {
                    b.world.playEvent(2005, pos, 0);
                    b.world.setBlockState(pos, FruitfulBlocks.APPLE_OAK_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, blockstate.get(LeavesBlock.DISTANCE)));
                    b.addCropCounter();
                }
            }
        }
    }
}
