package chain.wallet;

import java.util.List;

public class MultiSigWallet {
    private final List<String> owners;
    private final int requiredSignatures;

    public MultiSigWallet(List<String> owners, int requiredSignatures) {
        this.owners = owners;
        this.requiredSignatures = requiredSignatures;
    }

    public boolean validateTransaction(List<String> signers) {
        if (signers.size() < requiredSignatures) return false;
        for (String s : signers) {
            if (!owners.contains(s)) return false;
        }
        return true;
    }

    public int getRequiredSignatures() {
        return requiredSignatures;
    }

    public List<String> getOwners() {
        return owners;
    }
}
