/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/1 16:52.
 */

package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈卖家资金信息response〉.
 *
 * @author: shouanxin
 * @date: 2020/3/1
 */
@Data
public class MerchantCapitalResp implements Serializable {
    private static final long serialVersionUID = 2134494204440426031L;

    /** 是否支持分账 1是 0否  .*/
    private Integer clearingFlag;

    /** 三方结算账号 .*/
    private String accountNo;
}
