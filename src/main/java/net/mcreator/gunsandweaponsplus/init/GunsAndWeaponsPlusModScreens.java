
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsandweaponsplus.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.gunsandweaponsplus.client.gui.RecipesScreen;
import net.mcreator.gunsandweaponsplus.client.gui.Recipes2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GunsAndWeaponsPlusModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(GunsAndWeaponsPlusModMenus.RECIPES.get(), RecipesScreen::new);
			MenuScreens.register(GunsAndWeaponsPlusModMenus.RECIPES_2.get(), Recipes2Screen::new);
		});
	}
}
