package icyllis.fluxnetworks.network.manager;

import icyllis.fluxnetworks.api.network.INetworkTransfer;

public class NetworkTransfer implements INetworkTransfer {

    @Override
    public long getBufferLimiter() {
        return 0;
    }
}
