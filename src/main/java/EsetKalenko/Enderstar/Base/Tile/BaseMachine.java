package EsetKalenko.Enderstar.Base.Tile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public abstract class BaseMachine extends BlockEntity {
    public BaseMachine(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public void serverTick() {

    }

    @OnlyIn(Dist.CLIENT)
    public void clientTick() {

    }
}
