
package net.mcreator.gunsandweaponsplus.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SniperBulletItem extends Item {
	public SniperBulletItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}
}
