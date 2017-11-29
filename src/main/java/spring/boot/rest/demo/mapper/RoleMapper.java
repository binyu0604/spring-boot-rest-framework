package spring.boot.rest.demo.mapper;


import spring.boot.rest.common.mapper.MyMapper;
import spring.boot.rest.demo.entity.Role;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);
}