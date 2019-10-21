package cn.menglangpoem.mobile.controller;

import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class AuthorController {
    @Resource
    private AuthorService authorService;

    /**
     * 接收分页查询全部诗人请求
     * @param pageNum
     * @return
     */
    @RequestMapping("/selAllAuthorPage")
    @ResponseBody
    public List<Author> selAllPage(int pageNum){
        pageNum = (pageNum-1)*20;
        List<Author> authors = this.authorService.selAllPage(pageNum);
        return authors;
    }
}
