package cn.menglangpoem.mobile.controller;

import cn.menglangpoem.mobile.mapper.AuthorMapper;
import cn.menglangpoem.mobile.pojo.*;
import cn.menglangpoem.mobile.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
public class PagesControllerImpl implements PagesController {
    @Resource
    private TagService tagService; //查询标签
    @Resource
    private AuthorService authorService;//查询诗人
    @Resource
    private PoemService poemService; //查询诗词
    @Resource
    private PoemCardImgService poemCardImgService;//查询诗词图片
    @Resource
    private SearchService searchService;
    @Resource
    private VersionService versionService;
    @Resource
    private CreateBookService createBookService; //查询创作书籍
    SearchController searchController = new SearchController();
    @Override
    @RequestMapping("/index")
    public String toIndex() {
        return "index.html";
    }

    @Override
    @RequestMapping("/home")
    public String toHome(Model model,HttpSession session) {
        //初始化列表id
        this.initListId(session);
        //查询热门标签
        List<Tag> hotTags = this.tagService.selHot();
        model.addAttribute("hotTags",hotTags);
        //查询部分热门诗人
        List<HotAuthor> hotAuthors = this.authorService.selHotSome();

        model.addAttribute("hotAuthors",hotAuthors);
        return "pages/home.html";
    }

    @Override
    @RequestMapping("/create")
    public String toCreate(Model model) {
        List<CreateBook> books = this.createBookService.selAllCreateBook();
        String path = "../static/images/createbooks/";
        model.addAttribute("path",path);
        model.addAttribute("books",books);
        return "pages/create.html";
    }

    @Override
    @RequestMapping("/find")
    public String toFind(Model model) {
        String path = "../static/images/findback/";
        String bm = "background-image:";
        String left = "url(";
        String right = ");";
        FindBack findBack = this.poemCardImgService.selFindBackRand();
        String name = findBack.getName();
        String s = bm + left + path + name+ right;
        findBack.setName(s);
        model.addAttribute(findBack);
        return "pages/find.html";
    }

    @Override
    @RequestMapping("/me")
    public String toMe() {
        return "pages/me.html";
    }

    @Override
    @RequestMapping("/authorList")
    public String toAuthorList(HttpSession session,Model model,String pageName) {
        int authorListId = this.getAuthorListId(session,pageName);
        model.addAttribute("authorListId",authorListId);
        return "pages/authorList.html";
    }

    @Override
    @RequestMapping("/poemList")
    public String toPoemList(String pageName,Model model,HttpSession session) {
        int poemListId = this.getPoemListId(session,pageName);
        model.addAttribute("poemListId",poemListId);
        model.addAttribute("pageName",pageName);
        return "pages/poemList.html";
    }

    @Override
    @RequestMapping("/phraseList")
    public String toPhraseList(HttpSession session) {
        return "pages/phraseList.html";
    }

    @Override
    @RequestMapping("/tagList")
    public String toTagList(Model model) {
        List<Tag> tags = this.tagService.selAll();
        int len = tags.size();
        int row = len/4;
        if(len%4 != 0) row++;
        model.addAttribute("row",row);
        model.addAttribute("len",len);
        model.addAttribute("tags",tags);
        return "pages/tagList.html";
    }

    @Override
    @RequestMapping("/authorDetail")
    public String toAuthorDetail(Model model,int id) {
        /*--------------------查询处理诗人信息--------------------*/
        Author author = this.authorService.selById(id);
        String path = "../static/images/authorImgs/";
        model.addAttribute("path",path);
        model.addAttribute(author);
        String[] labels = author.getLabel().split(" ");
        model.addAttribute("labels",labels);


        /*--------------------查询处理诗人作品信息--------------------*/
        List<Poem> poems = this.poemService.selByAuthorSimple(author.getName());
        model.addAttribute("poems",poems);
        return "pages/authorDetail.html";
    }

    @RequestMapping("/authorPoemList")
    @Override
    public String toAuthorPoemList(String pageName, Model model) {
        model.addAttribute("pageName",pageName);
        return "pages/authorPoemList.html";
    }

    @RequestMapping("/poemDetail")
    @Override
    public String toPoemDetail(Model model,int id){
        /*----------------------处理背景图片----------------------*/
        String path = "../static/images/poemcardimages/";
        String bm = "background-image:";
        String left = "url(";
        String right = ")";
        String topImg = "";
        String bottomImg = "";
        topImg = this.poemCardImgService.selTopRand().get(0).getName();
        bottomImg = this.poemCardImgService.selBottomRand().get(0).getName();
        String back1 = left+path+"texture.png"+right+',';
        String back2 = left+path+topImg+right+',';
        String back3 = left+path+bottomImg+right;



        Poem poem = this.poemService.selById(id);


        /*----------------------处理诗词标签----------------------*/
        String[] tags = poem.getTag().split(",");
        model.addAttribute("tags",tags);

        model.addAttribute("poem",poem);
        model.addAttribute("path",path);
        model.addAttribute("bm",bm);
        model.addAttribute("back1",back1);
        model.addAttribute("back2",back2);
        model.addAttribute("back3",back3);

        return "pages/poemDetail.html";
    }

    @RequestMapping("/search")
    @Override
    public String toSearch(Model model) {
        List<HotSearch> chips = this.searchService.seaHotRand();
        model.addAttribute("chips",chips);
        return "pages/search.html";
    }

    @Override
    @RequestMapping("/searchResult")
    public String toSearchResult(Model model,String keyword) {
        model.addAttribute("keyword",keyword);
        return "pages/searchResult.html";
    }

    @Override
    @RequestMapping("/search-authorList")
    public String tosearchAuthorList(Model model,String keyword,HttpSession session) {
        int authorListId = searchController.getSearchAuthorListId(session);
        model.addAttribute("authorListId",authorListId);
        return "pages/search-authorList.html";
    }

    @Override
    @RequestMapping("/search-poemList")
    public String tosearchPoemList(HttpSession session,Model model) {
        int poemListId = searchController.getSearchPoemListId(session);
        model.addAttribute("poemListId",poemListId);
        return "pages/search-poemList.html";
    }

    @Override
    @RequestMapping("/about")
    public String toAbout() {
        return "pages/about.html";
    }

    @Override
    @RequestMapping("/version")
    public String toVersion(Model model) {
        List<Version> versions = this.versionService.selAll();
        model.addAttribute("versions",versions);
        return "pages/version.html";
    }

    @Override
    @RequestMapping("/sectionList")
    public String toSectionList(Model model, int id, String name) {
        model.addAttribute("bookName",name);
        List<CreateSection> sections = this.createBookService.selSectionByBookId(id);
        model.addAttribute("sections",sections);
        return "pages/create-section-list.html";
    }

    @Override
    @RequestMapping("/sectionDetail")
    public String toSectionDetail(Model model, int id) {
        CreateSection section = this.createBookService.selSectionById(id);
        model.addAttribute("section",section);
        return "pages/create-section-detail.html";
    }

    /**
     * 初始化列表id
     * @param session
     */
    public void initListId(HttpSession session){
        //诗词列表
        if (session.getAttribute("poemListId") == null){
            Map<String,Integer> poemPages = new Hashtable<>();
            session.setAttribute("poemPages",poemPages);
            session.setAttribute("poemListId",1);
            session.setAttribute("searchPoemListId",1);
        }

        //诗人列表
        if (session.getAttribute("authorListId") == null){
            Map<String,Integer> authorPages = new Hashtable<>();
            session.setAttribute("authorPages",authorPages);
            session.setAttribute("authorListId",1);
            session.setAttribute("searchAuthorListId",1);
        }
    }

    /**
     * 获取诗词列表id
     * @param session
     * @return
     */
    @RequestMapping("/getPoemListId")
    @ResponseBody
    public int getPoemListId(HttpSession session,String pageName){
        Hashtable<String,Integer> poemPages = (Hashtable<String, Integer>) session.getAttribute("poemPages");
        //判断是否存在
        if (poemPages.get(pageName) != null){
            Integer poemListId = poemPages.get(pageName);
            return poemListId.intValue();
        }
        else {
            int poemListId = (int) session.getAttribute("poemListId");
            poemPages.put(pageName,poemListId);

            //编号+1
            int newId = poemListId + 1;
            session.setAttribute("poemListId",newId);
            session.setAttribute("poemPages",poemPages);
            return poemListId;
        }
    }

    /**
     * 获取作者列表id
     * @param session
     * @param pageName
     * @return
     */
    @RequestMapping("/getAuthorListId")
    @ResponseBody
    public int getAuthorListId(HttpSession session,String pageName){
        Hashtable<String,Integer> authorPages = (Hashtable<String, Integer>) session.getAttribute("authorPages");
        if (authorPages.get(pageName) != null)
        {
            Integer authorListId = authorPages.get(pageName);
            return authorListId.intValue();
        }
        else {
            int authorListId = (int) session.getAttribute("authorListId");
            authorPages.put(pageName,authorListId);
            int newId = authorListId + 1;

            session.setAttribute("authorListId",newId);
            session.setAttribute("authorPages",authorPages);

            return authorListId;
        }
    }
}
