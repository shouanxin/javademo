/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/2/17 16:40.
 */

package enums;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2020/2/17
 */
public enum OrderCommentFlagBinEnum {
    OLD_OR_NEW_COMMENT(LimitFlag.ZERO.ordinal(), "新老评价（区分评价1.0，评价2.0）"),
    DITRIBUTION_COMMENT_TYPE(LimitFlag.ONE.ordinal(), "配送服务评价类型（满意或者不满意）"),
    ;

    /** 位置，第几段 已经使用的请不要再使用 .*/
    private Integer position;

    /** 描述 .*/
    private String desc;

    OrderCommentFlagBinEnum(Integer position, String desc) {
        this.position = position;
        this.desc = desc;
    }

    public Integer getPosition() {
        return position;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "OrderCommentFlagBinEnum{" +
                "position=" + position +
                ", desc='" + desc + '\'' +
                "} " + super.toString();
    }

    public enum LimitFlag{
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
    }
}
