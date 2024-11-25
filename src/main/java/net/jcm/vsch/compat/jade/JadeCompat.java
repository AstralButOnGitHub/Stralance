package net.jcm.vsch.compat.jade;

import net.jcm.vsch.VSCHMod;
import net.jcm.vsch.blocks.custom.ThrusterBlock;
import net.jcm.vsch.compat.jade.componentproviders.ThrusterBlockComponentProvider;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeCompat implements IWailaPlugin {
    public static final ResourceLocation THRUSTER_BLOCK = new ResourceLocation(VSCHMod.MODID,"thruster_component_config");
    @Override
    public void register(IWailaCommonRegistration registration) {
        //TODO register data providers
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
       registration.registerBlockComponent(ThrusterBlockComponentProvider.INSTANCE, ThrusterBlock.class);
    }
}
