/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/6/18 16:56.
 */

package bean;

import lombok.Data;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/6/18
 */
@Data
public class Dog extends Animal{
    private String go;

    public Dog(String go, String eat) {
        this.setGo(go);
        this.setEat(eat);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "go='" + go + '\'' +
                "} " + super.toString();
    }
}
