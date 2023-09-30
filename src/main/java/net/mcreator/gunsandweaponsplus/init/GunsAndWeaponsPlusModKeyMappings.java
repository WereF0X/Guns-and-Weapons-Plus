
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsandweaponsplus.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.gunsandweaponsplus.network.RecipesForGunsAndWeaponsPlusMessage;
import net.mcreator.gunsandweaponsplus.GunsAndWeaponsPlusMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GunsAndWeaponsPlusModKeyMappings {
	public static final KeyMapping RECIPES_FOR_GUNS_AND_WEAPONS_PLUS = new KeyMapping("key.guns_and_weapons_plus.recipes_for_guns_and_weapons_plus", GLFW.GLFW_KEY_U, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				GunsAndWeaponsPlusMod.PACKET_HANDLER.sendToServer(new RecipesForGunsAndWeaponsPlusMessage(0, 0));
				RecipesForGunsAndWeaponsPlusMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(RECIPES_FOR_GUNS_AND_WEAPONS_PLUS);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				RECIPES_FOR_GUNS_AND_WEAPONS_PLUS.consumeClick();
			}
		}
	}
}
