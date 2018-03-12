package com.trj.usercenter.mapper;

import com.trj.mybatis.mapper.BaseMapper;
import com.trj.usercenter.domain.Member;
import com.trj.usercenter.domain.MemberCriteria;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member, MemberCriteria, Integer> {
}