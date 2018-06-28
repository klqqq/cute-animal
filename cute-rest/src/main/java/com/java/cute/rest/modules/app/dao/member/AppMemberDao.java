package com.java.cute.rest.modules.app.dao.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository("appmemberdao")
public interface AppMemberDao {

    /**
     * 新增用户
     * @param map
     * @return
     */
    int registerMember(HashMap<String, Object> map);

    HashMap<String, Object> queryByUserName(String username);

}
