package com.trj.usercenter.mapper;

import com.trj.usercenter.domain.Customer;
import com.trj.usercenter.domain.CustomerCriteria;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer, CustomerCriteria, Integer> {
}