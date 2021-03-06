package spring.boot.rest.demo.service;

import com.github.pagehelper.PageInfo;
import spring.boot.rest.common.service.IService;
import spring.boot.rest.demo.entity.Resources;

import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface ResourcesService extends IService<Resources> {
    PageInfo<Resources> selectByPage(Resources resources , int start , int length);

    public List<Resources> queryAll();

    public List<Resources> loadUserResources(Map<String, Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);
}
