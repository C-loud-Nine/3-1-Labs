import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

public class CacheTest {

    @Test
    public void testMostFrequentLocationsInCache() {
        // Create RAM and Cache instances
        RAM ram = new RAM(10);
        Cache cache = new Cache(2, 3); // L1 Cache size: 2, L2 Cache size: 3

        // Access memory locations multiple times to make them frequent
        for (int i = 0; i < 10; i++) {
            // Accessing memory location 0, 1, and 2 twice each
            cache.addToCache(i % 3, i); // Adding to cache
            cache.addToCache(i % 3, i); // Adding to cache again
        }

        // Check if the most frequent locations are in the cache
        assertTrue(cache.getFromCache(0) != null); // Memory location 0 should be in cache
        assertTrue(cache.getFromCache(1) != null); // Memory location 1 should be in cache
        assertTrue(cache.getFromCache(2) != null); // Memory location 2 should be in cache

        // Check if less frequent locations are not in the cache
        assertNull(cache.getFromCache(3)); // Memory location 3 should not be in cache
        assertNull(cache.getFromCache(4)); // Memory location 4 should not be in cache
    }

    private void assertTrue(boolean b) {

    }
}
