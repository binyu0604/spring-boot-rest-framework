package spring.boot.rest.demo.mapper;


import spring.boot.rest.common.mapper.MyMapper;
import spring.boot.rest.demo.entity.UserRole;

import java.util.List;

public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);
}