package spring.boot.rest.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import spring.boot.rest.common.service.impl.BaseService;
import spring.boot.rest.demo.entity.Resources;
import spring.boot.rest.demo.service.ResourcesService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
@Service("resourcesService")
public class ResourcesServiceImpl extends BaseService<Resources> implements ResourcesService {
   //@Resource
   // private ResourcesMapper resourcesMapper;

    @Override
    public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Resources.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Resources> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public List<Resources> queryAll(){
        //return resourcesMapper.queryAll();
        return null;
    }

    @Override
    @Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<Resources> loadUserResources(Map<String, Object> map) {
        //return resourcesMapper.loadUserResources(map);
        return null;
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        //return resourcesMapper.queryResourcesListWithSelected(rid);
        return null;
    }
}
