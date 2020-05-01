/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/5 19:18.
 */

package interfaces;

import bean.Animal;
import bean.Fly;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/5
 */
public interface IDemoService<T extends Animal, R extends Fly> {
    R getTest(T t);
}
