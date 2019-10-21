package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.Version;

import java.util.List;

public interface VersionMapper {
    /**
     * 查询所有版本信息
     * @return
     */
    List<Version> selAll();
}
