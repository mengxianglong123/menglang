package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.Phrase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhraseMapper {
    /**
     * 分页查询所有名句
     * @param pageNum
     * @return
     */
    List<Phrase> selAllPage(@Param("pageNum") int pageNum);

    /**
     * 模糊查询名句
     * @param keyword
     * @return
     */
    List<Phrase> selByKey(@Param("keyword") String keyword);

    /**
     * 随机查询名句
     * @return
     */
    List<Phrase> selRand();
}
