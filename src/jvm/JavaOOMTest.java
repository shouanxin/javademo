/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/4/20 21:40.
 */

package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/4/20
 */
public class JavaOOMTest {
    public static void main(String[] args){
        List<JavaOOMTest> list = new ArrayList<>();
        int i = 0;
        while (true) {
            System.out.println(i++);
            list.add(new JavaOOMTest());
        }
    }
}
