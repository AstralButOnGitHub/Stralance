package net.jcm.vsch;

import net.jcm.vsch.blocks.VSCHBlockz;
import net.jcm.vsch.blocks.entity.VSCHBlockEntities;
import net.jcm.vsch.commands.ModCommands;
import net.jcm.vsch.compat.CompatMods;
import net.jcm.vsch.compat.create.VSCHPonderRegistry;
import net.jcm.vsch.compat.create.VSCHPonderTags;
import net.jcm.vsch.compat.create.VSCHRegistrateBlocks;
import net.jcm.vsch.config.VSCHConfig;
import net.jcm.vsch.entity.VSCHEntities;
import net.jcm.vsch.event.GravityInducer;
import net.jcm.vsch.items.VSCHItems;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.valkyrienskies.core.impl.hooks.VSEvents;

@Mod(VSCHMod.MODID)
public class VSCHMod {
	public static final String MODID = "vsch";

	// Register blocks (thruster)
	//private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VSCHConfig.MOD_ID);
	//public static final RegistryObject<Block> SAD_BLOCK = BLOCKS.register("thruster",
	//        () -> new ThrusterBlock(Block.Properties.copy(Blocks.IRON_BLOCK)));

	//public static final Logger logger = LogManager.getLogger(VSCHConfig.MOD_ID);

	public VSCHMod() {
		// Initialize logic here
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		//BLOCKS.register(modBus);
		VSCHItems.register(modBus);
		VSCHBlockz.register(modBus);
		VSCHBlockEntities.register(modBus);
		VSCHConfig.register(ModLoadingContext.get());
		VSCHTab.register(modBus);
		VSCHEntities.register(modBus);
		// Register commands (I took this code from another one of my mods, can't be bothered to make it consistent with the rest of this)
		MinecraftForge.EVENT_BUS.register(ModCommands.class);

		VSEvents.ShipLoadEvent.Companion.on((shipLoadEvent) -> {
			GravityInducer.getOrCreate(shipLoadEvent.getShip());
		});

		modBus.addListener(this::onClientSetup);
		modBus.addListener(this::registerRenderers);

		if (CompatMods.CREATE.isLoaded()) {
			VSCHRegistrateBlocks.register();
		}
	}

	// Idk why but this doesn't work in VSCHEvents (prob its only a server-side event listener)
	private void onClientSetup(FMLClientSetupEvent event) {
		if (CompatMods.CREATE.isLoaded()) {
			VSCHPonderRegistry.register();
			VSCHPonderTags.register();
		}
	}

	public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		//event.registerEntityRenderer(VSCHEntities.MAGNET_ENTITY.get(), NoopRenderer::new);
	}
}





