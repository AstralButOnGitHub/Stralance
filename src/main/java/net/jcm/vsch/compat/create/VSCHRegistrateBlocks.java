package net.jcm.vsch.compat.create;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.jcm.vsch.VSCHMod;
import net.jcm.vsch.blocks.VSCHBlockz;
import net.minecraft.world.level.block.Block;

// Because create only seems to take Registrate block registry object thingys, we have to re-register some of our blocks for the ponder stuff
public class VSCHRegistrateBlocks {
    public static final Registrate REGISTRATE = Registrate.create(VSCHMod.MODID);

    public static final BlockEntry<Block> THRUSTER_BLOCK = REGISTRATE.block("thruster_block", properties -> VSCHBlockz.THRUSTER_BLOCK.get())
            .register();

    public static final BlockEntry<Block> AIR_THRUSTER_BLOCK = REGISTRATE.block("air_thruster_block", properties -> VSCHBlockz.AIR_THRUSTER_BLOCK.get())
            .register();

    public static final BlockEntry<Block> POWERFUL_THRUSTER_BLOCK = REGISTRATE.block("powerful_thruster_block", properties -> VSCHBlockz.POWERFUL_THRUSTER_BLOCK.get())
            .register();

    public static final BlockEntry<Block> DRAG_INDUCER_BLOCK = REGISTRATE.block("drag_inducer_block", properties -> VSCHBlockz.DRAG_INDUCER_BLOCK.get())
            .register();

    /**
     * Doesn't do anything, but makes sure this class is loaded
     */
    public static void register() {

    }
}
