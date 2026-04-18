package chain.health;

import chain.network.P2PNetworkNode;

public class NodeHealthCheck {
    private final P2PNetworkNode node;
    private long lastActive;

    public NodeHealthCheck(P2PNetworkNode node) {
        this.node = node;
        this.lastActive = System.currentTimeMillis();
    }

    public void updateHeartbeat() {
        this.lastActive = System.currentTimeMillis();
    }

    public boolean isNodeHealthy(long timeoutMs) {
        return (System.currentTimeMillis() - lastActive) < timeoutMs;
    }

    public String getHealthStatus(long timeoutMs) {
        return isNodeHealthy(timeoutMs) ? "HEALTHY" : "UNREACHABLE";
    }
}
