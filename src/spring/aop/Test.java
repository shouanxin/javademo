/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/23 14:48.
 */

package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/23
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CustomerConfig.class);
        AopTestService aopTestService = applicationContext.getBean(AopTestService.class);
        aopTestService.div(10, 2);
        System.out.println("false == "+ Boolean.TRUE.equals(null));
    }
}
