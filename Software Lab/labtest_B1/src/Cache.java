import java.util.HashMap;
import java.util.Map;

public class Cache {
    private int l1CacheSize;
    private int l2CacheSize;
    private Map<Integer, Integer> l1Cache;
    private Map<Integer, Integer> l2Cache;

    public Cache(int l1CacheSize, int l2CacheSize) {
        this.l1CacheSize = l1CacheSize;
        this.l2CacheSize = l2CacheSize;
        this.l1Cache = new HashMap<>();
        this.l2Cache = new HashMap<>();
    }

    public void addToCache(int memoryLocation, int content) {
        if (l1Cache.size() < l1CacheSize) {
            l1Cache.put(memoryLocation, content);
        } else if (l2Cache.size() < l2CacheSize) {
            l2Cache.put(memoryLocation, content);
        }
        // If both caches are full, replacement policies can be implemented here
    }

    public Integer getFromCache(int memoryLocation) {
        if (l1Cache.containsKey(memoryLocation)) {
            return l1Cache.get(memoryLocation);
        } else if (l2Cache.containsKey(memoryLocation)) {
            return l2Cache.get(memoryLocation);
        }
        return null; // Not found in cache
    }
}
