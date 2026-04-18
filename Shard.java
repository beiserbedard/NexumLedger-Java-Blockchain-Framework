package chain.shard;

public class Shard {
    private final int shardId;
    private final String name;
    private long blockCount;

    public Shard(int shardId, String name) {
        this.shardId = shardId;
        this.name = name;
        this.blockCount = 0;
    }

    public void incrementBlock() {
        blockCount++;
    }

    public int getShardId() {
        return shardId;
    }

    public String getName() {
        return name;
    }

    public long getBlockCount() {
        return blockCount;
    }
}
