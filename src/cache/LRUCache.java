/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/9/21 14:25.
 */

package cache;

/**
 * 〈LRU cache〉.
 *
 * @author: shouanxin
 * @date: 2019/9/21
 */
public interface LRUCache<K, V> {

    /**
     * 功能描述: 〈获取数据〉.
     *
     * @param k
     * @return  V
     * @author shouanxin
     * @date  2019/9/21 14:47
     */
    V get(K k);

    /**
     * 功能描述: 〈存放数据〉.
     *
     * @param k
     * @param v
     * @return  void
     * @author shouanxin
     * @date  2019/9/21 14:47
     */
    void put(K k, V v);

    /**
     * 功能描述: 〈获取限制长度〉.
     *
     * @return  java.lang.Integer
     * @author shouanxin
     * @date  2019/9/21 14:47
     */
    Integer limit();

    /**
     * 功能描述: 〈移除元素〉.
     *
     * @param k
     * @return  java.lang.Boolean
     * @author shouanxin
     * @date  2019/9/21 14:47
     */
    Boolean remove(K k);

    /**
     * 功能描述: 〈清空缓存〉.
     *
     * @return  void
     * @author shouanxin
     * @date  2019/9/21 14:48
     */
    void clear();
}
