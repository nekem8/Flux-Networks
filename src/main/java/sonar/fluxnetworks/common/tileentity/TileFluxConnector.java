package sonar.fluxnetworks.common.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import sonar.fluxnetworks.common.block.FluxConnectorBlock;
import sonar.fluxnetworks.common.handler.TileEntityHandler;
import sonar.fluxnetworks.common.tileentity.energy.TileDefaultEnergy;

public abstract class TileFluxConnector extends TileDefaultEnergy {

    public TileFluxConnector(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Override
    public void updateTransfers(Direction... dirs) {
        super.updateTransfers(dirs);
        boolean sendUpdate = false;
        for (Direction facing : dirs) {
            //noinspection ConstantConditions
            TileEntity tile = world.getTileEntity(pos.offset(facing));
            boolean before = (connections >> facing.getIndex()) != 0;
            boolean current = TileEntityHandler.canRenderConnection(tile, facing.getOpposite());
            if (before != current) {
                connections ^= 1 << facing.getIndex();
                sendUpdate = true;
            }
        }
        if (sendUpdate) {
            sendFullUpdatePacket();
        }
    }

    @Override
    public void sendFullUpdatePacket() {
        //noinspection ConstantConditions
        if (!world.isRemote) {
            BlockState newState = FluxConnectorBlock.getConnectedState(getBlockState(), getFluxWorld(), getPos());
            world.setBlockState(pos, newState, 3);
            world.notifyBlockUpdate(pos, getBlockState(), newState, 3);
        }
    }

    /* TODO - FIX ONE PROBE "IBIGPOWER"
    @Override
    @Optional.Method(modid = "theoneprobe")
    public long getStoredPower(){
        return getBuffer();
    }

    @Override
    @Optional.Method(modid = "theoneprobe")
    public long getCapacity(){
        return getBuffer();
    }
    */
}
