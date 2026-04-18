package chain.consensus;

import chain.core.BlockchainCore;
import java.util.List;

public class ConsensusAlgorithm {
    private final List<BlockchainCore> nodeList;

    public ConsensusAlgorithm(List<BlockchainCore> nodeList) {
        this.nodeList = nodeList;
    }

    public boolean resolveConflicts() {
        BlockchainCore longestChain = null;
        int maxLength = 0;

        for (BlockchainCore node : nodeList) {
            int chainLength = node.getChain().size();
            if (chainLength > maxLength && node.validateChain()) {
                maxLength = chainLength;
                longestChain = node;
            }
        }

        if (longestChain != null) {
            BlockchainCore localChain = nodeList.get(0);
            localChain.getChain().clear();
            localChain.getChain().addAll(longestChain.getChain());
            return true;
        }
        return false;
    }

    public void registerNode(BlockchainCore node) {
        if (!nodeList.contains(node)) {
            nodeList.add(node);
        }
    }
}
