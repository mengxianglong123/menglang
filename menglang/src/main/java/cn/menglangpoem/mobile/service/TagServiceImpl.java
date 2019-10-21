package cn.menglangpoem.mobile.service;

import cn.menglangpoem.mobile.mapper.TagMapper;
import cn.menglangpoem.mobile.pojo.Tag;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;
    @Override
    public List<Tag> selHot() {
        return this.tagMapper.selHot();
    }

    @Override
    public List<Tag> selAll() {
        return this.tagMapper.selAll();
    }
}
