package net.jcm.vsch.config;

import net.jcm.vsch.ship.ThrusterData.ThrusterMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VSCHConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> THRUSTER_TOGGLE;
	public static final ForgeConfigSpec.ConfigValue<ThrusterMode> THRUSTER_MODE;
	public static final ForgeConfigSpec.ConfigValue<Number> THRUSTER_STRENGTH;
	public static final ForgeConfigSpec.ConfigValue<Number> AIR_THRUSTER_STRENGTH;
	public static final ForgeConfigSpec.ConfigValue<Number> POWERFUL_THRUSTER_STRENGTH;

	public static final ForgeConfigSpec.ConfigValue<Number> MAX_DRAG;

	public static final ForgeConfigSpec.ConfigValue<Boolean> LIMIT_SPEED;
	public static final ForgeConfigSpec.ConfigValue<Number> MAX_SPEED;

	public static final ForgeConfigSpec.ConfigValue<Boolean> CANCEL_ASSEMBLY;

	public static final ForgeConfigSpec.ConfigValue<Boolean> WRENCH_SOUND;
	public static final ForgeConfigSpec.ConfigValue<Boolean> WRENCH_MESSAGE;

	public static final ForgeConfigSpec.ConfigValue<Number> MAGNET_BOOT_DISTANCE;
	public static final ForgeConfigSpec.ConfigValue<Number> MAGNET_BOOT_MAX_FORCE;
	public static final ForgeConfigSpec.ConfigValue<Number> GRAVITY_DISTANCE;
	public static final ForgeConfigSpec.ConfigValue<Number> GRAVITY_MAX_FORCE;

	static {
		BUILDER.push("Thrusters");

		THRUSTER_TOGGLE = BUILDER.comment("Thruster Mode Toggling").define("thruster_mode_toggle", true);
		THRUSTER_MODE = BUILDER.comment("Default Thruster Mode").defineEnum("thruster_default_mode", ThrusterMode.POSITION);

		AIR_THRUSTER_STRENGTH = BUILDER.comment("Air thruster max force. (Newtons)").define("air_thruster_strength", 7500);
		THRUSTER_STRENGTH = BUILDER.comment("Thruster max force. (Newtons)").define("thruster_strength", 64000);
		POWERFUL_THRUSTER_STRENGTH = BUILDER.comment("Powerful thruster max force. (Newtons)").define("powerful_thruster_strength", 128000);

		BUILDER.pop();

		BUILDER.push("Misc");

		MAX_DRAG = BUILDER.comment("Max force the drag inducer can use to slow down").define("max_drag", 15000);
		LIMIT_SPEED = BUILDER.comment("Limit speed thrusters can accelerate to. Recommended, as VS ships get funky at high speeds").define("limit_speed", true);
		MAX_SPEED = BUILDER.comment("Max speed to limit to. Blocks/tick I think. Default is highly recommended").define("max_speed", 150);
		CANCEL_ASSEMBLY = BUILDER.comment("Cancel multi-block assemblies when above world height. This is a temporary fix, but for now ships made above world height have issues with starlance.").define("cancel_assembly", true);
		WRENCH_SOUND = BUILDER.comment("Plays a sound when used.").define("wrench_sound", false);
		WRENCH_MESSAGE = BUILDER.comment("Sends a message to tell you what mode you've selected.").define("wrench_message", true);

		MAGNET_BOOT_DISTANCE = BUILDER.comment("Distance (in blocks) at which magnet boots will pull you in").define("magnet_boot_distance", 6);
		MAGNET_BOOT_MAX_FORCE = BUILDER.comment("Max acceleration magnet boots will apply at close distances to move the player downwards.").define("magnet_boot_max_force", 0.09);
		GRAVITY_DISTANCE = BUILDER.comment("Distance (in blocks) at which gravity generator will pull you in").define("gravity_gen_distance", 6);
		GRAVITY_MAX_FORCE = BUILDER.comment("Max acceleration gravity generator will apply at close distances to move the player downwards.").define("gravity_gen_max_force", 0.09);

		BUILDER.pop();

		SPEC = BUILDER.build();
	}
	public static void register(ModLoadingContext context){
		context.registerConfig(ModConfig.Type.SERVER, VSCHConfig.SPEC, "vsch-config.toml");
	}
}
