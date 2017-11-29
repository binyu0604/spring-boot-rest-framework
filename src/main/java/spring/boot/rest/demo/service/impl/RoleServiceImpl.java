package spring.boot.rest.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.rest.common.service.impl.BaseService;
import spring.boot.rest.demo.entity.Role;
import spring.boot.rest.demo.entity.RoleResources;
import spring.boot.rest.demo.service.RoleService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

//    @Resource
//    private RoleMapper roleMapper;
//    @Resource
//    private RoleResourcesMapper roleResourcesMapper;

    @Override
    public List<Role> queryRoleListWithSelected(Integer uid) {
        //return roleMapper.queryRoleListWithSelected(uid);
        return null;
    }

    @Override
    public PageInfo<Role> selectByPage(Role role, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Role.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Role> rolesList = selectByExample(example);
        return new PageInfo<>(rolesList);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {
        //删除角色
        mapper.deleteByPrimaryKey(roleid);
        //删除角色资源
        Example example = new Example(RoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleid);
        //roleResourcesMapper.deleteByExample(example);

    }
}
