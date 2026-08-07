package com.hh.ftbuaddtion.mixin;

import com.hh.ftbuaddtion.util.PlayerContext;
import dev.architectury.event.EventResult;
import dev.architectury.utils.value.IntValue;
import dev.ftb.mods.ftbultimine.FTBUltimine;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FTBUltimine.class)
public class FTBUltimineBlockBrokenMixin {

    @Inject(
            method = "blockBroken",
            at = @At(
                    value = "INVOKE",
                    target = "Ldev/ftb/mods/ftbultimine/ItemCollection;drop(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V",
                    shift = At.Shift.BEFORE
            ),
            remap = false
    )
    private void beforeDrop(Level world, BlockPos pos, BlockState state, ServerPlayer player, IntValue xp, CallbackInfoReturnable<EventResult> cir) {
        PlayerContext.setPlayer(player);
    }

    @Inject(
            method = "blockBroken",
            at = @At("RETURN"),
            remap = false
    )
    private void afterBlockBroken(Level world, BlockPos pos, BlockState state, ServerPlayer player, IntValue xp, CallbackInfoReturnable<EventResult> cir) {
        PlayerContext.clear();
    }
}