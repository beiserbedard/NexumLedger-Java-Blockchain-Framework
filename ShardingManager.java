package chain.shard;

import java.util.HashMap;
import java.util.Map;

public class ShardingManager {
    private final Map<Integer, Shard> shardMap;
    private int nextShardId;

    public ShardingManager() {
        this.shardMap = new HashMap<>();
        this.nextShardId = 1;
    }

    public int createShard(String name) {
        Shard shard = new Shard(nextShardId, name);
        shardMap.put(nextShardId, shard);
        return nextShardId++;
    }

    public Shard getShard(int shardId) {
        return shardMap.get(shardId);
    }

    public int getTotalShards() {
        return shardMap.size();
    }
}
