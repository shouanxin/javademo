/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/9/21 18:34.
 */

package cache;

import bean.PostCommentItemRequest;
import com.google.common.base.Optional;
import com.google.common.cache.*;
import com.sun.tools.javac.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.StringUtil;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/9/21
 */
@Slf4j
public class LoadingCacheTest {

    private volatile static ExecutorService executor =
            new ThreadPoolExecutor(
                    200,
                    10000 ,
                    30,
                    TimeUnit.SECONDS,
                    new SynchronousQueue<>());

    @Test
    public void testBaseCache() throws Exception {
        CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                log.info("load start------------------   {}", System.nanoTime());
                // do something
                return key + 1;
            }
        };

        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3000)
                .concurrencyLevel(100)
                .refreshAfterWrite(10, TimeUnit.MILLISECONDS)
                .build(cacheLoader);

        this.initCache(cache);
        for (int i = 0; i < 3; i++) {
            String key = "hello1";
            String hello1 = cache.get(key);
            log.info("获取key={}的值={}, time={}", key, hello1, System.nanoTime());
            Thread.sleep(100);
        }
    }

    private void initCache(LoadingCache<String, String> cache) {
        for (int i = 0; i < 10; i++) {
            String str = "hello" + i;
            cache.put(str, str);
        }
    }

    @Test
    public void testResultNullCache() throws ExecutionException {
        CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                if (key.equals("null")) {
                    return null;
                }
                return key + 1;
            }
        };
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .refreshAfterWrite(30, TimeUnit.SECONDS)
                .build(cacheLoader);
        String aNull = cache.get("null");
        System.out.println(aNull);
    }

    @Test
    public void testOptionalCache() throws ExecutionException {
        CacheLoader<String,Optional<String>> cacheLoader = new CacheLoader<String, Optional<String>>() {
            @Override
            public Optional<String> load(String key) throws Exception {
                if ("null".equals(key)) {
                    return Optional.fromNullable(null);
                } else {
                    return Optional.fromNullable(key + 1);
                }
            }
        };
        LoadingCache<String, Optional<String>> cache = CacheBuilder.newBuilder().build(cacheLoader);
        Optional<String> aNull = cache.get("null");
        System.out.println(aNull.or("default"));
    }

    @Test
    public void testRecordCache() {
        CacheLoader<String,Optional<String>> cacheLoader = new CacheLoader<String, Optional<String>>() {
            @Override
            public Optional<String> load(String key) throws Exception {
                if ("null".equals(key)) {
                    return Optional.fromNullable(null);
                } else {
                    return Optional.fromNullable(key + 1);
                }
            }
        };
        LoadingCache<String, Optional<String>> cache = CacheBuilder.newBuilder().recordStats().expireAfterAccess(10, TimeUnit.MILLISECONDS).build(cacheLoader);
        Optional<String> aNull = cache.getUnchecked("nullq");
        cache.getUnchecked("nullq");
        cache.getUnchecked("nullq");
        CacheStats stats = cache.stats();
        System.out.println(stats);
    }

    @Test
    public void testStr() {
        PostCommentItemRequest postCommentItemRequest = new PostCommentItemRequest();
        postCommentItemRequest.setContent("hello");
        Integer integer = null == postCommentItemRequest.getType() && null != postCommentItemRequest.getGoodsName() ? 1 : postCommentItemRequest.getType();
        System.out.println(integer);
    }

    @Test
    public void asyncCache() throws ExecutionException {
        CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                if (key.equals("null")) {
                    return null;
                }
                return key + 1;
            }
        };
        CacheLoader<String, String> asyncReloading = CacheLoader.asyncReloading(cacheLoader, executor);
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .concurrencyLevel(100)
                .refreshAfterWrite(30, TimeUnit.SECONDS)
                .maximumSize(3000)
                .build(asyncReloading);

        String hello = cache.get("hello");
        System.out.println(hello);
    }

    @Test
    public void testAsync(){
        LoadingCache<String, String> warehouseCache = CacheBuilder.newBuilder()
                .concurrencyLevel(100)
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .maximumSize(3000)
                .build(this.buildAysncCacheLoader(this :: getCache, executor));

        //warehouseCache.put("null", "init null");

        try {
            System.out.println("exception before: " + warehouseCache.getUnchecked("null"));
            Thread.sleep(2000);
            System.out.println("exception after: " + warehouseCache.get("null"));
        } catch (Exception e) {
            log.error("exce ", e);
        }
    }

    public String getCache(String key) {
        if ("null".equals(key)) {
            throw null;
        } else {
            return key + 1;
        }
    }

    public <K, V> CacheLoader<K, V> buildAysncCacheLoader(final Function<K, V> function,
                                                                 final Executor executor) {
        return CacheLoader.asyncReloading(new CacheLoader<K, V>() {
            @Override
            public V load(K k) throws Exception {
                log.info("线程{}刷新缓存", Thread.currentThread().getId());
                try {
                    return function.apply(k);
                }finally {
                    log.info("线程{}刷新缓存结束", Thread.currentThread().getId());
                }
            }
        }, executor);
    }
}
