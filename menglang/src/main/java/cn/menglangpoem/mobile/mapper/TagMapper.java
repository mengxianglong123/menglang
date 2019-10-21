package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.Tag;

import java.util.List;

public interface TagMapper {
    /**
     * 返回热门标签
     * @return
     */
    List<Tag> selHot();

    /**
     * 查询所有标签
     * @return
     */
    List<Tag> selAll();
}
