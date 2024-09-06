package net.choollol.test_mod.blocks.custom;

import net.choollol.test_mod.TM;
import net.choollol.test_mod.blocks.blockentities.TestBarrelBlockEntity;
import net.choollol.test_mod.menus.TestBarrelMenu;
import net.choollol.test_mod.util.ModUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class TestBarrel extends Block implements EntityBlock {
    public TestBarrel(Properties p_49795_) {
        super(p_49795_);
    }

    private TestBarrelBlockEntity blockEntity;

    @Override
    public @Nullable TestBarrelBlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        blockEntity = new TestBarrelBlockEntity(pPos, pState);
        return blockEntity;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide()){
            return InteractionResult.SUCCESS;
        }
        pPlayer.openMenu(TestBarrelMenu.getServerMenuProvider(blockEntity, pPos));
        return InteractionResult.CONSUME;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock() && pLevel.getBlockEntity(pPos) instanceof TestBarrelBlockEntity){
            ((TestBarrelBlockEntity)pLevel.getBlockEntity(pPos)).drops();
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }
}
