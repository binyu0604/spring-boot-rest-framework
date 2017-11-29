package spring.boot.rest.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by skywing on 2017/4/8.
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/test.html"})
    //@Authorize
    public String test() {
        return "test";
    }

    @RequestMapping(value = {"/index", "/index.html"})
    //@Authorize
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/welcome", "/welcome.html"})
    public String welcome() {
        return "welcome";
    }

}
