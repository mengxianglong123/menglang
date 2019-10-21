package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.CreateBookMapper;
import cn.menglangpoem.mobile.pojo.CreateBook;
import cn.menglangpoem.mobile.pojo.CreateSection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CreateBookService {
    @Resource
    private CreateBookMapper createBookMapper;

    /**
     * 查询所有书籍
     * @return
     */
    public List<CreateBook> selAllCreateBook(){
        return this.createBookMapper.selAllBook();
    }

    /**
     * 按照书籍id查询所有章节
     * @param id
     * @return
     */
    public List<CreateSection> selSectionByBookId(int id){
        return this.createBookMapper.selSectionByBookId(id);
    }

    /**
     * 按照id查询章节
     * @param id
     * @return
     */
    public CreateSection selSectionById(int id){
        return this.createBookMapper.selSectionById(id);
    }
}
