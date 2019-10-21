package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.pojo.Tag;

import java.util.List;

public interface TagService {
    /**
     * 查询热门分类
     * @return
     */
    List<Tag> selHot();

    /**
     * 查询所有标签
     * @return
     */
    List<Tag> selAll();
}
