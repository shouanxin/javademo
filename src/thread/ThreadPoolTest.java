/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/4/28 09:31.
 */

package thread;

import java.util.concurrent.*;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2020/4/28
 */
public class ThreadPoolTest {
    public static void main(String[] args){
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 3,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5), Executors.defaultThreadFactory());

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println("hello"));
        }
    }
}
