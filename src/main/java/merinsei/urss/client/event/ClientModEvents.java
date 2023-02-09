package merinsei.urss.client.event;

import merinsei.urss.block.entity.renderer.TrafficLightBlockEntityRenderer;
import merinsei.urss.block.entity.renderer.WritableERoadSignBlockEntityRenderer;
import merinsei.urss.block.entity.renderer.WritableRoadSignBlockEntityRenderer;
import merinsei.urss.client.gui.WritableERoadSignBlockEntityScreen;
import merinsei.urss.client.gui.WritableRoadSignBlockEntityScreen;
import merinsei.urss.init.BlockEntityInit;
import merinsei.urss.init.MenuInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
	
	@SubscribeEvent
	public static void registerRenderers(RegisterRenderers event) {
		event.registerBlockEntityRenderer(BlockEntityInit.W_SIGN.get(), WritableRoadSignBlockEntityRenderer::new);
		event.registerBlockEntityRenderer(BlockEntityInit.W_ESIGN.get(), WritableERoadSignBlockEntityRenderer::new);
		event.registerBlockEntityRenderer(BlockEntityInit.TRAFFIC_LIGHT.get(), TrafficLightBlockEntityRenderer::new);
	}
	
	public static void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
		MenuScreens.register(MenuInit.WRITABLE_SIGN_MENU.get(), WritableRoadSignBlockEntityScreen::new);
		MenuScreens.register(MenuInit.WRITABLE_ESIGN_MENU.get(), WritableERoadSignBlockEntityScreen::new);
		});
	}
}
