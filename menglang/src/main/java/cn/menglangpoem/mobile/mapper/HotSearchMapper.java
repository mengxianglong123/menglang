package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.HotSearch;

import java.util.List;

public interface HotSearchMapper {

    /**
     * 随机查询热门搜索
     * @return
     */
    List<HotSearch> selRand();
}
