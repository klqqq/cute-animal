package com.java.cute.rest.modules.app.service.member.impl;


import com.java.cute.rest.modules.app.dao.member.AppMemberDao;
import com.java.cute.rest.modules.app.service.member.AppMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("appMemberService")
public class AppMemberServiceImpl implements AppMemberService {

    @Autowired
    private AppMemberDao appMemberDao;

    @Override
    public int registerMember(HashMap<String, Object> map) {

        return appMemberDao.registerMember(map);
    }

    @Override
    public HashMap<String, Object> queryByUserName(String username) {
        HashMap<String, Object> map = appMemberDao.queryByUserName(username);
        return map;
    }
}
