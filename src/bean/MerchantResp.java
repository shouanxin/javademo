/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/1 16:41.
 */

package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈卖家转换信息response〉.
 *
 * @author: shouanxin
 * @date: 2020/3/1
 */
@Data
public class MerchantResp implements Serializable {
    private static final long serialVersionUID = -5126941995010210861L;
    /** 卖家id .*/
    private int merchantId;

    /** 卖家名称 .*/
    private String merchantName;

    /** 卖家描述 .*/
    private String merchantDesc;
}
