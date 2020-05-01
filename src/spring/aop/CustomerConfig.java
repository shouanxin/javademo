/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/23 14:36.
 */

package spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/23
 */
@Configuration
@EnableAspectJAutoProxy
public class CustomerConfig {

    @Bean
    public AopTestService aopTestService() {
        return new AopTestService();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
