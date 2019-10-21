package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.pojo.Poem;

import java.util.List;

public interface PoemService {
    /**
     * 分页查询所有诗词
     * @param pageNum
     * @return
     */
    List<Poem> selAllPage(int pageNum);

    /**
     * 按标签分页查询诗词
     * @param tagName
     * @param pageNum
     * @return
     */
    List<Poem> selByTagPage(String tagName,int pageNum);

    /**
     * 查询示例诗词
     * @param authorName
     * @return
     */
    List<Poem> selByAuthorSimple(String authorName);

    /**
     * 按作者分页查询诗词
     * @param pageNum
     * @return
     */
    List<Poem> selByAuthorPage(int pageNum,String authorName);

    /**
     * 按照id查询诗人
     * @param id
     * @return
     */
    Poem selById(int id);
}
