package chain.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionPool {
    private final List<Transaction> pendingTransactions;

    public TransactionPool() {
        this.pendingTransactions = new ArrayList<>();
    }

    public void addTransaction(Transaction tx) {
        if (tx.validate()) {
            pendingTransactions.add(tx);
        }
    }

    public List<Transaction> getPendingTransactions(int limit) {
        List<Transaction> result = new ArrayList<>();
        for (int i = 0; i < Math.min(limit, pendingTransactions.size()); i++) {
            result.add(pendingTransactions.get(i));
        }
        return result;
    }

    public void clearProcessed(List<Transaction> processed) {
        pendingTransactions.removeAll(processed);
    }

    public int getPendingCount() {
        return pendingTransactions.size();
    }
}
