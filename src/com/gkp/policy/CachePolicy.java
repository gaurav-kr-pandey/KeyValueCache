package com.gkp.policy;

public interface CachePolicy<K> {
    K remove();
    boolean remove(K key);
    boolean add(K key);
}
