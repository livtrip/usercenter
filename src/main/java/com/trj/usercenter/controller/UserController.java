package com.trj.usercenter.controller;

import com.trj.usercenter.domain.User;
import com.trj.usercenter.mapper.UserMapper;
import com.trj.usercenter.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户控制器
 * @author xierongli
 * @version $$Id: usercenter, v 0.1 18/1/5 下午5:32 mark1xie Exp $$
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    public void test(){
        User user = new User();
        user.setAppKey("32131");
        user.setAppSecret("312313jkdsakdnka");
        user.setName("mark");
        user.setPassword("sadassdsa");
        userMapper.insertSelective(user);
        System.out.println("test");

    }

    @RequestMapping("/add")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView();
        logger.info("add request");
        modelAndView.addObject("email", "apk2sf@163.com");
        modelAndView.setViewName("add");

        return modelAndView;
    }

}
