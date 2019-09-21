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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostCommentTagRequest that = (PostCommentTagRequest) o;

        if (dataId != null ? !dataId.equals(that.dataId) : that.dataId != null) return false;
        return tagName != null ? tagName.equals(that.tagName) : that.tagName == null;
    }

    @Override
    public int hashCode() {
        int result = dataId != null ? dataId.hashCode() : 0;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }
}
