/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/4/21 18:53.
 */

package jvm;

/**
 * 〈〉.
 * 打印gc日志时，加上参数：-verbose:gc -XX:+PrintGCDetails
 * @author: shouanxin
 * @date: 2019/4/21
 */
public class GCTest {
    private Object instance;
    public GCTest() {
        byte[] m = new byte[20 * 1024 * 1024];
    }

    public static void main(String[] args){
        GCTest gcTest = new GCTest();
        GCTest gcTest1 = new GCTest();
        gcTest.instance = gcTest1;
        gcTest1.instance = gcTest;
        gcTest = null;
        gcTest1 = null;
        // 打印gc
        System.gc();
    }
}
