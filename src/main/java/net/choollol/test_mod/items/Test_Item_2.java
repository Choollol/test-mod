package net.choollol.test_mod.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class Test_Item_2 extends SwordItem {


    public Test_Item_2(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (!level.isClientSide){
            if (clickedBlock == Blocks.GRASS_BLOCK){
                level.setBlockAndUpdate(context.getClickedPos(), Blocks.STONE.defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                        player -> player.broadcastBreakEvent(player.getUsedItemHand()));
                level.playSound(null, context.getClickedPos(), SoundEvents.BAMBOO_FALL, SoundSource.BLOCKS);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
}
