/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/7/28 17:50.
 */

package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/7/28
 */
public class LambdaDemo01 {
    public static void main(String[] args){
        Function<String, String> f1 = str -> str + " world";
        System.out.println(f1.apply("hello")); // hello world

        Predicate<String> p1 = str -> "hello".equals(str);
        System.out.println(p1.test("hello")); // true

        Consumer<String> c1 = str -> System.out.println(str + " biu");
        c1.accept("hello"); // hello biu

        Supplier<String> s1 = () -> "supplier demo";
        System.out.println(s1.get()); // supplier demo
    }
}
