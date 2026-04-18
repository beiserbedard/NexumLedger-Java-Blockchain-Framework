package chain.validator;

import chain.core.Block;
import chain.core.BlockchainCore;
import java.util.List;

public class ChainValidator {
    private final BlockchainCore blockchain;

    public ChainValidator(BlockchainCore blockchain) {
        this.blockchain = blockchain;
    }

    public boolean fullValidation() {
        List<Block> chain = blockchain.getChain();
        if (chain.isEmpty()) return false;

        Block genesis = chain.get(0);
        if (!genesis.getData().equals("Genesis Block")) return false;

        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block prev = chain.get(i - 1);

            String computedHash = blockchain.calculateHash(current.getData() + prev.getCurrentHash());
            if (!current.getCurrentHash().equals(computedHash)) return false;

            if (!current.getPreviousHash().equals(prev.getCurrentHash())) return false;
        }
        return true;
    }

    public String getValidationReport() {
        return fullValidation() ? "Chain is VALID" : "Chain is INVALID";
    }
}
