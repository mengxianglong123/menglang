package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.PhraseMapper;
import cn.menglangpoem.mobile.pojo.Phrase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class PhraseServiceImpl implements PhraseService {
    @Resource
    private PhraseMapper phraseMapper;
    @Override
    public List<Phrase> selAllPage(int pageNum) {
        pageNum = (pageNum-1)*20;
        return this.phraseMapper.selAllPage(pageNum);
    }

    @Override
    public List<Phrase> selRand() {
        return this.phraseMapper.selRand();
    }
}
