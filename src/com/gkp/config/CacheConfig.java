package com.gkp.config;

import com.gkp.policy.CachePolicy;
import com.gkp.policy.impl.LRU;

import java.util.HashMap;
import java.util.Map;

public final class CacheConfig<K,V> {

    private final int capacity;
    private final CachePolicy<K> cachePolicy;
    private final Map<K,V> cacheStore;

    public CacheConfig(int capacity, CachePolicy<K> cachePolicy) {
        this.capacity = capacity;
        this.cachePolicy = cachePolicy;
        this.cacheStore = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<K, V> getCacheStore() {
        return cacheStore;
    }

    public CachePolicy<K> getCachePolicy() {
        return cachePolicy;
    }
}
