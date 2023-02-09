package merinsei.urss.init;

import merinsei.urss.Urss;
import merinsei.urss.client.gui.WritableERoadSignBlockEntityMenu;
import merinsei.urss.client.gui.WritableRoadSignBlockEntityMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MenuInit {
	
	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Urss.MODID);
	
	public static final RegistryObject<MenuType<WritableRoadSignBlockEntityMenu>> WRITABLE_SIGN_MENU = 
			MENUS.register("writable_sign_menu", () -> new MenuType<WritableRoadSignBlockEntityMenu>(WritableRoadSignBlockEntityMenu::new));
	
	public static final RegistryObject<MenuType<WritableERoadSignBlockEntityMenu>> WRITABLE_ESIGN_MENU = 
			MENUS.register("writable_e_sign_menu", () -> new MenuType<WritableERoadSignBlockEntityMenu>(WritableERoadSignBlockEntityMenu::new));
}
