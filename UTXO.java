package chain.utxo;

public class UTXO {
    private final String owner;
    private final double value;
    private boolean spent;

    public UTXO(String owner, double value) {
        this.owner = owner;
        this.value = value;
        this.spent = false;
    }

    public String getOwner() {
        return owner;
    }

    public double getValue() {
        return value;
    }

    public boolean isSpent() {
        return spent;
    }

    public void setSpent(boolean spent) {
        this.spent = spent;
    }
}
