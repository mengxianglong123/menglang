package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.pojo.CreateImg;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;

/**
 * 创作诗词图片服务类
 */
public class CreateImgService {
    private Image image;
    private int width;
    private int height;
    private BufferedImage bufimg;

    /**
     * 添加文字主程序
     * @param input
     */
    public long drawMain(String title, String input, CreateImg createImg,String fontFamily,String name){
        // 初始化参数
        int wordsNum = 0;
        int controllNum = createImg.getControlNum();
        int startX = createImg.getStartX();
        int startY = createImg.getStartY();
        int endX = createImg.getEndX();
        int endY = createImg.getEndY();
        int space = createImg.getSpace();
        int fontSize = createImg.getFontsize();
        int colorNum = Integer.parseInt(createImg.getColor(),16);


        Graphics2D g = getGraphics("/static/images/createimgs/"+createImg.getName());
        // 设置颜色
        Color color = new Color(colorNum);
        g.setColor(color);
        // 设置字体
        Font font = new Font(fontFamily,Font.PLAIN,createImg.getFontsize());
        g.setFont(font);

        /*------------纵向添加文字------------*/
        if (controllNum == 0)
        {
           drawMainVertical(startX,startY,wordsNum,input,title,g,space,fontSize);
        }


        /*------------横向添加文字------------*/
        if (controllNum == 1)
        {
           drawMainTransverse(startX,startY,wordsNum,input,title,g,space,fontSize);
        }

        //添加图片水印
        try {
            drawLogo(g,endX,this.height-endY);
        } catch (IOException e) {
            System.out.println("添加logo错误");
            e.printStackTrace();
        }

        if (name != null){
            // 添加署名
            drawName(g,endX,this.height-endY-15,name,font,fontFamily);
        }

        long time = -1;
        //存储图片
        try {
            time = saveImg();
        } catch (IOException e) {
            System.out.println("存储异常");
            e.printStackTrace();
        }
        // 返回图片编号
        return time;
    }



    /**
     * 获取Graphics2D对象
     * @param imgName
     * @return
     */
    public Graphics2D getGraphics(String imgName){

        // 获取源图片路径
        URL source = CreateImgService.class.getResource(imgName);
        // 用imageIO读取图片
        try {
            this.image = ImageIO.read(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 利用BufferedImage，将图片加载到内存中
        this.height = this.image.getHeight(null);
        this.width = this.image.getWidth(null);
        this.bufimg = new BufferedImage(this.width,this.height,BufferedImage.TYPE_INT_RGB);

        // 获取图像对象，来对图片进行处理
        Graphics2D g = this.bufimg.createGraphics();

        // 设置RenderingHints(渲染提示)，以达到文字抗锯齿的功效,(key,value)形式赋值
//        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        rh.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//        rh.put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
//        g.setRenderingHints(rh);

//        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

        // 开始处理图片
        g.drawImage(image,0,0,this.width,this.height,null);
        return g;
    }

    /**
     * 横向添加文字
     * @param g
     * @param s
     * @param x
     * @param y
     */
    public void drawTransverse(Graphics2D g,String s,float x,float y){
        g.drawString(s,x,y);
    }

    /**
     * 纵向添加文字
     * @param g
     * @param s
     * @param x
     * @param y
     * @param fontSize
     */
    public void drawVertical(Graphics2D g,String s,float x,float y,int fontSize){
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            g.drawString(String.valueOf(word),x,y+(fontSize+1)*i);
        }
    }

    /**
     * 获取水印文字总长度
     * @param waterMarkContent
     * @param g
     * @return
     */
    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    /**
     * 保存图片
     * @throws IOException
     */
    public long saveImg() throws IOException {

        // 指定输出路径
        File dir = new File("createOutImgs");
        if (!dir.exists()) dir.mkdir();
        //创建文件
        long time = System.currentTimeMillis();
        File f = new File(dir,time+".png");

        FileOutputStream outputStream = new FileOutputStream(f);
        //输出为png
        ImageIO.write(this.bufimg,"png",outputStream);
        return time;
    }


    /**
     * 添加图片logo水印
     * @param g
     * @param endX
     * @param endY
     * @throws IOException
     */
    public void drawLogo(Graphics2D g,int endX,int endY) throws IOException {
        URL logoSrc = CreateImgService.class.getResource("/static/images/createimgs/印章.png");
        Image logoImg = ImageIO.read(logoSrc);
        int logoWidth = logoImg.getWidth(null);
        int logoHeight = logoImg.getHeight(null);
        g.drawImage(logoImg,endX,endY,logoWidth,logoHeight,null);
    }

    /**
     * 添加名字
     * @param g
     * @param endX
     * @param endY
     * @param name
     * @param font 原字体
     */
    public void drawName(Graphics2D g,int endX,int endY,String name,Font font,String fontFamily){
        // 将名字倒叙
        name = new StringBuffer(name).reverse().toString();
        int nameFontSize = 26;
        // 更改为署名专用字体
        Font nameFont = new Font(fontFamily,Font.PLAIN,nameFontSize);
        g.setFont(nameFont);
        //开始处理
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            g.drawString(String.valueOf(c),endX+(40-nameFontSize)/2,endY-i*nameFontSize+5);
        }

        // 还原字体
        g.setFont(font);
    }

    /**
     * 纵向处理图片总程序
     * @param startX
     * @param startY
     * @param wordsNum
     * @param input
     * @param title
     * @param g
     * @param space
     * @param fontSize
     */
    public void drawMainVertical(int startX,int startY,int wordsNum,String input,String title,Graphics2D g,int space,int fontSize){
        String[] words = input.split("，|。|,|;");
        startX = this.width - startX;
        // 获取最长的文字长度
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            int len = getWatermarkLength(words[i],g);
            if (maxLen < len) maxLen = len;
        }
        // 添加标题
        if (title != null){
            float x = startX - wordsNum*space;
            float y = maxLen/2-getWatermarkLength(title,g)/2+startY;
            drawVertical(g,title,x,y,fontSize+5);
            wordsNum++; //自增
        }

        // 添加诗词内容
        for (int i = 0; i < words.length; i++) {
            drawVertical(g,words[i],startX-wordsNum*space,startY,fontSize);
            wordsNum++;//自增
        }
    }

    public void drawMainTransverse(int startX,int startY,int wordsNum,String input,String title,Graphics2D g,int space,int fontSize){
        // 处理标题
        if (title != null){
            float x = this.width/2 - getWatermarkLength(title,g)/2;
            drawTransverse(g,title,x,startY+wordsNum*space);
            wordsNum++;
        }

        // 处理内容
        String[] words = input.split("，|。|,|;");
        for (int i = 0; i < words.length; i++) {
            float x = this.width/2 - getWatermarkLength(words[i],g)/2;
            drawTransverse(g,words[i],x,startY+wordsNum*space);
            wordsNum++;
        }
    }

}

