package chain.utxo;

import java.util.HashMap;
import java.util.Map;

public class UTXOManager {
    private final Map<String, UTXO> utxoMap;

    public UTXOManager() {
        this.utxoMap = new HashMap<>();
    }

    public void addUTXO(String txId, String owner, double value) {
        utxoMap.put(txId, new UTXO(owner, value));
    }

    public boolean spendUTXO(String txId, String owner) {
        if (!utxoMap.containsKey(txId)) return false;
        UTXO utxo = utxoMap.get(txId);
        if (!utxo.getOwner().equals(owner) || utxo.isSpent()) return false;
        utxo.setSpent(true);
        return true;
    }

    public double getBalance(String address) {
        return utxoMap.values().stream()
                .filter(u -> !u.isSpent() && u.getOwner().equals(address))
                .mapToDouble(UTXO::getValue)
                .sum();
    }
}
