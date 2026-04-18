package chain.config;

public class NodeConfiguration {
    private final String nodeId;
    private final int port;
    private final boolean miningEnabled;
    private final int syncInterval;
    private final String networkVersion;

    public NodeConfiguration(String nodeId, int port, boolean miningEnabled, int syncInterval) {
        this.nodeId = nodeId;
        this.port = port;
        this.miningEnabled = miningEnabled;
        this.syncInterval = syncInterval;
        this.networkVersion = "CHAIN_V1.0.0";
    }

    public static NodeConfiguration defaultConfig() {
        return new NodeConfiguration(
                "NODE_" + System.currentTimeMillis(),
                8090,
                true,
                30
        );
    }

    public String getNodeId() {
        return nodeId;
    }

    public int getPort() {
        return port;
    }

    public boolean isMiningEnabled() {
        return miningEnabled;
    }

    public int getSyncInterval() {
        return syncInterval;
    }

    public String getNetworkVersion() {
        return networkVersion;
    }
}
