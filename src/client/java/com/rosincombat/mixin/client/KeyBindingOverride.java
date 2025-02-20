package com.rosincombat.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import com.rosincombat.KeyBindingAccessor;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

@Mixin(KeyBinding.class)
public abstract class KeyBindingOverride implements KeyBindingAccessor {
	@Accessor public abstract InputUtil.Key getBoundKey();
}
