package chain.transaction;

public class Transaction {
    private final String sender;
    private final String recipient;
    private final double amount;
    private final String signature;
    private final long txTime;

    public Transaction(String sender, String recipient, double amount, String signature) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.signature = signature;
        this.txTime = System.currentTimeMillis();
    }

    public boolean validate() {
        return amount > 0 && sender != null && recipient != null && signature != null && !signature.isBlank();
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }

    public String getSignature() {
        return signature;
    }

    public long getTxTime() {
        return txTime;
    }
}
