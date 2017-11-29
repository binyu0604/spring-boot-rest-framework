package spring.boot.rest.demo.service;

import com.github.pagehelper.PageInfo;
import spring.boot.rest.common.service.IService;
import spring.boot.rest.demo.entity.UserPo;

/**
 * Created by yangqj on 2017/4/21.
 */
public interface UserPoService extends IService<UserPo> {
    PageInfo<UserPo> selectByPage(UserPo user , int start , int length);

    UserPo selectByUsername(String username);

    void delUser(Integer userid);

}
