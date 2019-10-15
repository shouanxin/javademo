/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/9/21 14:28.
 */

package cache;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 〈链表 + hashmap 实现lru〉.
 *
 * @author: shouanxin
 * @date: 2019/9/21
 */
public class LinkedListLruCache<K, V> implements LruCache<K, V> {

    /** 缓存限制长度 .*/
    private final int limit;

    /** 存放key .*/
    private final LinkedList<K> keyLinkedList = new LinkedList<>();

    /** 存放值 .*/
    private final Map<K, V> cacheMap = new HashMap<>();

    public LinkedListLruCache(int limit) {
        this.limit = limit;
    }

    @Override
    public V get(K k) {
        boolean removeFlag = keyLinkedList.remove(k);
        if (!removeFlag) {
            return null;
        }
        keyLinkedList.addFirst(k);
        return cacheMap.get(k);
    }

    @Override
    public void put(K k, V v) {
        Preconditions.checkNotNull(k, "key is null");
        Preconditions.checkNotNull(v, "value is null");

        if (keyLinkedList.size() == limit) {
            K oldKey = keyLinkedList.removeLast();
            cacheMap.remove(oldKey);
        }

        keyLinkedList.addFirst(k);
        cacheMap.put(k, v);
    }

    @Override
    public Integer limit() {
        return limit;
    }

    @Override
    public Boolean remove(K k) {
        if (!keyLinkedList.remove(k)) {
            return false;
        }
        return cacheMap.remove(k) != null;
    }

    @Override
    public void clear() {
        keyLinkedList.clear();
        cacheMap.clear();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        keyLinkedList.stream().forEach(key -> stringBuilder.append(key).append("=").append(cacheMap.get(key)).append("; "));
        return stringBuilder.toString();
    }
}
