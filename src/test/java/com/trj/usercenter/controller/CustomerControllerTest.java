package  com.trj.usercenter.controller;

import com.alibaba.fastjson.JSON;
import com.trj.usercenter.web.CustomerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {


    @Autowired
    private CustomerController  customerController;

    @Test
    public void findById(){
        System.out.println(JSON.toJSONString(customerController.findById(1)));
    }

    @Test
    public void deleteById(){
        System.out.println(JSON.toJSONString(customerController.deleteById(1)));
    }
}