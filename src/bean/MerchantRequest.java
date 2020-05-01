/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2020/3/1 16:35.
 */

package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈卖家信息请求参数〉.
 *
 * @author: shouanxin
 * @date: 2020/3/1
 */
@Data
public class MerchantRequest implements Serializable {
    private static final long serialVersionUID = -7564746330875348812L;

    /** 大区id .*/
    private Integer regionId;

    /** 城市code .*/
    private Integer cityCode;

    /** 区域编码 .*/
    private String areaCode;

    /** 微仓 .*/
    private String microWarehouse;

    /** 类型，用于区分业务，待完善 .*/
    private Integer type;
}
