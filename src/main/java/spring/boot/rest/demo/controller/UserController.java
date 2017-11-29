package spring.boot.rest.demo.controller;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.demo.domain.UserData;
import spring.boot.rest.demo.entity.UserPo;
import spring.boot.rest.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final static String USER = "user";

    @Autowired
    UserService userService;

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, UserPo user, Model model){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            return "redirect:usersPage";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }

    @RequestMapping(value = "ping")
    public DataResult<String> ping() {
        return userService.ping();
    }

    @RequestMapping(value = USER + "/{id}", method = RequestMethod.GET)
    public DataResult<UserData> get(@PathVariable int id) {
        return userService.get(id);
    }

    @RequestMapping(value = USER + "/all", method = RequestMethod.GET)
    public DataResult<List<UserData>> getAll() {
        return userService.getAllUser();
    }

    @RequestMapping(value = USER + "/add", method = RequestMethod.POST)
    public DataResult<UserData> add(@RequestBody UserData user) {
        return userService.addUser(user);
    }
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(UserPo user) {
//        UserData u = userService.selectByUsername(user.getUsername());
//        if(u != null)
//            return "error";
//        try {
//            user.setEnable(1);
//            PasswordHelper passwordHelper = new PasswordHelper();
//            passwordHelper.encryptPassword(user);
//            userService.save(user);
//            return "success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "fail";
//        }
//    }
    @RequestMapping(value = USER + "/batchAdd", method = RequestMethod.POST)
    public DataResult<List<UserData>> batchAdd(@RequestBody List<UserData> users) {
        return userService.addUsers(users);
    }

    @RequestMapping(value = USER + "/update", method = RequestMethod.POST)
    public DataResult<UserData> update(@RequestBody UserData user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = USER + "/delete", method = RequestMethod.POST)
    public DataResult<Integer> delete(@RequestParam(value = "id", defaultValue = "0") int id) {
        return userService.deleteUser(id);
    }
}
