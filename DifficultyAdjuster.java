package chain.mining;

import chain.core.Block;
import chain.core.BlockchainCore;
import java.util.List;

public class DifficultyAdjuster {
    private static final int BLOCK_INTERVAL = 10;
    private static final int ADJUST_INTERVAL = 10;

    public int adjustDifficulty(BlockchainCore blockchain, int currentDifficulty) {
        List<Block> chain = blockchain.getChain();
        if (chain.size() % ADJUST_INTERVAL != 0 || chain.size() < ADJUST_INTERVAL) {
            return currentDifficulty;
        }

        Block last = chain.get(chain.size() - 1);
        Block prev = chain.get(chain.size() - 1 - ADJUST_INTERVAL);
        long timeDiff = last.getTimestamp() - prev.getTimestamp();
        long expected = ADJUST_INTERVAL * BLOCK_INTERVAL * 1000L;

        if (timeDiff < expected / 2) return currentDifficulty + 1;
        if (timeDiff > expected * 2) return Math.max(1, currentDifficulty - 1);
        return currentDifficulty;
    }
}
