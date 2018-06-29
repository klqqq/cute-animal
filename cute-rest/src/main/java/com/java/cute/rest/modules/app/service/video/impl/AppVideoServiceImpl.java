package com.java.cute.rest.modules.app.service.video.impl;

import com.java.cute.rest.modules.app.dao.video.AppVideoDao;
import com.java.cute.rest.modules.app.service.video.AppVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("appVideoService")
public class AppVideoServiceImpl implements AppVideoService {

    @Autowired
    private AppVideoDao appVideoDao;

    /**
     * 根据id 查询
     * @param videoId
     * @return
     */
    @Override
    public HashMap<String, Object> queryByVideoId(String videoId) {

        HashMap<String, Object> map = appVideoDao.queryByVideoId(videoId);
        return map;
    }

    /**
     * 查询所有视频
     * @return
     */
    @Override
    public List<HashMap<String, Object>> queryList() {
        return appVideoDao.queryList();
    }
}
