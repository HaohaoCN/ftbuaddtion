package com.hh.ftbuaddtion.mixin;

import dev.ftb.mods.ftbultimine.ItemCollection;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ItemCollection.class)
public interface ItemCollectionAccessor {
    @Accessor(value = "items", remap = false)
    List<ItemStack> getItems();
}