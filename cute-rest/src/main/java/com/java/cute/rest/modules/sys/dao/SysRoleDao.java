package com.java.cute.rest.modules.sys.dao;

import com.java.cute.rest.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色管理
 * 
 * @author bnz
 * @email object_bnz@163.com
 * @date 2016年9月18日 上午9:33:33
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
