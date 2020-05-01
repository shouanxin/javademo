/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/23 14:39.
 */

package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/23
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int spring.aop.AopTestService.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinpoint) {
        System.out.println("before方法执行, " + joinpoint.getSignature().getName());
    }

    @After("pointCut()")
    public void end() {
        System.out.println("end方法执行");
    }

    @AfterReturning("pointCut()")
    public void afterReturn() {
        System.out.println("afterReturn方法执行");
    }

    @AfterThrowing("pointCut()")
    public void exception() {
        System.out.println("exception方法执行");
    }
}
