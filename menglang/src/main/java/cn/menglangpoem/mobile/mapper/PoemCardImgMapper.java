package cn.menglangpoem.mobile.mapper;

import cn.menglangpoem.mobile.pojo.FindBack;
import cn.menglangpoem.mobile.pojo.PhraseBack;
import cn.menglangpoem.mobile.pojo.PoemCardImg;

import java.util.List;

public interface PoemCardImgMapper {

    /**
     * 随机查询顶部图片
     * @return
     */
    List<PoemCardImg> selTopRand();

    /**
     * 随机查询底部图片
     * @return
     */
    List<PoemCardImg> selBottomRand();

    /**
     * 随机查询名句图片
     * @return
     */
    List<PhraseBack> selPhraseBackRand();

    /**
     * 随机查询发现页面背景
     * @return
     */
    FindBack selFindBackRand();
}
