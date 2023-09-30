
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsandweaponsplus.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.gunsandweaponsplus.item.SniperRifleItem;
import net.mcreator.gunsandweaponsplus.item.SniperBulletItem;
import net.mcreator.gunsandweaponsplus.item.RocketLauncherItem;
import net.mcreator.gunsandweaponsplus.item.RocketItem;
import net.mcreator.gunsandweaponsplus.GunsAndWeaponsPlusMod;

public class GunsAndWeaponsPlusModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GunsAndWeaponsPlusMod.MODID);
	public static final RegistryObject<Item> SNIPER_RIFLE = REGISTRY.register("sniper_rifle", () -> new SniperRifleItem());
	public static final RegistryObject<Item> ROCKET_LAUNCHER = REGISTRY.register("rocket_launcher", () -> new RocketLauncherItem());
	public static final RegistryObject<Item> SNIPER_BULLET = REGISTRY.register("sniper_bullet", () -> new SniperBulletItem());
	public static final RegistryObject<Item> ROCKET = REGISTRY.register("rocket", () -> new RocketItem());
}
