package merinsei.urss.init;

import merinsei.urss.Urss;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Urss.MODID);
	
	public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
	public static final RegistryObject<Item> BRUSH = ITEMS.register("brush", () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
	
	public static class ModCreativeTab extends CreativeModeTab {
		
		public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "roadsigns");
		
	    private ModCreativeTab(int index, String label) {
	        super(index, label);
	    }

	    @Override
	    public ItemStack makeIcon() {
	        return new ItemStack(HAMMER.get());
	    }
	    
	}
}
