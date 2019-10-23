/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/6/18 16:57.
 */

package test;

import bean.Animal;
import bean.Dog;
import com.google.common.collect.Lists;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/6/18
 */
public class Test1 {

    @Test
    public void testDog() {
        Person p = new Person();
        Animal animal = new Dog("go1", "eat1");
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Person());
        }

        System.out.println(RamUsageEstimator.sizeOf(1));
    }

    class People{
        int age = 20;
        String name = "Xiaoming";
    }
    class Person extends People{
        boolean married = false;
        long birthday = 12323434L;
        char tag = 'c';
        double sallary = 123.2d;
    }

    @Test
    public void testFilter() {
        String str = "aaa";
        List<String> list = Lists.newArrayList();
        list.add("abcd");
        list.add("ABCD");
        list.add("aaa");

        List<String> collect = list.stream().filter(p -> p.equals(str)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("sku1", "sku1");
        map.put("sku2", "sku2");

        Map<String, Set<String>> setMap = new HashMap<>();
        Set<String> stringSet = new HashSet<>();
        stringSet.add(map.get("sku1"));
        stringSet.add(map.get("sku2"));
        setMap.put("a", stringSet);
        System.out.println(setMap);
    }
}
