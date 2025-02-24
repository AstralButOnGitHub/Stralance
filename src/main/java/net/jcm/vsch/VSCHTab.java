package net.jcm.vsch;

import net.jcm.vsch.blocks.VSCHBlockz;
import net.jcm.vsch.items.VSCHItems;
import net.lointain.cosmos.init.CosmosModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VSCHTab {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VSCHMod.MODID);
	public static final RegistryObject<CreativeModeTab> TAB = REGISTRY.register("starlance",
			() -> CreativeModeTab.builder().title(Component.translatable("vsch.itemtab")).icon(() -> new ItemStack(VSCHBlockz.THRUSTER_BLOCK.get())).displayItems((parameters, tabData) -> {



				tabData.accept(VSCHBlockz.AIR_THRUSTER_BLOCK.get().asItem());
				tabData.accept(VSCHBlockz.THRUSTER_BLOCK.get().asItem());
				tabData.accept(VSCHBlockz.POWERFUL_THRUSTER_BLOCK.get().asItem());

				tabData.accept(VSCHBlockz.DRAG_INDUCER_BLOCK.get().asItem());
				tabData.accept(VSCHBlockz.GRAVITY_INDUCER_BLOCK.get().asItem());

				tabData.accept(VSCHBlockz.MAGNET_BLOCK.get().asItem());
				tabData.accept(VSCHItems.MAGNET_BOOT.get().asItem());

				tabData.accept(VSCHBlockz.VIGORITE_CASING.get().asItem());
				tabData.accept(VSCHItems.VIGORITE_ALLOY.get().asItem());
				tabData.accept(VSCHItems.WRENCH.get().asItem());
				tabData.accept(CosmosModItems.STEEL_INGOT.get().asItem());
				tabData.accept(CosmosModItems.STEEL_PLATE.get().asItem());
				tabData.accept(CosmosModItems.STEELENGINE.get().asItem());
				tabData.accept(CosmosModItems.STEEL_SPACE_NODULE.get().asItem());

			}).build());

	public static void register(IEventBus eventBus) {
		REGISTRY.register(eventBus);
	}
}
