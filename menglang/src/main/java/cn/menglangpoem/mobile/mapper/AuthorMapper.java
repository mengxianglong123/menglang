package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.pojo.HotAuthor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorMapper {
    /**
     * 随机查询部分热门诗人
     * @return
     */
    List<HotAuthor> selHotSome();

    /**
     * 分页查询所有诗人
     * @param pageNum
     * @return
     */
    List<Author> selAllPage(@Param("pageNum") int pageNum);

    /**
     * 按照id查询诗人
     * @param authorId
     * @return
     */
    Author selById(@Param("authorId") int authorId);

    /**
     * 按照姓名查询诗人
     * @param authorName
     * @return
     */
    List<Author> selByName(@Param("authorName") String authorName,@Param("pageNum") int pageNum);

    /**
     * 名句页面查询诗人
     * @param authorName
     * @return
     */
    Author selForPhrase(@Param("authorName") String authorName);
}
