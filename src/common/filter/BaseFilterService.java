/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/11/14 14:32.
 */

package common.filter;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/11/14
 */
public interface BaseFilterService<T> {
    /**
     * 功能描述: 〈过滤，不满足条件，返回true〉.
     *
     * @param condition
     * @param source
     * @return  boolean
     * @author shouanxin
     * @date  2019/11/14 14:36
     */
    boolean dissatisfyCondition(Object condition, T source);
}
