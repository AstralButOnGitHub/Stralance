package net.jcm.vsch.items;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.jcm.vsch.items.custom.MagnetBootItem;
import net.lointain.cosmos.init.CosmosModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.jcm.vsch.VSCHMod;
import net.jcm.vsch.VSCHTab;
import net.minecraft.world.item.ArmorItem.Type;
import net.jcm.vsch.items.custom.WrenchItem;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VSCHItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, VSCHMod.MODID); //this bit does some mumbo-jumbo to set up for adding items

	public static final RegistryObject<Item> VIGORITE_ALLOY = ITEMS.register("vigorite_alloy",
			() -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> INCOMPLETE_LARGE_THRUSTER = ITEMS.register("incomplete_large_thruster",
			() -> new SequencedAssemblyItem(new Item.Properties()));

	public static final RegistryObject<Item> WRENCH = ITEMS.register("vigorite_wrench",
			() -> new WrenchItem(new Item.Properties()));

	public static final RegistryObject<Item> MAGNET_BOOT = ITEMS.register("magnet_boot",
			() -> new MagnetBootItem(ArmorMaterials.IRON, Type.BOOTS, new Item.Properties()));

	public static final RegistryObject<Item> SULPHURIC_ACID_ROLL = ITEMS.register("sulphuric_acid_roll",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder()
					.nutrition(0).saturationMod(0f)
					.alwaysEat()
					.effect(() -> new MobEffectInstance(CosmosModMobEffects.SULPHURIC_SENSATION.get(), 30, 1), 1.0f)
					.build())));




	//registering
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus); //this registers the items with the mod event bus
	}
}
