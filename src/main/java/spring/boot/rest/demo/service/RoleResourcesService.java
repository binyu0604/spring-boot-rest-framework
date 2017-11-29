package spring.boot.rest.demo.service;

import spring.boot.rest.common.service.IService;
import spring.boot.rest.demo.entity.RoleResources;

/**
 * Created by yangqj on 2017/4/26.
 */
public interface RoleResourcesService extends IService<RoleResources> {
    public void addRoleResources(RoleResources roleResources);
}
