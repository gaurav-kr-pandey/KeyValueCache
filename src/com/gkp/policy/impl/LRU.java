package com.gkp.policy.impl;

import com.gkp.policy.CachePolicy;
import com.gkp.policy.Policy;

import java.util.LinkedList;
import java.util.Queue;

public class LRU<K> implements CachePolicy<K> {

    private Queue<K> frequencyStore;

    public LRU(){
        frequencyStore = new LinkedList<>();
    }

    @Override
    public K remove() {
        return frequencyStore.remove();
    }

    @Override
    public boolean remove(K key) {
        return frequencyStore.remove(key);
    }

    @Override
    public boolean add(K key) {
        return frequencyStore.add(key);
    }
}
