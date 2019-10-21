package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.CreateImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreateImgMapper {
    /**
     * 按照id查询创作模板
     * @param id
     * @return
     */
    CreateImg selById(@Param("id") int id);

    /**
     * 查询所有创作模板
     * @return
     */
    List<CreateImg> selAll();
}
