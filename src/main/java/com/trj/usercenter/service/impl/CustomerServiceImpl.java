package com.trj.usercenter.service.impl;

import com.trj.usercenter.domain.Customer;
import com.trj.usercenter.domain.CustomerCriteria;
import com.trj.usercenter.mapper.CustomerMapper;
import com.trj.usercenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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