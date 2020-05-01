/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/4/27 22:09.
 */

package thread;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2020/4/27
 */
public class ThreadModel {
    public static void main(String[] args){
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
