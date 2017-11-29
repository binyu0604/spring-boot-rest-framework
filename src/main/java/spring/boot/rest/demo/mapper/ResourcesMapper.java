package spring.boot.rest.demo.mapper;


import spring.boot.rest.common.mapper.MyMapper;
import spring.boot.rest.demo.entity.Resources;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper extends MyMapper<Resources> {

    public List<Resources> queryAll();

    public List<Resources> loadUserResources(Map<String, Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);
}