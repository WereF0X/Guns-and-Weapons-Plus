
package net.mcreator.gunsandweaponsplus.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RocketItem extends Item {
	public RocketItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
