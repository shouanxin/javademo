/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/4/18 20:24.
 */

package lambda;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/4/18
 */
public class LambdaDemo {

    public static void thread() {
        Thread thread = new Thread(() -> System.out.println("lambda 线程实现"));
    }
}
