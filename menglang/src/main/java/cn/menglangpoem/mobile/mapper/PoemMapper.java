package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.Poem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoemMapper {
    /**
     * 分页查询所有诗词
     * @param pageNum
     * @return
     */
    List<Poem> selAllPage(@Param("pageNum") int pageNum);

    /**
     * 按标签分页查询诗词
     * @param tagName
     * @param pageNum
     * @return
     */
    List<Poem> selByTagPage(@Param("tagName") String tagName,@Param("pageNum") int pageNum);

    /**
     * 查询诗人三首作品
     * @param authorName
     * @return
     */
    List<Poem> selByAuthorSimple(@Param("authorName") String authorName);

    /**
     * 分页查询诗人所有诗词
     * @param pageNum
     * @return
     */
    List<Poem> selByAuthorPage(@Param("pageNum") int pageNum,@Param("authorName")String authorName);

    /**
     * 按照id查询诗人
     * @param poemId
     * @return
     */
    Poem selById(@Param("poemId") int poemId);

    /**
     * 按标题分页查询诗词
     * @param titleName
     * @param pageNum
     * @return
     */
    List<Poem> selByTitlePage(@Param("titleName") String titleName,@Param("pageNum") int pageNum);

    /**
     * 按照内容查询诗词
     * @param content
     * @param pageNum
     * @return
     */
    List<Poem> selByContentPage(@Param("content") String content,@Param("pageNum") int pageNum);

    /**
     * 综合查询
     * @param keyword
     * @param pageNum
     * @return
     */
    List<Poem> selOverAll(@Param("keyword") String keyword,@Param("pageNum") int pageNum);
}
