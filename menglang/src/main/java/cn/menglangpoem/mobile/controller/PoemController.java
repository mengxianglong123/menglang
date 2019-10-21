package cn.menglangpoem.mobile.controller;

import cn.menglangpoem.mobile.pojo.Poem;
import cn.menglangpoem.mobile.service.PoemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PoemController {
    @Resource
    private PoemService poemService;

    /**
     * 分页查询所有诗词
     * @param pageNum
     * @return
     */
    @RequestMapping("/selAllPoemPage")
    @ResponseBody
    public List<Poem> selAllPage(int pageNum){
        return this.poemService.selAllPage(pageNum);
    }

    /**
     * 按分类查询诗词
     * @param params
     * @param pageNum
     * @return
     */
    @RequestMapping("/selPoemByTagPage")
    @ResponseBody
    public List<Poem> selByTagPage(String params,int pageNum){
        return this.poemService.selByTagPage(params,pageNum);
    }

    @RequestMapping("/selPoemByAuthorPage")
    @ResponseBody
    public  List<Poem> selByAuthorPage(int pageNum,String params){
        return this.poemService.selByAuthorPage(pageNum,params);
    }

}
