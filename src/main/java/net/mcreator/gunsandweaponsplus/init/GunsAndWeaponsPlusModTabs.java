
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsandweaponsplus.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.gunsandweaponsplus.GunsAndWeaponsPlusMod;

public class GunsAndWeaponsPlusModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GunsAndWeaponsPlusMod.MODID);
	public static final RegistryObject<CreativeModeTab> GUNS_AND_WEAPONS_PLUS = REGISTRY.register("guns_and_weapons_plus",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.guns_and_weapons_plus.guns_and_weapons_plus")).icon(() -> new ItemStack(GunsAndWeaponsPlusModItems.SNIPER_RIFLE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GunsAndWeaponsPlusModItems.SNIPER_RIFLE.get());
				tabData.accept(GunsAndWeaponsPlusModItems.ROCKET_LAUNCHER.get());
				tabData.accept(GunsAndWeaponsPlusModItems.SNIPER_BULLET.get());
				tabData.accept(GunsAndWeaponsPlusModItems.ROCKET.get());
			})

					.build());
}
