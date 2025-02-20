package com.rosincombat.mixin.handlers;

import net.minecraft.block.BlockState;
import net.minecraft.entity.vehicle.BoatEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rosincombat.AbstractBlockAccessor;
import com.rosincombat.RosinRevamp;

@Mixin(BoatEntity.class)
public class BoatEntityHandlers extends EntityAbstractHandler {
	@Override
	protected void blockCollisionHandler(BlockState state, CallbackInfo __) {
		if (!((AbstractBlockAccessor)state.getBlock()).isCollidable()) return;
		RosinRevamp.LOGGER.info("Collided with " + state.getBlock());
	}
}
