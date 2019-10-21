package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.AuthorMapper;
import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.pojo.HotAuthor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Resource
    private AuthorMapper authorMapper;
    @Override
    public List<HotAuthor> selHotSome() {
        return this.authorMapper.selHotSome();
    }

    @Override
    public List<Author> selAllPage(int pageNum) {
        return this.authorMapper.selAllPage(pageNum);
    }

    @Override
    public Author selById(int authorId) {
        Author author = this.authorMapper.selById(authorId);
        return this.dealAuthor(author);
    }

    @Override
    public Author selForPhrase(String authorName) {
        return this.authorMapper.selForPhrase(authorName);
    }

    /**
     * 处理诗人信息格式
     * @param author
     * @return
     */
    public Author dealAuthor(Author author){
        //图片
        if(author.getImg() == null)
            author.setImg("default.jpg");
        //称号
        String label = "";
        if (!author.getLabel().equals("")){
            label = label + author.getLabel();
            if (!author.getTag().equals("")){
                label = label + ',' + author.getTag();
            }
        }
        else if (!author.getTag().equals("")){
            label = author.getTag();
        }
        label = label.replace(","," ");
        author.setLabel(label);

        //简介
        if (author.getIntroduction().equals("")){
            author.setIntroduction("暂无简介，欢迎反馈补充！");
        }
        return author;
    }
}
