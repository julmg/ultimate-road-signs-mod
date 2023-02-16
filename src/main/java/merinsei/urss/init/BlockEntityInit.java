package merinsei.urss.init;

import merinsei.urss.Urss;
import merinsei.urss.block.entity.TrafficLightBlockEntity;
import merinsei.urss.block.entity.WritableERoadSignBlockEntity;
import merinsei.urss.block.entity.WritableRoadSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Urss.MODID);
	
	public static final RegistryObject<BlockEntityType<WritableRoadSignBlockEntity>> W_SIGN = BLOCK_ENTITY_TYPES.register("writable_sign",
            () -> BlockEntityType.Builder.of(
            		WritableRoadSignBlockEntity::new, 
            		BlockInit.WSIGN_D21.get(), 
            		BlockInit.WSIGN_D61.get(), 
            		BlockInit.WSIGN_D43.get())
            .build(null));
	
	public static final RegistryObject<BlockEntityType<WritableERoadSignBlockEntity>> W_ESIGN = BLOCK_ENTITY_TYPES.register("writable_sign_e",
            () -> BlockEntityType.Builder.of(
            		WritableERoadSignBlockEntity::new, 
            		BlockInit.WSIGN_E.get())
            .build(null));
	
	public static final RegistryObject<BlockEntityType<TrafficLightBlockEntity>> TRAFFIC_LIGHT = BLOCK_ENTITY_TYPES.register("traffic_light",
            () -> BlockEntityType.Builder.of(
            		TrafficLightBlockEntity::new, 
            		BlockInit.TRAFFICLIGHT_1.get(),
            		BlockInit.TRAFFICLIGHT_2H.get())
            .build(null));
}
