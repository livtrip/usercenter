package com.trj.usercenter.mapper;

import com.trj.usercenter.domain.User;
import com.trj.usercenter.domain.UserCriteria;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User, UserCriteria, Integer> {
}