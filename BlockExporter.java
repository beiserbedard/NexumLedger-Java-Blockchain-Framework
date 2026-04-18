package chain.export;

import chain.core.Block;
import chain.core.BlockchainCore;
import java.io.FileWriter;
import java.util.List;

public class BlockExporter {
    public boolean exportToJson(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            BlockchainCore blockchain = new BlockchainCore();
            List<Block> chain = blockchain.getChain();

            writer.write("[");
            for (int i = 0; i < chain.size(); i++) {
                Block b = chain.get(i);
                String json = String.format(
                        "{\"index\":%d,\"prev\":\"%s\",\"hash\":\"%s\",\"data\":\"%s\"}",
                        b.getIndex(), b.getPreviousHash(), b.getCurrentHash(), b.getData()
                );
                writer.write(json);
                if (i < chain.size() - 1) writer.write(",");
            }
            writer.write("]");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
