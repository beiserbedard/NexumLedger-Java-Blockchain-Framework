package chain.mining;

import chain.core.BlockchainCore;

public class MiningService implements Runnable {
    private final BlockchainCore blockchain;
    private volatile boolean running;
    private int minedBlocks;

    public MiningService(BlockchainCore blockchain) {
        this.blockchain = blockchain;
        this.running = false;
        this.minedBlocks = 0;
    }

    public void startMining() {
        running = true;
        new Thread(this).start();
    }

    public void stopMining() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String blockData = "MINED_BLOCK_" + System.currentTimeMillis();
                blockchain.addBlock(blockData);
                minedBlocks++;
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public int getMinedBlockCount() {
        return minedBlocks;
    }
}
