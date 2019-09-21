package cache;

import org.junit.Test;

/**
 * 〈测试类〉.
 *
 * @author: shouanxin
 * @date: 2019/9/21
 */
public class LinkedListLruCacheTest {

    @Test
    public void get() {
        LRUCache<String, String> lruCache = this.init();
        System.out.println(lruCache.get("3"));
        System.out.println(lruCache.toString());
    }

    @Test
    public void put() {
        LRUCache<String, String> lruCache = this.init();
        lruCache.put("5", "5");
        System.out.println(lruCache.toString());
        System.out.println("====================");
        lruCache.put("6", "6");
        System.out.println(lruCache.toString());
    }

    private LRUCache<String, String> init() {
        LRUCache<String, String> lruCache = new LinkedListLruCache<>(4);

        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        //lruCache.put("4", "4");
        return lruCache;
    }
}
