package com.cute.java.modular.member.service.impl;

import com.cute.java.core.exception.RRException;
import com.cute.java.core.validator.Assert;
import com.cute.java.modular.member.model.Member;
import com.cute.java.modular.member.dao.MemberMapper;
import com.cute.java.modular.member.service.IMemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-13
 */
@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Override
    public HashMap<String, Object> selectByUsername(HashMap<String, Object> param) {
        String mobile = param.get("username").toString();
        String password = param.get("password").toString();
        HashMap<String,Object> user =  this.baseMapper.selectByUserName(mobile);
        Assert.isNull(user, "用户不存在");

        //密码错误
        String userpassword = DigestUtils.sha256Hex(password);
        if(!user.get("password").equals(userpassword)){
            throw new RRException("密码错误");
        }
        return user;
    }
}
