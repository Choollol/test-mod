package net.choollol.test_mod.blocks.custom;

import net.choollol.test_mod.blocks.blockentities.TestBarrelEntity;
import net.choollol.test_mod.menus.ModMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class TestBarrel extends Block implements EntityBlock {
    public TestBarrel(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public @Nullable TestBarrelEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TestBarrelEntity(pPos, pState);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide()){
            return InteractionResult.SUCCESS;
        }
        pPlayer.openMenu(newBlockEntity(pPos, pState));
        return InteractionResult.CONSUME;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock() && pLevel.getBlockEntity(pPos) instanceof TestBarrelEntity){
            ((TestBarrelEntity)pLevel.getBlockEntity(pPos)).drops();
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }
}
