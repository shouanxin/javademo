/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/8/3 14:56.
 */

package java8;

import bean.PostCommentTagRequest;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 〈Stream用法〉.
 *
 * @author: shouanxin
 * @date: 2019/8/3
 */
public class StreamDemo01 {
    /**
     * 功能描述: 〈list 转 map〉.
     *
     * @param
     * @return  void
     * @author shouanxin
     * @date  2019/8/3 16:29
     */
    @Test
    public void listToMap() {
        List<PostCommentTagRequest> list = initData();

        // 方法一
        //Map<Long, PostCommentTagRequest> map = list.stream().collect(Collectors.toMap(PostCommentTagRequest::getDataId, p -> p));
        // 方法二 p->p 可用Function.identity()代替
        Map<Long, PostCommentTagRequest> map = list.stream().collect(Collectors.toMap(PostCommentTagRequest::getDataId, Function.identity()));
        System.out.println(map);
    }

    /**
     * 功能描述: 〈list to map 重复key〉.
     *
     * @param
     * @return  void
     * @author shouanxin
     * @date  2019/8/3 16:29
     */
    @Test
    public void listToMapDuplicateKey() {
        // 初始化数据
        List<PostCommentTagRequest> list = this.initData();
        list.addAll(this.initData());

        Map<Long, PostCommentTagRequest> map = list.stream().collect(Collectors.toMap(PostCommentTagRequest::getDataId, Function.identity(), (key1, key2) -> key2, HashMap::new));
        System.out.println(map);
    }

    /**
     * 功能描述: 〈去除重复元素〉.
     *
     * @param
     * @return  void
     * @author shouanxin
     * @date  2019/8/3 16:29
     */
    @Test
    public void distinctList() {
        // 初始化数据
        List<PostCommentTagRequest> list = this.initData();
        list.addAll(this.initData());

        List<PostCommentTagRequest> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 功能描述: 〈list 分组为 map〉.
     *
     * @param
     * @return  void
     * @author shouanxin
     * @date  2019/8/3 16:28
     */
    @Test
    public void groupingList() {
        // 初始化数据
        List<PostCommentTagRequest> list = this.initData();
        list.addAll(this.initData());

        Map<Long, List<PostCommentTagRequest>> listMap = list.stream().collect(Collectors.groupingBy(PostCommentTagRequest::getDataId));
        System.out.println(listMap);
    }

    @Test
    public void filterList() {
        // 初始化数据
        List<PostCommentTagRequest> list = this.initData();
        // 取出dataId为奇数的数据
        List<PostCommentTagRequest> collect = list.stream().filter(l -> l.getDataId() % 2 > 0).collect(Collectors.toList());
        System.out.println(collect);
    }
    
    @Test
    public void mapList() {
        // 初始化数据
        List<PostCommentTagRequest> list = this.initData();
        list.stream().mapToInt(l -> l.getDataId().intValue());
    }

    /**
     * 功能描述: 〈初始化数据〉.
     *
     * @param
     * @return  java.util.List<bean.PostCommentTagRequest>
     * @author shouanxin
     * @date  2019/8/3 16:29
     */
    private List<PostCommentTagRequest> initData() {
        List<PostCommentTagRequest> list = Lists.newArrayList();
        // 初始化数据
        for (long i = 0; i < 10; i++) {
            PostCommentTagRequest postCommentTagRequest = new PostCommentTagRequest();
            postCommentTagRequest.setDataId(i);
            postCommentTagRequest.setTagName("tag" + i);
            list.add(postCommentTagRequest);
        }
        return list;
    }
}
