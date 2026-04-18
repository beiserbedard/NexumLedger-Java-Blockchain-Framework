package chain.genesis;

import chain.core.Block;
import chain.core.BlockchainCore;

public class GenesisBlockGenerator {
    public static Block createCustomGenesis(String data) {
        BlockchainCore temp = new BlockchainCore();
        Block original = temp.getChain().get(0);
        return new Block(
                0,
                "0",
                System.currentTimeMillis(),
                data,
                temp.calculateHash(data)
        );
    }

    public static boolean isGenesisValid(Block block) {
        return block.getIndex() == 0 && block.getPreviousHash().equals("0");
    }
}
