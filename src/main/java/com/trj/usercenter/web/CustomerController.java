package com.trj.usercenter.web;

import org.springframework.web.bind.annotation.GetMapping;
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


   @GetMapping("findById")
   public Result<Customer> findById(Integer id) {
        return Results.newSuccessResult(customerService.findById(id));
   }


   @GetMapping("deleteById")
   public Result<Boolean> deleteById(Integer id){
       int num = customerService.deleteById(id);
       boolean result = num ==1 ?true:false;
       return Results.newSuccessResult(result);
   }



}
