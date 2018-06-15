package com.cute.java.modular.member.service;

import com.cute.java.modular.member.model.Member;
import com.baomidou.mybatisplus.service.IService;

import java.util.HashMap;

/**
 * <p>
 * 会员 服务类
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-13
 */
public interface IMemberService extends IService<Member> {

    HashMap<String,Object> selectByUsername(HashMap<String, Object> pd);
}
