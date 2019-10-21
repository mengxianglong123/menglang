package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.PoemCardImgMapper;
import cn.menglangpoem.mobile.pojo.FindBack;
import cn.menglangpoem.mobile.pojo.PhraseBack;
import cn.menglangpoem.mobile.pojo.PoemCardImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PoemCardImgService {
    @Resource
    private PoemCardImgMapper poemCardImgMapper;

    /**
     * 随机查询顶部图片
     * @return
     */
    public List<PoemCardImg> selTopRand(){
        return this.poemCardImgMapper.selTopRand();
    }

    /**
     * 随机查询底部图片
     * @return
     */
    public List<PoemCardImg> selBottomRand(){
        return this.poemCardImgMapper.selBottomRand();
    }

    /**
     * 随机查询名句背景
     * @return
     */
    public List<PhraseBack> selPhraseBack(){
        return this.poemCardImgMapper.selPhraseBackRand();
    }

    public FindBack selFindBackRand(){
        return this.poemCardImgMapper.selFindBackRand();
    }
}
