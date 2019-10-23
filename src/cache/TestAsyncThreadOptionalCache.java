/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/10/13 21:27.
 */

package cache;

import com.google.common.base.Optional;
import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * 〈测试多线程情况〉.
 *
 * @author: shouanxin
 * @date: 2019/10/13
 */
@Slf4j
public class TestAsyncThreadOptionalCache {
    private volatile static ExecutorService executor =
            new ThreadPoolExecutor(
                    200,
                    10000 ,
                    30,
                    TimeUnit.SECONDS,
                    new SynchronousQueue<>());

    public static CacheLoader<String, Optional<String>> asyncReloading = CacheLoader.asyncReloading(
            new CacheLoader<String, Optional<String>>() {
                @Override
                public Optional<String> load(String key) throws Exception {
                    log.info("{} begin to mock query db...", Thread.currentThread().getName());
                    Thread.sleep(500);
                    log.info("{} success to mock query db...", Thread.currentThread().getName());
                    if ("null".equals(key)) {
                        return Optional.fromNullable(null);
                    } else {
                        String uuId = UUID.randomUUID().toString();
                        return Optional.fromNullable(uuId);
                    }

                }
            }, executor);

    /** 模拟耗时 */
    private static Callable<String> callable = () -> {
        log.info("{} begin to mock query db...", Thread.currentThread().getName());
        Thread.sleep(500);
        log.info("{} success to mock query db...", Thread.currentThread().getName());
        return UUID.randomUUID().toString();
    };

    /** 1s过期 .*/
    private static LoadingCache<String, Optional<String>> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.SECONDS)
            .build(asyncReloading);

    public static void main(String[] args) throws Exception {
        // 手动添加一条缓存数据,睡眠1.5s让其过期
        cache.put("name", Optional.fromNullable(null));
        Thread.sleep(500);

        for (int i = 0; i < 100; i++) {
            startThread(i);
        }
        while (true) {
            ;
        }
//        Optional<String> aNull = cache.get("null");
//        System.out.println(aNull.orNull());
    }

    /**
     * 功能描述: 〈线程执行〉.
     *
     * @param id
     * @return  void
     * @author shouanxin
     * @date  2019/10/13 21:36
     */
    private static void startThread(int id) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                log.info("{}...begin" , Thread.currentThread().getName());
                Stopwatch watch = Stopwatch.createStarted();
                String name = cache.get("name").orNull();
                watch.stop();
                log.info("{}...finish, value={},  cost time={}",Thread.currentThread().getName() , name, watch.elapsed(TimeUnit.MILLISECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t.setName("Thread-" + id);
        t.start();
        Thread.sleep(20);
    }
}
