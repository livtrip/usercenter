package com.trj.usercenter.service;

import com.trj.usercenter.domain.*;
/**
 * Customer接口定义
 */
public interface CustomerService {

    Customer findById(Integer id);

    int deleteById(Integer id);

}