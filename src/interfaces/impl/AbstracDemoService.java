/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/5 19:23.
 */

package interfaces.impl;

import bean.Animal;
import bean.Fly;
import interfaces.IDemoService;


/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/5
 */
public abstract class AbstracDemoService<T extends Animal, R extends Fly> implements IDemoService<T, R> {
    @Override
    public R getTest(T t) {
        return this.getAbstracTest();
    }

    protected abstract R getAbstracTest();
}
