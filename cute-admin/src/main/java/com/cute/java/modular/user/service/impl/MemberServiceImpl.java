package com.cute.java.modular.user.service.impl;

import com.cute.java.modular.system.model.Member;
import com.cute.java.modular.system.dao.MemberMapper;
import com.cute.java.modular.user.service.IMemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-13
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
