package com.rosincombat.mixin;

import net.minecraft.block.AbstractBlock;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import com.rosincombat.AbstractBlockAccessor;

@Mixin(AbstractBlock.class)
public abstract class AbstractBlockMixin implements AbstractBlockAccessor {
	@Accessor("collidable") public abstract boolean isCollidable();
}
