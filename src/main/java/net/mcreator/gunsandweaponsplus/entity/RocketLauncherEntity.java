
package net.mcreator.gunsandweaponsplus.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.gunsandweaponsplus.procedures.RocketLauncherProjectileHitsBlockProcedure;
import net.mcreator.gunsandweaponsplus.init.GunsAndWeaponsPlusModItems;
import net.mcreator.gunsandweaponsplus.init.GunsAndWeaponsPlusModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class RocketLauncherEntity extends AbstractArrow implements ItemSupplier {
	public RocketLauncherEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(GunsAndWeaponsPlusModEntities.ROCKET_LAUNCHER.get(), world);
	}

	public RocketLauncherEntity(EntityType<? extends RocketLauncherEntity> type, Level world) {
		super(type, world);
	}

	public RocketLauncherEntity(EntityType<? extends RocketLauncherEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public RocketLauncherEntity(EntityType<? extends RocketLauncherEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(GunsAndWeaponsPlusModItems.ROCKET.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(GunsAndWeaponsPlusModItems.ROCKET.get());
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		RocketLauncherProjectileHitsBlockProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		RocketLauncherProjectileHitsBlockProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static RocketLauncherEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		RocketLauncherEntity entityarrow = new RocketLauncherEntity(GunsAndWeaponsPlusModEntities.ROCKET_LAUNCHER.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		entityarrow.setSecondsOnFire(100);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static RocketLauncherEntity shoot(LivingEntity entity, LivingEntity target) {
		RocketLauncherEntity entityarrow = new RocketLauncherEntity(GunsAndWeaponsPlusModEntities.ROCKET_LAUNCHER.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.9f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(12);
		entityarrow.setKnockback(4);
		entityarrow.setCritArrow(false);
		entityarrow.setSecondsOnFire(100);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}