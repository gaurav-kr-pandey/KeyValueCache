package com.gkp;

import com.gkp.config.CacheConfig;
import com.gkp.policy.CachePolicy;
import com.gkp.policy.impl.LRU;

import java.util.*;

public class Cache<K,V> {

    private static final int DEFAULT_CAPACITY = 10;
    private CacheConfig<K,V> cacheConfig;
    private int capacity;

    public Cache(){
        cacheConfig = new CacheConfig<>(DEFAULT_CAPACITY,new LRU<>());
    }

    public Cache(CacheConfig<K,V> cacheConfig){
        this.cacheConfig = cacheConfig;
    }

    public void put(K key, V value){
        if(capacity==cacheConfig.getCapacity()) {
            System.out.println("Cache Full : "+capacity);
            evict();
        }
        cacheConfig.getCacheStore().put(key,value);
        updateFrequency(key);
        System.out.println("Added key : "+key+", Value : "+value);
        capacity++;
    }

    public V get(K key){
        V value = cacheConfig.getCacheStore().get(key);
        updateFrequency(key);
        return value;
    }

    private void evict(){
        capacity--;
        K key = cacheConfig.getCachePolicy().remove();
        System.out.println("Evicted : "+key+", Value : "+cacheConfig.getCacheStore().get(key));
        cacheConfig.getCacheStore().remove(key);

    }

    private void updateFrequency(K key){
        cacheConfig.getCachePolicy().remove(key);
        cacheConfig.getCachePolicy().add(key);
    }

 }
