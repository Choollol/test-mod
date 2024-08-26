package net.choollol.test_mod.blocks;

import net.choollol.test_mod.TMItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Test_Block_1 extends Block {

    public Test_Block_1(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer,
                                 InteractionHand pHand, BlockHitResult pHit) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.ARROW_HIT_PLAYER, SoundSource.BLOCKS);
        if (pPlayer.getItemInHand(pHand).is(TMItems.TEST_ITEM_2)) {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("hi"));
        }
        return InteractionResult.SUCCESS;
    }
}
