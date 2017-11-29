package com.skywing.po;

import lombok.Getter;
import lombok.Setter;
import org.hsweb.web.bean.po.GenericPo;

import javax.validation.constraints.NotNull;

/**
 * Created by skywing on 2017/4/9.
 */
@Getter
@Setter
public class UserInfoPo extends GenericPo<String> {
    @NotNull
    private String username;

    @NotNull
    private int password;

//    private Date createDate;
    public interface Property {
        String username   = "username";
        String password   = "password";
    }
}
