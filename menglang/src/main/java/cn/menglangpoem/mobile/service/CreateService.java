package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.CreateFontMapper;
import cn.menglangpoem.mobile.mapper.CreateImgMapper;
import cn.menglangpoem.mobile.pojo.CreateFont;
import cn.menglangpoem.mobile.pojo.CreateImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作服务类
 * @author 孟祥龙
 */
@Service
@Transactional
public class CreateService {
    @Resource
    private CreateImgMapper createImgMapper;
    @Resource
    private CreateFontMapper createFontMapper;

    /**
     * 按照id查询创作模板
     * @param id
     * @return
     */
    public CreateImg selImgById(int id){
        return this.createImgMapper.selById(id);
    }

    /**
     * 按照id查询字体
     * @param id
     * @return
     */
    public CreateFont selFontById(int id){
        return this.createFontMapper.selById(id);
    }

    /**
     * 查询所有创作模板
     * @return
     */
    public List<CreateImg> selAllImg(){
        return this.createImgMapper.selAll();
    }

    /**
     * 查询所有字体
     * @return
     */
    public List<CreateFont> selAllFont(){
        return this.createFontMapper.selAll();
    }
}
