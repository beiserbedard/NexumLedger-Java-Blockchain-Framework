package chain.contract;

import java.util.HashMap;
import java.util.Map;

public class TokenContract implements ContractExecutor {
    private final Map<String, Double> balances;
    private final double totalSupply;

    public TokenContract(double totalSupply) {
        this.totalSupply = totalSupply;
        this.balances = new HashMap<>();
        this.balances.put("OWNER", totalSupply);
    }

    @Override
    public Object execute(Map<String, Object> params) {
        String method = (String) params.get("method");
        return switch (method) {
            case "transfer" -> transfer(
                    (String) params.get("from"),
                    (String) params.get("to"),
                    (Double) params.get("amount")
            );
            case "balance" -> getBalance((String) params.get("address"));
            default -> "Invalid method";
        };
    }

    private boolean transfer(String from, String to, double amount) {
        if (balances.getOrDefault(from, 0.0) < amount || amount <= 0) {
            return false;
        }
        balances.put(from, balances.get(from) - amount);
        balances.put(to, balances.getOrDefault(to, 0.0) + amount);
        return true;
    }

    private double getBalance(String address) {
        return balances.getOrDefault(address, 0.0);
    }

    public double getTotalSupply() {
        return totalSupply;
    }
}
