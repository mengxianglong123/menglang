package cn.menglangpoem.mobile.controller;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface PagesController {
    /**
     * 前往索引页
     * @return
     */
    String toIndex();
    /**
     * 前往首页
     * @return
     */
   String toHome(Model model,HttpSession session);

    /**
     * 前往创作页面
     * @return
     */
   String toCreate(Model model);

    /**
     * 前往发现页面
     * @return
     */
   String toFind(Model model);

    /***
     * 前往我的页面
     * @return
     */
   String toMe();

    /**
     * 前往诗人列表
     * @return
     */
   String toAuthorList(HttpSession session,Model model,String pageName);

    /**
     * 前往诗词列表
     * @return
     */
   String toPoemList(String pageName, Model model, HttpSession session);

    /**
     * 前往名句列表
     * @return
     */
   String toPhraseList(HttpSession session);

    /**
     * 前往标签列表
     * @return
     */
   String toTagList(Model model);

    /**
     * 前往诗人详情页
     * @param model
     * @return
     */
   String toAuthorDetail(Model model,int id);

    /**
     * 前往诗人的诗词全集列表
     * @param pageName
     * @param model
     * @return
     */
   String toAuthorPoemList(String pageName,Model model);

    /**
     * 前往诗词详情页
     * @param model
     * @return
     */
   String toPoemDetail(Model model,int id);

    /**
     * 前往搜索页
     * @return
     */
   String toSearch(Model model);

    /**
     * 前往搜索结果页
     * @return
     */
   String toSearchResult(Model model,String keyword);

    /**
     * 前往诗人搜索结果
     * @return
     */
   String tosearchAuthorList(Model model,String keyword,HttpSession session);

    /**
     * 前往诗词搜索结果
     * @return
     */
    String tosearchPoemList(HttpSession session,Model model);

    /**
     * 前往关于页面
     * @return
     */
    String toAbout();

    /**
     * 前往版本信息页面
     * @return
     */
    String toVersion(Model model);

    /**
     * 前往章节列表
     * @return
     */
    String toSectionList(Model model,int id,String name);

    /**
     * 前往章节详情页
     * @param model
     * @return
     */
    String toSectionDetail(Model model,int id);
}
