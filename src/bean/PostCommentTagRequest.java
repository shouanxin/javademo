/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/5/4 13:16.
 */

package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈〉.
 *
 * @author: shouanxin
 * @date: 2019/5/4
 */
@Data
public class PostCommentTagRequest implements Serializable {
    private static final long serialVersionUID = -1375930667708263318L;

    /** id .*/
    private Long dataId;

    /** 标签名称 .*/
    private String tagName;
}
