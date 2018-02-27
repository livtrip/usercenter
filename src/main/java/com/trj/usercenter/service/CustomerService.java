package com.trj.usercenter.service;

import com.trj.usercenter.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Customer接口定义
 */
public interface CustomerService {

    Customer findById(Integer id);

    int deleteById(Integer id);


}