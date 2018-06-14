package com.cute.java.modular.user.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import com.cute.java.core.exception.RRException;
import com.cute.java.core.validator.Assert;
import com.cute.java.modular.user.dao.UserDao;
import com.cute.java.modular.user.entity.UserEntity;
import com.cute.java.modular.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity queryObject(Long userId){
		return null;
	}

	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return null;
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return 0;
	}

	@Override
	public void save(UserEntity userEntity){
		userEntity.setPassword(DigestUtils.sha256Hex(userEntity.getPassword()));
		userEntity.setCreateTime(new Date());
	}

	@Override
	public void save(String mobile, String password) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		userEntity.setPassword(password);
		userEntity.setPassword(DigestUtils.sha256Hex(userEntity.getPassword()));
		userEntity.setCreateTime(new Date());

	}

	@Override
	public void update(UserEntity user){

	}

	@Override
	public void delete(Long userId){

	}

	@Override
	public void deleteBatch(Long[] userIds){

	}

	@Override
	public UserEntity queryByMobile(String mobile) {
		return userDao.queryByMobile(mobile);
	}

	@Override
	public long login(String mobile, String password) {
		UserEntity user = queryByMobile(mobile);
		Assert.isNull(user, "用户不存在");

		//密码错误
		String userpassword = DigestUtils.sha256Hex(password);
		if(!user.getPassword().equals(userpassword)){
			throw new RRException("密码错误");
		}

		return user.getUserId();
	}

}
