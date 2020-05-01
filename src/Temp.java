/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/30 10:45.
 */

import com.google.common.collect.Lists;
import enums.OrderCommentFlagBinEnum;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/5/30
 */
public class Temp {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        int c = 20;
//        int n = c - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        System.out.println(n);
//        String encryptedAesKey = "qMBXzXWxnJPI5wkjdkvBr7YZHinCkaS%2Bb%2FcWu9kgi5iUt3nkcK9dKxRWP%2BtaWC41iaM0C37R2Gea7kh%2F4Bldq7bKR%2FTtH%2B5BZ%2BuWTYYNZ1hb3Qq%2F07TUu0Erm9v7PgPjZsJbD0k8p9sUJ8jiapsVbHceUoT10BdqUylXYF68KpY%3D";
//        //encryptedAesKey = URLEncoder.encode(encryptedAesKey, "UTF-8");
//        String temp = decodeStr(encryptedAesKey);
//        System.out.println("原：" + encryptedAesKey);
//        System.out.println("新：" + temp);
//        int i = 0;
////        List<String> aList = Lists.newArrayListWithCapacity(9);
////        aList.add("12");
////        aList.add("12");
////        aList.add("12");
////        aList.add("123");
////        List<String> collect = aList.stream().filter(c -> !"12".equals(c)).map(c -> c + "h").collect(Collectors.toList());
////        System.out.println(collect.size());

        int flag = calculateFlag(1, 0, OrderCommentFlagBinEnum.OLD_OR_NEW_COMMENT);
        System.out.println(flag);
        flag = calculateFlag(3 , flag, OrderCommentFlagBinEnum.DITRIBUTION_COMMENT_TYPE);
        System.out.println(flag);
    }

    public static String decodeStr(String s) {
        try {
            String temp = URLDecoder.decode(s, "UTF-8");
            while (!s.equals(temp)) {
                s = temp;
                temp = URLDecoder.decode(s, "UTF-8");
            }
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static int calculateFlag(int currentValue, Integer oldFlagBin, OrderCommentFlagBinEnum flagBinEnum) {
        if (currentValue <= 0) {
            return oldFlagBin;
        }

        Integer position = flagBinEnum.getPosition();
        if (null == position || OrderCommentFlagBinEnum.LimitFlag.ZERO.ordinal() == position) {
            return oldFlagBin | currentValue;
        }

        // 移动位数
        int moveNum = position * 3;
        currentValue <<= moveNum;
        return oldFlagBin | currentValue;
    }
}
