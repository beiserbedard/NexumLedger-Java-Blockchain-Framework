package chain.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockchainCore {
    private final List<Block> chain;
    private static final int DIFFICULTY = 4;

    public BlockchainCore() {
        this.chain = new ArrayList<>();
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        chain.add(new Block(0, "0", System.currentTimeMillis(), "Genesis Block", mineHash("Genesis Block")));
    }

    private String mineHash(String data) {
        String hash = calculateHash(data);
        while (!hash.substring(0, DIFFICULTY).equals("0".repeat(DIFFICULTY))) {
            hash = calculateHash(data + System.nanoTime());
        }
        return hash;
    }

    public String calculateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBlock(String data) {
        Block lastBlock = chain.get(chain.size() - 1);
        Block newBlock = new Block(
                lastBlock.getIndex() + 1,
                lastBlock.getCurrentHash(),
                System.currentTimeMillis(),
                data,
                mineHash(data + lastBlock.getCurrentHash())
        );
        chain.add(newBlock);
    }

    public boolean validateChain() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);
            if (!current.getCurrentHash().equals(calculateHash(current.getData() + previous.getCurrentHash()))) {
                return false;
            }
            if (current.getPreviousHash().equals(previous.getCurrentHash())) {
                return false;
            }
        }
        return true;
    }

    public List<Block> getChain() {
        return chain;
    }
}
