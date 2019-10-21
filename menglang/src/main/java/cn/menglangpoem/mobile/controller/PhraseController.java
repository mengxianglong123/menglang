package cn.menglangpoem.mobile.controller;

import cn.menglangpoem.mobile.pojo.Author;
import cn.menglangpoem.mobile.pojo.Phrase;
import cn.menglangpoem.mobile.pojo.PhraseBack;
import cn.menglangpoem.mobile.service.AuthorService;
import cn.menglangpoem.mobile.service.PhraseService;
import cn.menglangpoem.mobile.service.PoemCardImgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PhraseController {
    @Resource
    private PhraseService phraseService;
    @Resource
    private PoemCardImgService poemCardImgService;
    @Resource
    private AuthorService authorService;

    /**
     * 分页查询所有名句
     * @param pageNum
     * @return
     */
    @RequestMapping("/selAllPhrasePage")
    @ResponseBody
    public List<Phrase> selAllPage(int pageNum){
        return this.phraseService.selAllPage(pageNum);
    }

    /**
     * 随机查询名句背景
     * @return
     */
    @RequestMapping("/selPhraseBackRand")
    @ResponseBody
    public List<PhraseBack> selBack(){
        return this.poemCardImgService.selPhraseBack();
    }


    /**
     * 随机查询名句
     * @return
     */
    @RequestMapping("/selPhraseRand")
    public String selRand(Model model){
        List<Phrase> phrases = this.phraseService.selRand();
        List<PhraseBack> phraseBacks = this.poemCardImgService.selPhraseBack();
        String authorPath = "../static/images/authorImgs/";
        String backPath = "../static/images/phraseback/";
        String bm = "background-image:";
        String left = "url(";
        String right = ")";

        for (int i=0;i<phrases.size();i++){
            String img = phrases.get(i).getAuthorImg();
            if (img == null) img = "head.png";
            String path = bm + left + authorPath + img + right;
            phrases.get(i).setAuthorImg(path);
        }

        for (int i=0;i<phraseBacks.size();i++){
            String name = phraseBacks.get(i).getName();
            String path = bm  + left + backPath + name + right;
            phraseBacks.get(i).setName(path);
        }
        model.addAttribute("phrases",phrases);
        model.addAttribute("phraseBacks",phraseBacks);
        return "pages/find-phraseList.html";
    }
}
