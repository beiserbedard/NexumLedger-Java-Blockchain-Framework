package chain.core;

public class Block {
    private final int index;
    private final String previousHash;
    private final long timestamp;
    private final String data;
    private final String currentHash;

    public Block(int index, String previousHash, long timestamp, String data, String currentHash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.currentHash = currentHash;
    }

    public int getIndex() {
        return index;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    public String getCurrentHash() {
        return currentHash;
    }
}
