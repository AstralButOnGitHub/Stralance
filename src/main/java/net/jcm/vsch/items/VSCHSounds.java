package net.jcm.vsch.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VSCHSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY;
    public static final RegistryObject<SoundEvent> WRENCH;

    public VSCHSounds() {
    }

    static {
        REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "vsch");

        WRENCH = REGISTRY.register("wrench", () -> {
            return SoundEvent.createVariableRangeEvent(new ResourceLocation("vsch", "wrench"));
        });

    }
}
