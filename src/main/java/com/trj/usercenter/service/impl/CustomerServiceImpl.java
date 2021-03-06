package com.trj.usercenter.service.impl;

import com.trj.usercenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Customer接口实现
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }
     @Override
    public int deleteById(Integer id) {
        return customerMapper.deleteByPrimaryKey(id);
    }


}