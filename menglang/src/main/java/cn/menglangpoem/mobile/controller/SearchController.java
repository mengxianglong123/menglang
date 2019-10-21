package cn.menglangpoem.mobile.controller;

import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.pojo.HotAuthor;
import cn.menglangpoem.mobile.pojo.HotSearch;
import cn.menglangpoem.mobile.pojo.Poem;
import cn.menglangpoem.mobile.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SearchController {
    @Resource
    private SearchService searchService;

    /**
     * 综合查询
     * @return
     */
    @RequestMapping("/searchOverAll")
    @ResponseBody
    public List<Poem> searchOverAll(String params,int pageNum){
        return this.searchService.seaOverAll(params,pageNum);
    }

    /**
     * 按标题搜索诗词
     * @param params
     * @param pageNum
     * @return
     */
    @RequestMapping("/searchTitle")
    @ResponseBody
    public List<Poem> searchTitle(String params,int pageNum){
        return this.searchService.seaPoemByPoemTitle(params,pageNum);
    }

    /**
     * 按内容搜索诗词
     * @param params
     * @param pageNum
     * @return
     */
    @RequestMapping("/searchContent")
    @ResponseBody
    public List<Poem> searchContent(String params,int pageNum){
        return this.searchService.seaPoemByContent(params,pageNum);
    }

    /**
     * 按照分类搜索诗词
     * @param params
     * @param pageNum
     * @return
     */
    @RequestMapping("/searchTag")
    @ResponseBody
    public List<Poem> searchTag(String params,int pageNum){
        return this.searchService.seaPoemByTag(params,pageNum);
    }


    /**
     * 查询诗人
     * @param params
     * @param pageNum
     * @return
     */
    @RequestMapping("/searchAuthor")
    @ResponseBody
    public List<Author> searchAuthor(String params,int pageNum){
        return this.searchService.seaAuthor(params,pageNum);
    }

    @RequestMapping("/autoComplete")
    @ResponseBody
    public List<String> seaAutoComplete(String keyword){
        return this.searchService.seaAutoComplete(keyword);
    }

    /**
     * 获取搜索诗词列表id
     * @param session
     * @return
     */
    @RequestMapping("/getSearchPoemListId")
    @ResponseBody
    public int getSearchPoemListId(HttpSession session){
        int searchPoemListId = (int) session.getAttribute("searchPoemListId");
        return searchPoemListId;
    }

    /**
     * 获取搜索诗人列表id
     * @param session
     * @return
     */
    @RequestMapping("/getSearchAuthorListId")
    @ResponseBody
    public int getSearchAuthorListId(HttpSession session){
        int searchAuthorListId = (int) session.getAttribute("searchAuthorListId");
        return searchAuthorListId;
    }

    /**
     * 更新诗词列表id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateSearchPoemListId")
    public String updatePoemListId(HttpSession session){
        //获取诗词列表编号
        int poemListId = (int) session.getAttribute("searchPoemListId");
        //更改session内容
        session.setAttribute("searchPoemListId",poemListId+1);
        return "updateOk";
    }

    /**
     * 更新诗人列表信息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateSearchAuthorListId")
    public String updateAuthorListId(HttpSession session){
        //获取诗人列表编号
        int authorListId = (int) session.getAttribute("searchAuthorListId");
        //更改
        session.setAttribute("searchAuthorListId",authorListId+1);
        return "updateOk";
    }
}
