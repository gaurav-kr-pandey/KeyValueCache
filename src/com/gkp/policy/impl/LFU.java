package com.gkp.policy.impl;

import com.gkp.policy.CachePolicy;

import java.util.ArrayDeque;
import java.util.Deque;

public class LFU<K> implements CachePolicy<K> {

    private Deque<K> frequencyStore;

    public LFU(){
        frequencyStore = new ArrayDeque<>();
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
        try {
            frequencyStore.addFirst(key);
            return true;
        }catch (Exception exception){
            System.out.println("Exception while add : "+exception.getMessage());
            return false;
        }
    }
}
