package com.java.cute.rest.modules.app.service.member;

import java.util.HashMap;

public interface AppMemberService {

    /**
     * 新增用户
     * @param map
     * @return
     */
    int registerMember(HashMap<String, Object> map);


    /**
     * 根据手机号查询用户
     * @param username
     * @return
     */
    HashMap<String, Object> queryByUserName(String username);
}
