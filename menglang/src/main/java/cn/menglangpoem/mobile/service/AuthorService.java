package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.pojo.HotAuthor;

import java.util.List;

public interface AuthorService {
    /**
     * 查询部分热门诗人
     * @return
     */
    List<HotAuthor> selHotSome();

    /**
     * 分页查询所有诗人
     * @param pageNum
     * @return
     */
    List<Author> selAllPage(int pageNum);

    /**
     * 按照id查询诗人
     * @param authorId
     * @return
     */
    Author selById(int authorId);

    /**
     * 名句查询诗人
     * @param authorName
     * @return
     */
    Author selForPhrase(String authorName);
}
