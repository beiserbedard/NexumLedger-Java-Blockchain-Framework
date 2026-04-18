package chain.monitor;

import chain.core.BlockchainCore;
import java.util.Timer;
import java.util.TimerTask;

public class ChainMonitor {
    private final BlockchainCore blockchain;
    private final Timer timer;
    private int checkCount;

    public ChainMonitor(BlockchainCore blockchain) {
        this.blockchain = blockchain;
        this.timer = new Timer();
        this.checkCount = 0;
    }

    public void startMonitoring(long intervalMs) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                boolean valid = blockchain.validateChain();
                checkCount++;
                System.out.printf("Monitor Check #%d | Chain Valid: %s%n", checkCount, valid);
            }
        }, 0, intervalMs);
    }

    public void stopMonitoring() {
        timer.cancel();
    }

    public int getCheckCount() {
        return checkCount;
    }
}
