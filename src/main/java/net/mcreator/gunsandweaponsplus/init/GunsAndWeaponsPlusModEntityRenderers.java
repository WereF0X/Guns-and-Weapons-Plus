
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.gunsandweaponsplus.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GunsAndWeaponsPlusModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GunsAndWeaponsPlusModEntities.SNIPER_RIFLE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(GunsAndWeaponsPlusModEntities.ROCKET_LAUNCHER.get(), ThrownItemRenderer::new);
	}
}
