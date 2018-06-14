package com.cute.java.modular.user.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.cute.java.core.util.PageUtils;
import com.cute.java.core.util.Query;
import com.cute.java.core.util.R;
import com.cute.java.modular.user.entity.UserEntity;
import com.cute.java.modular.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:user:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		query.isPaging(true);
		List<UserEntity> userList = userService.queryList(query);
		PageUtils pageUtil = new PageUtils(userList, query.getTotle(), query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("user:user:info")
	public R info(@PathVariable("userId") Long userId){
		UserEntity user = userService.queryObject(userId);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:user:save")
	public R save(@RequestBody UserEntity user){
		userService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:user:update")
	public R update(@RequestBody UserEntity user){
		userService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:user:delete")
	public R delete(@RequestBody Long[] userIds){
		userService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
