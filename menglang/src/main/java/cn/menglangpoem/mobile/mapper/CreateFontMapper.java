package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.CreateFont;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreateFontMapper {
    /**
     * 按照id查询字体
     * @param id
     * @return
     */
    CreateFont selById(@Param("id") int id);

    /**
     * 查询所有字体
     * @return
     */
    List<CreateFont> selAll();
}
