/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/6/20 18:33.
 */

package test;

import java.lang.instrument.Instrumentation;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/6/20
 */
public class SizeTool {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}
