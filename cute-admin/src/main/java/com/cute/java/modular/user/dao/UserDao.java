package com.cute.java.modular.user.dao;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cute.java.modular.user.entity.UserEntity;

/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    UserEntity queryByMobile(String mobile);
}
