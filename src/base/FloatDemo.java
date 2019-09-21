/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/7/20 17:04.
 */

package base;

import org.junit.Test;
import sun.misc.FloatingDecimal;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/7/20
 */
public class FloatDemo {
    @Test
    public void f1() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        String s = Float.toHexString(0.9f);
        System.out.println(s);

    }
}
