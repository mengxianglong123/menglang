package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.pojo.Phrase;

import java.util.List;

public interface PhraseService {
    /**
     * 分页查询所有名句
     * @param pageNum
     * @return
     */
    List<Phrase> selAllPage(int pageNum);

    /**
     * 随机查询名句
     * @return
     */
    List<Phrase> selRand();
}
