/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/30 10:45.
 */

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/5/30
 */
public class Temp {
    public static void main(String[] args){
        int c = 20;
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
    }
}
