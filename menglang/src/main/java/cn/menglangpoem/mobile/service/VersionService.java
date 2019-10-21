package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.VersionMapper;
import cn.menglangpoem.mobile.pojo.Version;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class VersionService {
    @Resource
    private VersionMapper versionMapper;

    /**
     * 差U型你所有版本信息
     * @return
     */
    public List<Version> selAll(){
        return this.versionMapper.selAll();
    }
}
