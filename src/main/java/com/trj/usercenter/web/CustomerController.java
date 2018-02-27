package com.trj.usercenter.web;
import com.trj.usercenter.domain.Customer;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.trj.usercenter.service.*;
import com.trj.usercenter.tool.Results;
import com.trj.usercenter.tool.Result;

/**
 * Customer 控制器
 */
@RestController
@RequestMapping("/user")
public class CustomerController extends BaseController{


    @Autowired
    private CustomerService customerService;

    /**
     * 根据Id查询Model
     * @param  id 主键
     * @return 模型实体
     */
    @GetMapping("findById")
   public Result<Customer> findById(Integer id) {
        return Results.newSuccessResult(customerService.findById(id));
    }



}
