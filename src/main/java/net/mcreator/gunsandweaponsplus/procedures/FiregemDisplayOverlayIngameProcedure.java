package net.mcreator.gunsandweaponsplus.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.gunsandweaponsplus.init.GunsAndWeaponsPlusModItems;

public class FiregemDisplayOverlayIngameProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(GunsAndWeaponsPlusModItems.SNIPER_RIFLE.get())) : false) {
			if (entity instanceof Player _player) {
				_player.getAbilities().mayBuild = true;
				_player.onUpdateAbilities();
			}
		}
	}
}
