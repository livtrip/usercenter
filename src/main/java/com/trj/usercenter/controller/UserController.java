package com.trj.usercenter.controller;

import com.trj.usercenter.domain.User;
import com.trj.usercenter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author xierongli
 * @version $$Id: usercenter, v 0.1 18/1/5 下午5:32 mark1xie Exp $$
 */
@RestController
public class UserController extends  BaseController{

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

}
