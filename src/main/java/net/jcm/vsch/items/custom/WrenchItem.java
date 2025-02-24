package net.jcm.vsch.items.custom;

import net.jcm.vsch.blocks.custom.template.AbstractThrusterBlock;
import net.jcm.vsch.blocks.entity.template.AbstractThrusterBlockEntity;
import net.jcm.vsch.items.VSCHSounds;
import net.jcm.vsch.ship.ThrusterData;
import net.lointain.cosmos.init.CosmosModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class WrenchItem extends Item {

	public WrenchItem(Properties pProperties) {
		super((new Item.Properties()).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (!isSelected) {
			return;
		}

		if (!(entity instanceof Player player)) {
			return;
		}

		// Perform a ray trace (with a range of 5 blocks)
		HitResult hitResult = entity.pick(5.0, 0.0F, false);

		// Check if the ray trace hit a block
		if (hitResult.getType() == HitResult.Type.BLOCK) {
			BlockHitResult blockHit = (BlockHitResult) hitResult;
			BlockPos blockPos = blockHit.getBlockPos();
			BlockState blockState = level.getBlockState(blockPos);

			if (VSGameUtilsKt.isBlockInShipyard(level, blockPos)) {
				// If the block has a thruster mode property
				if (blockState.hasProperty(AbstractThrusterBlock.MODE)) {
					// Display actionbar message
					player.displayClientMessage(Component.translatable("vsch.message.mode")
							.append(Component.translatable("vsch." + blockState.getValue(AbstractThrusterBlock.MODE).toString().toLowerCase())), true);
				}
			}
		}
	}

}
