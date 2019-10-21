package cn.menglangpoem.mobile.controller;

import cn.menglangpoem.mobile.pojo.CreateFont;
import cn.menglangpoem.mobile.pojo.CreateImg;
import cn.menglangpoem.mobile.service.CreateImgService;
import cn.menglangpoem.mobile.service.CreateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Controller
public class CreateController {
    @Resource
    private CreateService createService;
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/createImg")
    @ResponseBody
    public String createById(int imgId,int fontId,String title,String words,String name){
        // 记录日志
        logger.warn("imgId="+imgId+" fontId="+fontId+" title="+title+" words="+words+" name="+name);

        CreateImg createImg = this.createService.selImgById(imgId);
        String fontFamily = this.createService.selFontById(fontId).getName();
        //判断是否为空
        if (title.equals("")) title = null;
        if (name.equals("")) name = null;


        CreateImgService imgService = new CreateImgService();
        long time = imgService.drawMain(title,words,createImg,fontFamily,name);
        return String.valueOf(time);
    }

    /**
     * 前往
     * @param model
     * @return
     */
    @RequestMapping("/selCreateImg")
    public String selAllImg(Model model){
        List<CreateImg> imgs = this.createService.selAllImg();
        model.addAttribute("imgs",imgs);
        String path = "../static/images/createShow/";
        model.addAttribute("path",path);
        return "pages/create-sel-img.html";
    }

    /**
     * 前往创作输入页面
     * @return
     */
    @RequestMapping("/createInput")
    public String createInput(){
        return "pages/create-input.html";
    }

    @RequestMapping("/selCreateFont")
    public String createFont(Model model){
        List<CreateFont> fonts = this.createService.selAllFont();
        model.addAttribute("fonts",fonts);
        String path = "../static/images/fontimgs/";
        String after = ".jpg";
        model.addAttribute("path",path);
        model.addAttribute("after",after);
        return "pages/create-sel-font.html";
    }

    /**
     * 前往结果页面
     * @param time
     * @param model
     * @return
     */
    @RequestMapping("/createOut")
    public String toOut(String time,Model model){
        model.addAttribute("time",time);
        return "pages/create-out.html";
    }
    /**
     * 获取图片
     * @param time
     * @return
     */
    @RequestMapping("/getCreateImage")
    @ResponseBody
    public void getImage(String time, HttpServletResponse response) {
        File f = new File("createOutImgs/" + time + ".png");
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream(f);
            os = response.getOutputStream();
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
