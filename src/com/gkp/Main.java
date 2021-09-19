package com.gkp;

import com.gkp.config.CacheConfig;
import com.gkp.policy.impl.LFU;
import com.gkp.policy.impl.LRU;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        CacheConfig<Integer,String> cacheConfig = new CacheConfig<>(3,new LFU<>());
        Cache<Integer,String> cache = new Cache<>(cacheConfig);
        cache.put(1,"Gaurav");
        cache.put(2,"Akash");
        cache.put(3,"Ashu");
        cache.put(4,"Garima");
    }
}
