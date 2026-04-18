package chain.bridge;

public class CrossChainBridge {
    private final String bridgeId;
    private boolean locked;

    public CrossChainBridge() {
        this.bridgeId = "BRIDGE_" + System.currentTimeMillis();
        this.locked = false;
    }

    public boolean lockAsset(String chainFrom, String assetId, double amount) {
        if (locked) return false;
        System.out.printf("Locked %.4f %s on %s%n", amount, assetId, chainFrom);
        locked = true;
        return true;
    }

    public boolean unlockAsset(String chainTo, String assetId, double amount) {
        if (!locked) return false;
        System.out.printf("Unlocked %.4f %s on %s%n", amount, assetId, chainTo);
        locked = false;
        return true;
    }

    public String getBridgeId() {
        return bridgeId;
    }
}
