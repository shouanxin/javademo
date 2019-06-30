/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/4 13:17.
 */

package excel;

import Utils.ExcelUtils;
import bean.PostCommentRequest;

import java.util.List;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/5/4
 */
public class CommentMQ {
    public static String path = "/Users/kotobukiyasushin/Desktop/as-order.xlsx";
    public static void main(String[] args){
        byte [] dataByte = ExcelUtils.File2byte(path);
        List<PostCommentRequest> postCommentRequests = ExcelUtils.excelToBean(dataByte);

        System.out.println(postCommentRequests);
    }
}
