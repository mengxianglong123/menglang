package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.pojo.HotSearch;
import cn.menglangpoem.mobile.pojo.Poem;

import java.util.List;

/**
 * 查询服务类
 */
public interface SearchService {
    /**
     * 综合搜索
     * @param keyword
     * @return
     */
    List<Poem> seaOverAll(String keyword,int pageNum);

    /**
     * 搜索诗人
     * @param authorName
     * @return
     */
    List<Author> seaAuthor(String authorName,int pageNum);

    /**
     * 按照标题搜索诗词
     * @param poemTitle
     * @param pageNum
     * @return
     */
    List<Poem> seaPoemByPoemTitle(String poemTitle,int pageNum);

    /**
     * 按照诗句搜索诗词
     * @param content
     * @param pageNum
     * @return
     */
    List<Poem> seaPoemByContent(String content,int pageNum);

    /**
     * 按照标签搜索诗词
     * @param tagName
     * @param pageNum
     * @return
     */
    List<Poem> seaPoemByTag(String tagName,int pageNum);

    /**
     * 随机查询热门搜索
     * @return
     */
    List<HotSearch> seaHotRand();

    /**
     * autocomplete
     * @param keyword
     * @return
     */
    List<String> seaAutoComplete(String keyword);
}
