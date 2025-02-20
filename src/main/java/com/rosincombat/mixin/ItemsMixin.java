package com.rosincombat.mixin;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Items.class)
public abstract class ItemsMixin {
	@ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/AxeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;"))
	private static void modifyAxes(Args args) {
		args.set(1, 4.0F);
		args.set(2, 0.0F);
	}
	@ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ShovelItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;"))
	private static void modifyShovels(Args args) {
		args.set(1, 1.0F);
		args.set(2, 0.0F);
	}
	@ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/PickaxeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;"))
	private static void modifyPickaxes(Args args) {
		args.set(1, 2.0F);
		args.set(2, 0.5F);
	}
	@ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/HoeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;"))
	private static void modifyHoes(Args args) {
		ToolMaterial material = args.get(0);
		switch (material) {
			default:
				args.set(2, 1.5F);
				break;
			case ToolMaterials.IRON:
				args.set(2, 1.0F);
				break;
			case ToolMaterials.STONE:
				args.set(2, 0.5F);
				break;
			case ToolMaterials.WOOD:
				args.set(2, 0.0F);
		}
		args.set(1, material.getAttackDamage() >= 2.0F ? 0.0F : 1.0F);
	}
}
