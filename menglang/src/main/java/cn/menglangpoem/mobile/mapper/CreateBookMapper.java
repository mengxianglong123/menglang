package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.CreateBook;
import cn.menglangpoem.mobile.pojo.CreateSection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreateBookMapper {
    /**
     * 查询所有书籍
     * @return
     */
    List<CreateBook> selAllBook();

    /**
     * 按照书籍id查询所有章节
     * @param id
     * @return
     */
    List<CreateSection> selSectionByBookId(@Param("id") int id);

    /**
     * 按照id查询章节
     * @param id
     * @return
     */
    CreateSection selSectionById(@Param("id") int id);
}
