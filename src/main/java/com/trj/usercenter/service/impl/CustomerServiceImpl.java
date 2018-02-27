package com.trj.usercenter.service.impl;

import com.trj.usercenter.domain.Customer;
import com.trj.usercenter.mapper.CustomerMapper;
import com.trj.usercenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Customer 接口实现层
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }
}