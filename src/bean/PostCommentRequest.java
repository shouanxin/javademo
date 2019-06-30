/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/4 13:14.
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
public class PostCommentRequest implements Serializable {
    private static final long serialVersionUID = -3635037677918262684L;

    /** 订单号 .*/
    private String orderNo;

    /** 商品评价 .*/
    private List<PostCommentItemRequest> itemList;

    /** 商品评分 .*/
    private Integer itemScore;

    /** 物流评分 .*/
    private Integer logisticsScore;
}
