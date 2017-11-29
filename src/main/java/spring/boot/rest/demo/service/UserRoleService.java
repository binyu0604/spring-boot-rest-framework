package spring.boot.rest.demo.service;


import spring.boot.rest.common.service.IService;
import spring.boot.rest.demo.entity.UserRole;

/**
 * Created by yangqj on 2017/4/26.
 */
public interface UserRoleService extends IService<UserRole> {

    public void addUserRole(UserRole userRole);
}
