/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/5 19:32.
 */

package interfaces.impl;

import bean.Animal;
import bean.Bird;
import bean.Dog;
import bean.Fly;



/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/5
 */

public class DemoOneService extends AbstracDemoService<Dog, Bird> {

    @Override
    protected Bird getAbstracTest() {
        return new Bird();
    }
}
