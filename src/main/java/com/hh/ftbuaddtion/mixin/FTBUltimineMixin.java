package com.hh.ftbuaddtion.mixin;

import com.hh.ftbuaddtion.config.AddonConfig;
import com.hh.ftbuaddtion.util.PlayerContext;
import dev.ftb.mods.ftbultimine.ItemCollection;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemCollection.class)
public class FTBUltimineMixin {

    @Inject(method = "drop", at = @At("HEAD"), cancellable = true, remap = false)
    private void onDrop(Level world, BlockPos pos, CallbackInfo ci) {
        int dropMode = AddonConfig.SERVER.dropMode.get();
        if (dropMode == 0) return;

        ServerPlayer player = PlayerContext.getPlayer();
        if (player == null) return;

        List<ItemStack> items = ((ItemCollectionAccessor) (Object) this).getItems();
        if (items.isEmpty()) return;

        List<ItemStack> drops = new ArrayList<>(items);
        items.clear();
        ci.cancel();

        if (dropMode == 1) {
            BlockPos dropPos = player.blockPosition();
            for (ItemStack stack : drops) {
                Block.popResource(world, dropPos, stack);
            }
        } else if (dropMode == 2) {
            for (ItemStack stack : drops) {
                if (!player.getInventory().add(stack)) {
                    player.drop(stack, false);
                }
            }
        }
    }
}