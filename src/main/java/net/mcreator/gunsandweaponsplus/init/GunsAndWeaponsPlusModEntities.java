
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsandweaponsplus.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.gunsandweaponsplus.entity.SniperRifleEntity;
import net.mcreator.gunsandweaponsplus.entity.RocketLauncherEntity;
import net.mcreator.gunsandweaponsplus.GunsAndWeaponsPlusMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunsAndWeaponsPlusModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GunsAndWeaponsPlusMod.MODID);
	public static final RegistryObject<EntityType<SniperRifleEntity>> SNIPER_RIFLE = register("projectile_sniper_rifle",
			EntityType.Builder.<SniperRifleEntity>of(SniperRifleEntity::new, MobCategory.MISC).setCustomClientFactory(SniperRifleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RocketLauncherEntity>> ROCKET_LAUNCHER = register("projectile_rocket_launcher",
			EntityType.Builder.<RocketLauncherEntity>of(RocketLauncherEntity::new, MobCategory.MISC).setCustomClientFactory(RocketLauncherEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
