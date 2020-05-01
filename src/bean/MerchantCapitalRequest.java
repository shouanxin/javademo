/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/1 16:49.
 */

package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈资金信息获取请求参数〉.
 *
 * @author: shouanxin
 * @date: 2020/3/1
 */
@Data
public class MerchantCapitalRequest implements Serializable {

    private static final long serialVersionUID = -5060673737510357613L;

    /** 卖家id .*/
    private Long merchantId;

    /** 支付类型 .*/
    private String payType;

    /** 支付渠道 .*/
    private String payChannel;
}
