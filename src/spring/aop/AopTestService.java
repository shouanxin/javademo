/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/23 14:37.
 */

package spring.aop;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/23
 */
public class AopTestService {

    /**
     * 功能描述: 〈除法〉.
     *
     * @param a
     * @param b
     * @return  int
     * @author shouanxin
     * @date  2019/11/23 14:38
     */
    public int div(int a, int b) {
        System.out.println("执行除法");
        return a / b;
    }
}
