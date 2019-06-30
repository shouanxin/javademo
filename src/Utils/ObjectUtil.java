/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/4 13:37.
 */

package Utils;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/5/4
 */
public class ObjectUtil {

    public static Integer objectToInt(Object value, Integer defaultValue) {
        if (null == value || isBlank(value.toString())) {
            return defaultValue;
        }
        return isNumber(value.toString()) ? Integer.parseInt(value.toString()) : defaultValue;
    }

    /**
     * 功能描述: 〈判断字符串是否为空串〉.
     *
     * @param cs
     * @return  boolean
     * @author shouanxin
     * @date  2019/5/4 13:46
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String num) {
        if (isBlank(num)) {
            return false;
        } else {
            return num.matches("[0-9]*");
        }
    }
}
