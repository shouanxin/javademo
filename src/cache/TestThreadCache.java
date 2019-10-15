/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/10/13 21:27.
 */

package cache;

import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 〈测试多线程情况〉.
 *
 * @author: shouanxin
 * @date: 2019/10/13
 */
@Slf4j
public class TestThreadCache {
    /** 模拟一个需要耗时2s的数据库查询任务 */
    private static Callable<String> callable = () -> {
        log.info("{} begin to mock query db...", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("{} success to mock query db...", Thread.currentThread().getName());
        return UUID.randomUUID().toString();
    };

    /** 1s过期 .*/
    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return callable.call();
                }
            });

    public static void main(String[] args) throws Exception {
        // 手动添加一条缓存数据,睡眠1.5s让其过期
//        cache.put("name", "init-value");
//        Thread.sleep(1500);

        for (int i = 0; i < 10; i++) {
            startThread(i);
        }

    }

    /**
     * 功能描述: 〈线程执行〉.
     *
     * @param id
     * @return  void
     * @author shouanxin
     * @date  2019/10/13 21:36
     */
    private static void startThread(int id) {
        Thread t = new Thread(() -> {
            try {
                log.info("{}...begin" , Thread.currentThread().getName());
                Stopwatch watch = Stopwatch.createStarted();
                String name = cache.get("name");
                watch.stop();
                log.info("{}...finish, value={},  cost time={}",Thread.currentThread().getName() , name, watch.elapsed(TimeUnit.MILLISECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t.setName("Thread-" + id);
        t.start();
    }
}
