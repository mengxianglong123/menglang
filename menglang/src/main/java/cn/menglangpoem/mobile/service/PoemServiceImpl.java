package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.PoemMapper;
import cn.menglangpoem.mobile.pojo.Poem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
@Transactional
public class PoemServiceImpl implements PoemService {
    @Resource
    private PoemMapper poemMapper;
    @Override
    public List<Poem> selAllPage(int pageNum) {
        pageNum = (pageNum-1) *20;
        List<Poem> poems = this.poemMapper.selAllPage(pageNum);

        return this.dealListPoem(poems);
    }

    @Override
    public List<Poem> selByTagPage(String tagName, int pageNum) {
        pageNum = (pageNum-1)*20;
        List<Poem> poems = this.poemMapper.selByTagPage(tagName,pageNum);
        return this.dealListPoem(poems);
    }

    @Override
    public List<Poem> selByAuthorSimple(String authorName) {
        List<Poem> poems = this.poemMapper.selByAuthorSimple(authorName);
        // 将\n替换为<br>
        for (int i=0; i<poems.size(); i++)
        {
            Poem poem = poems.get(i);
            poem.setContent(poem.getContent().replace("\n","<br>"));
        }
        return poems;
    }

    @Override
    public List<Poem> selByAuthorPage(int pageNum,String authorName) {
        pageNum = (pageNum-1) *20;
        List<Poem> poems = this.poemMapper.selByAuthorPage(pageNum,authorName);
        return this.dealListPoem(poems);
    }

    @Override
    public Poem selById(int id) {
        Poem poem = this.poemMapper.selById(id);
        return this.dealPoem(poem);
    }

    /**
     * 处理返回的诗词格式(仅限于列表形式)
     * @param poems
     * @return
     */
    public List<Poem> dealListPoem(List<Poem> poems){
        // 将\n替换为<br/>
        for (int i=0; i<poems.size(); i++)
        {
            Poem poem = poems.get(i);
            poem.setContent(poem.getContent().replace("\n","<br>"));
            poem.setContent(poem.getContent().split("<br>")[0]);
        }
        return poems;
    }

    /**
     * 处理诗词的详情信息
     * @param poem
     * @return
     */
    public Poem dealPoem(Poem poem){
        poem.setContent(poem.getContent().replace("\n","<br>"));
        if (poem.getComment().equals(""))
            poem.setComment("暂无赏析，欢迎补充！");
        else
            poem.setComment(poem.getComment().replace("\n","<br>"));

        return poem;
    }

}
