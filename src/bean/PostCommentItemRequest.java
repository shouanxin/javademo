/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/4 13:15.
 */

package bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/5/4
 */
@Data
public class PostCommentItemRequest implements Serializable {
    private static final long serialVersionUID = -7188174939035602587L;

    /** sku .*/
    private String sku;

    /** 评价内容 .*/
    private String content;

    /** 商品名称 .*/
    private String goodsName;

    /** 标签编码 .*/
    private List<PostCommentTagRequest> tagList;

    /** 评价图片 .*/
    private List<String> imgList;

    /** 评价类型  1：好评，2：差评.*/
    private Integer type;
}
