package merinsei.urss;

import merinsei.urss.client.event.ClientModEvents;
import merinsei.urss.client.gui.WritableERoadSignBlockEntityMenu;
import merinsei.urss.client.gui.WritableRoadSignBlockEntityMenu;
import merinsei.urss.init.BlockEntityInit;
import merinsei.urss.init.BlockInit;
import merinsei.urss.init.ItemInit;
import merinsei.urss.init.MenuInit;
import merinsei.urss.network.UrssPacketHandler;
import merinsei.urss.network.ToClientWritableERoadSignMessagePacket;
import merinsei.urss.network.ToClientWritableRoadSignMessagePacket;
import merinsei.urss.network.ToServerWritableERoadSignMessagePacket;
import merinsei.urss.network.ToServerWritableRoadSignMessagePacket;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Urss.MODID)
public class Urss
{
    public static final String MODID = "urss";
	private int pktId = 0;
  
    public Urss()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(ClientModEvents::clientSetup);

        
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        BlockEntityInit.BLOCK_ENTITY_TYPES.register(modEventBus);
        MenuInit.MENUS.register(modEventBus);
        
        registerNetworkPackets();

        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void registerNetworkPackets() {
    	UrssPacketHandler.INSTANCE.registerMessage(
				pktId++, ToServerWritableRoadSignMessagePacket.class, 
				UrssPacketHandler::encode, 
				UrssPacketHandler::decodeCTS, 
				WritableRoadSignBlockEntityMenu::handle);
        
        UrssPacketHandler.INSTANCE.registerMessage(
				pktId++, ToClientWritableRoadSignMessagePacket.class, 
				UrssPacketHandler::encode, 
				UrssPacketHandler::decodeSTC, 
				ToClientWritableRoadSignMessagePacket::handle);
        
        UrssPacketHandler.INSTANCE.registerMessage(
				pktId++, ToServerWritableERoadSignMessagePacket.class, 
				UrssPacketHandler::encode, 
				UrssPacketHandler::decodeCTS_E, 
				WritableERoadSignBlockEntityMenu::handle);
        
        UrssPacketHandler.INSTANCE.registerMessage(
				pktId++, ToClientWritableERoadSignMessagePacket.class, 
				UrssPacketHandler::encode, 
				UrssPacketHandler::decodeSTC_E, 
				ToClientWritableERoadSignMessagePacket::handle);
    }
}
