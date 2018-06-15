package com.cute.java.modular.member.dao;

import com.cute.java.modular.member.model.Member;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * <p>
 * 会员 Mapper 接口
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-13
 */
public interface MemberMapper extends BaseMapper<Member> {

    HashMap<String,Object> selectByUserName(@Param("username") String mobile);
}
