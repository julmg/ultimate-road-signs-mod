package merinsei.urss.init;

import java.util.function.Supplier;

import merinsei.urss.Urss;
import merinsei.urss.block.*;
import merinsei.urss.block.BlinkingTrafficLight.TrafficLightSize;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Urss.MODID);

    public static final RegistryObject<Block> POLE = BLOCKS.register("pole", () -> new Pole());
    public static final RegistryObject<Block> SIGN_A1A = BLOCKS.register("sign_a1a", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A1B = BLOCKS.register("sign_a1b", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A1C = BLOCKS.register("sign_a1c", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A1D = BLOCKS.register("sign_a1d", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A2A = BLOCKS.register("sign_a2a", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A2B = BLOCKS.register("sign_a2b", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A3 = BLOCKS.register("sign_a3", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A3A = BLOCKS.register("sign_a3a", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_A3B = BLOCKS.register("sign_a3b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A4 = BLOCKS.register("sign_a4", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A6 = BLOCKS.register("sign_a6", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A7 = BLOCKS.register("sign_a7", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A8 = BLOCKS.register("sign_a8", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A9 = BLOCKS.register("sign_a9", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A13A = BLOCKS.register("sign_a13a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A13B = BLOCKS.register("sign_a13b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A14 = BLOCKS.register("sign_a14", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A15A1 = BLOCKS.register("sign_a15a1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A15A2 = BLOCKS.register("sign_a15a2", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A15B = BLOCKS.register("sign_a15b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A15C = BLOCKS.register("sign_a15c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A16 = BLOCKS.register("sign_a16", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A17 = BLOCKS.register("sign_a17", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A18 = BLOCKS.register("sign_a18", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A19 = BLOCKS.register("sign_a19", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A20 = BLOCKS.register("sign_a20", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A21A = BLOCKS.register("sign_a21a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A23 = BLOCKS.register("sign_a23", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_A24 = BLOCKS.register("sign_a24", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_AB1 = BLOCKS.register("sign_ab1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_AB2 = BLOCKS.register("sign_ab2", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_AB3 = BLOCKS.register("sign_ab3", () -> new RoadSign());     
    public static final RegistryObject<Block> SIGN_AB4 = BLOCKS.register("sign_ab4", () -> new RoadSign());    
    public static final RegistryObject<Block> SIGN_AB6 = BLOCKS.register("sign_ab6", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_AB7 = BLOCKS.register("sign_ab7", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_AB25 = BLOCKS.register("sign_ab25", () -> new RoadSign());   
    
    
    public static final RegistryObject<Block> SIGN_B0 = BLOCKS.register("sign_b0", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B1 = BLOCKS.register("sign_b1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B2A = BLOCKS.register("sign_b2a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B2B = BLOCKS.register("sign_b2b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B2C = BLOCKS.register("sign_b2c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B3 = BLOCKS.register("sign_b3", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B3A = BLOCKS.register("sign_b3a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B4 = BLOCKS.register("sign_b4", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B5A = BLOCKS.register("sign_b5a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B5B = BLOCKS.register("sign_b5b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B5C = BLOCKS.register("sign_b5c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B6A1 = BLOCKS.register("sign_b6a1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B6D = BLOCKS.register("sign_b6d", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B7A = BLOCKS.register("sign_b7a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B7B = BLOCKS.register("sign_b7b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B8 = BLOCKS.register("sign_b8", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9A = BLOCKS.register("sign_b9a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9B = BLOCKS.register("sign_b9b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9C = BLOCKS.register("sign_b9c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9D = BLOCKS.register("sign_b9d", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9E = BLOCKS.register("sign_b9e", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9F = BLOCKS.register("sign_b9f", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9G = BLOCKS.register("sign_b9g", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9H = BLOCKS.register("sign_b9h", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B9I = BLOCKS.register("sign_b9i", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B10A = BLOCKS.register("sign_b10a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B11 = BLOCKS.register("sign_b11", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B12 = BLOCKS.register("sign_b12", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B13 = BLOCKS.register("sign_b13", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B13A = BLOCKS.register("sign_b13a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B14_15 = BLOCKS.register("sign_b14_15", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B14_30 = BLOCKS.register("sign_b14_30", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B14_50 = BLOCKS.register("sign_b14_50", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B14_70 = BLOCKS.register("sign_b14_70", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B14_90 = BLOCKS.register("sign_b14_90", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B14_110 = BLOCKS.register("sign_b14_110", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B14_130 = BLOCKS.register("sign_b14_130", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B15 = BLOCKS.register("sign_b15", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B16 = BLOCKS.register("sign_b16", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B17 = BLOCKS.register("sign_b17", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B18A = BLOCKS.register("sign_b18a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B18B = BLOCKS.register("sign_b18b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B18C = BLOCKS.register("sign_b18c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B19 = BLOCKS.register("sign_b19", () -> new RoadSign());   
    
    public static final RegistryObject<Block> SIGN_B211 = BLOCKS.register("sign_b211", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B212 = BLOCKS.register("sign_b212", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21A1 = BLOCKS.register("sign_b21a1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21A2 = BLOCKS.register("sign_b21a2", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21B = BLOCKS.register("sign_b21b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21C1 = BLOCKS.register("sign_b21c1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21C2 = BLOCKS.register("sign_b21c2", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21D1 = BLOCKS.register("sign_b21d1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21D2 = BLOCKS.register("sign_b21d2", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B21E = BLOCKS.register("sign_b21e", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B22A = BLOCKS.register("sign_b22a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B22B = BLOCKS.register("sign_b22b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B22C = BLOCKS.register("sign_b22c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B25 = BLOCKS.register("sign_b25", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B26 = BLOCKS.register("sign_b26", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B27A = BLOCKS.register("sign_b27a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B27B = BLOCKS.register("sign_b27b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B29 = BLOCKS.register("sign_b29", () -> new RoadSign());   

    public static final RegistryObject<Block> SIGN_B31 = BLOCKS.register("sign_b31", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B33_15 = BLOCKS.register("sign_b33_15", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B33_30 = BLOCKS.register("sign_b33_30", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B33_50 = BLOCKS.register("sign_b33_50", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B33_70 = BLOCKS.register("sign_b33_70", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B33_90 = BLOCKS.register("sign_b33_90", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B33_110 = BLOCKS.register("sign_b33_110", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B33_130 = BLOCKS.register("sign_b33_130", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B34 = BLOCKS.register("sign_b34", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B34A = BLOCKS.register("sign_b34a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B35 = BLOCKS.register("sign_b35", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B39 = BLOCKS.register("sign_b39", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B40 = BLOCKS.register("sign_b40", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B41 = BLOCKS.register("sign_b41", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B42 = BLOCKS.register("sign_b42", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B43 = BLOCKS.register("sign_b43", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B44 = BLOCKS.register("sign_b44", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B45A = BLOCKS.register("sign_b45a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_B49 = BLOCKS.register("sign_b49", () -> new RoadSign());   

    
    public static final RegistryObject<Block> SIGN_C1A = BLOCKS.register("sign_c1a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C1B = BLOCKS.register("sign_c1b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C1C = BLOCKS.register("sign_c1c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C3 = BLOCKS.register("sign_c3", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C5 = BLOCKS.register("sign_c5", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C6 = BLOCKS.register("sign_c6", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C8 = BLOCKS.register("sign_c8", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C12 = BLOCKS.register("sign_c12", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C13A = BLOCKS.register("sign_c13a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C13B = BLOCKS.register("sign_c13b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C141 = BLOCKS.register("sign_c141", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C142 = BLOCKS.register("sign_c142", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C18 = BLOCKS.register("sign_c18", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C20A = BLOCKS.register("sign_c20a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C20C = BLOCKS.register("sign_c20c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C23 = BLOCKS.register("sign_c23", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C24A1 = BLOCKS.register("sign_c24a1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C24A4 = BLOCKS.register("sign_c24a4", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C24B1 = BLOCKS.register("sign_c24b1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C24B2 = BLOCKS.register("sign_c24b2", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C24C1 = BLOCKS.register("sign_c24c1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C24C2 = BLOCKS.register("sign_c24c2", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C25A = BLOCKS.register("sign_c25a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C25B = BLOCKS.register("sign_c25b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C26A = BLOCKS.register("sign_c26a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C26B = BLOCKS.register("sign_c26b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C27 = BLOCKS.register("sign_c27", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C281 = BLOCKS.register("sign_c281", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C283 = BLOCKS.register("sign_c283", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C29A = BLOCKS.register("sign_c29a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C29B = BLOCKS.register("sign_c29b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C30 = BLOCKS.register("sign_c30", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C50 = BLOCKS.register("sign_c50", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C62 = BLOCKS.register("sign_c62", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C64A = BLOCKS.register("sign_c64a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C64B = BLOCKS.register("sign_c64b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C64C = BLOCKS.register("sign_c64c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C64D = BLOCKS.register("sign_c64d", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C107 = BLOCKS.register("sign_c107", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C108 = BLOCKS.register("sign_c108", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C111 = BLOCKS.register("sign_c111", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C112 = BLOCKS.register("sign_c112", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C113 = BLOCKS.register("sign_c113", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C114 = BLOCKS.register("sign_c114", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C115 = BLOCKS.register("sign_c115", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C116 = BLOCKS.register("sign_c116", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C207 = BLOCKS.register("sign_c207", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_C208 = BLOCKS.register("sign_c208", () -> new RoadSign());   
    
    public static final RegistryObject<Block> SIGN_CE1 = BLOCKS.register("sign_ce1", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE2A = BLOCKS.register("sign_ce2a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE2B = BLOCKS.register("sign_ce2b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE3A = BLOCKS.register("sign_ce3a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE4A = BLOCKS.register("sign_ce4a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE4B = BLOCKS.register("sign_ce4b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE4C = BLOCKS.register("sign_ce4c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE5A = BLOCKS.register("sign_ce5a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE5B = BLOCKS.register("sign_ce5b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE6A = BLOCKS.register("sign_ce6a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE6B = BLOCKS.register("sign_ce6b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE7 = BLOCKS.register("sign_ce7", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE8 = BLOCKS.register("sign_ce8", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE9 = BLOCKS.register("sign_ce9", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE10 = BLOCKS.register("sign_ce10", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE12 = BLOCKS.register("sign_ce12", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE14 = BLOCKS.register("sign_ce14", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE15A = BLOCKS.register("sign_ce15a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE15C = BLOCKS.register("sign_ce15c", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE16 = BLOCKS.register("sign_ce16", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE17 = BLOCKS.register("sign_ce17", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE18 = BLOCKS.register("sign_ce18", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE19 = BLOCKS.register("sign_ce19", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE20A = BLOCKS.register("sign_ce20a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE20B = BLOCKS.register("sign_ce20b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE21 = BLOCKS.register("sign_ce21", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE22 = BLOCKS.register("sign_ce22", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE23 = BLOCKS.register("sign_ce23", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE24 = BLOCKS.register("sign_ce24", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE25 = BLOCKS.register("sign_ce25", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE26 = BLOCKS.register("sign_ce26", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE27 = BLOCKS.register("sign_ce27", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE28 = BLOCKS.register("sign_ce28", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE29 = BLOCKS.register("sign_ce29", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE30A = BLOCKS.register("sign_ce30a", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE30B = BLOCKS.register("sign_ce30b", () -> new RoadSign());   
    public static final RegistryObject<Block> SIGN_CE50 = BLOCKS.register("sign_ce50", () -> new RoadSign());    

    public static final RegistryObject<Block> SIGN_M1 = BLOCKS.register("sign_m1", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M2 = BLOCKS.register("sign_m2", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M3A1 = BLOCKS.register("sign_m3a1", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M3A2 = BLOCKS.register("sign_m3a2", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M3D = BLOCKS.register("sign_m3d", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M4A = BLOCKS.register("sign_m4a", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M4B = BLOCKS.register("sign_m4b", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M4D1 = BLOCKS.register("sign_m4d1", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M5 = BLOCKS.register("sign_m5", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M6A = BLOCKS.register("sign_m6a", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M8A = BLOCKS.register("sign_m8a", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M8B = BLOCKS.register("sign_m8b", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M8C = BLOCKS.register("sign_m8c", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M8D = BLOCKS.register("sign_m8d", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M8E = BLOCKS.register("sign_m8e", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M8H = BLOCKS.register("sign_m8h", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M9C = BLOCKS.register("sign_m9c", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M9D = BLOCKS.register("sign_m9d", () -> new RoadSign());
    public static final RegistryObject<Block> SIGN_M9V2 = BLOCKS.register("sign_m9v2", () -> new RoadSign());

    public static final RegistryObject<Block> WSIGN_D21 = BLOCKS.register("writablesign_d21", () -> new WritableDirectionRoadSign());
    public static final RegistryObject<Block> WSIGN_D43 = BLOCKS.register("writablesign_d43", () -> new WritableDirectionRoadSign());
    public static final RegistryObject<Block> WSIGN_D61 = BLOCKS.register("writablesign_d61", () -> new WritableDirectionRoadSign());
    public static final RegistryObject<Block> WSIGN_E = BLOCKS.register("writablesign_e", () -> new WritableERoadSign());
    
    public static final RegistryObject<Block> TRAFFICLIGHT_1 = BLOCKS.register("trafficlight_1", () -> new BlinkingTrafficLight(TrafficLightSize.ONE));
    public static final RegistryObject<Block> TRAFFICLIGHT_2H = BLOCKS.register("trafficlight_2h", () -> new BlinkingTrafficLight(TrafficLightSize.TWO_H));
    public static final RegistryObject<Block> TRAFFICLIGHT_3V = BLOCKS.register("trafficlight_3v", () -> new BlinkingTrafficLight(TrafficLightSize.THREE_V));
    public static final RegistryObject<Block> TRAFFICLIGHT_3H = BLOCKS.register("trafficlight_3h", () -> new BlinkingTrafficLight(TrafficLightSize.THREE_H));

    
    
    //register blockitems
    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)){
            BLOCKS.getEntries().forEach( (blockRegistryObject) -> {
                Block block = blockRegistryObject.get();
                Item.Properties properties = new Item.Properties().tab(ItemInit.ModCreativeTab.instance);
                Supplier<Item> blockItemFactory = () -> new BlockItem(block, properties);
                event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
            });
        }
    }
   
}