package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.AuthorMapper;
import cn.menglangpoem.mobile.mapper.HotSearchMapper;
import cn.menglangpoem.mobile.mapper.PhraseMapper;
import cn.menglangpoem.mobile.mapper.PoemMapper;
import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.pojo.HotSearch;
import cn.menglangpoem.mobile.pojo.Phrase;
import cn.menglangpoem.mobile.pojo.Poem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
    @Resource
    private PoemMapper poemMapper;
    @Resource
    private AuthorMapper authorMapper;
    @Resource
    private HotSearchMapper hotSearchMapper;
    @Resource
    private PhraseMapper phraseMapper;
    @Override
    public List<Poem> seaOverAll(String keyword, int pageNum) {
        List<Poem> poems = this.poemMapper.selOverAll(keyword, pageNum);
        return this.dealPoem(poems,keyword);
    }

    @Override
    public List<Author> seaAuthor(String authorName,int pageNum) {
        pageNum = (pageNum - 1)*20;
        List<Author> poems = this.authorMapper.selByName(authorName,pageNum);
        return poems;
    }

    @Override
    public List<Poem> seaPoemByPoemTitle(String poemTitle, int pageNum) {
        pageNum = (pageNum - 1) * 20;
        List<Poem> poems = this.poemMapper.selByTitlePage(poemTitle, pageNum);
        return this.dealPoem(poems,poemTitle);
    }

    @Override
    public List<Poem> seaPoemByContent(String content, int pageNum) {
        pageNum = (pageNum - 1) * 20;
        List<Poem> poems = this.poemMapper.selByContentPage(content,pageNum);
        return this.dealPoem(poems,content);
    }

    @Override
    public List<Poem> seaPoemByTag(String tagName, int pageNum) {
        pageNum = (pageNum - 1) * 20;
        List<Poem> poems = this.poemMapper.selByTagPage(tagName, pageNum);
        PoemService poemService = new PoemServiceImpl();
        return ((PoemServiceImpl) poemService).dealListPoem(poems);
    }

    @Override
    public List<HotSearch> seaHotRand() {
        return this.hotSearchMapper.selRand();
    }

    @Override
    public List<String> seaAutoComplete(String keyword) {
        List<String> list = new ArrayList<>();
        List<Author> authors = this.authorMapper.selByName(keyword,0);
        for (int i=0;i<authors.size();i++) {
            list.add(authors.get(i).getName());
        }
        List<Phrase> phrases = this.phraseMapper.selByKey(keyword);
        for(int i=0;i<phrases.size();i++){
            list.add(phrases.get(i).getContent());
        }
        return list;
    }


    /**
     * 处理诗词格式
     *
     * @param poems
     * @param keyword
     * @return
     */
    public List<Poem> dealPoem(List<Poem> poems, String keyword) {
        String left = "<span style='color:#DD4455'>";
        String right = "</span>";
        String key = ".*"+keyword+".*";
        for (int i=0;i<poems.size();i++){
            boolean flag = false;
            String title = poems.get(i).getTitle();
            String author = poems.get(i).getAuthor();
            String time = poems.get(i).getTime();
            String content = poems.get(i).getContent();
            String[] contents = content.split("\n");
            //检测诗词内容是否包含关键词
            for (int j=0;j<contents.length;j++){
                //如果匹配到
                if(contents[j].matches(key)){
                    contents[j] = contents[j].replace(keyword,left+keyword+right);
                    poems.get(i).setContent(contents[j]);
                    flag = true;
                    break;
                }
            }
            //未匹配到
            if (!flag) poems.get(i).setContent(contents[0]);

            //其他部分
            if (title.matches(key)) poems.get(i).setTitle(title.replace(keyword,left+keyword+right));
            if (time.matches(key)) poems.get(i).setTime(time.replace(keyword,left+keyword+right));
            if (author.matches(key)) poems.get(i).setAuthor(author.replace(keyword,left+keyword+right));
        }
        return poems;
    }

}