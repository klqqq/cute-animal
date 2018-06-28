package com.java.cute.rest.modules.app.service.video;

import java.util.HashMap;
import java.util.List;

public interface AppVideoService {

    /**
     * 根据视频id返回结果
     * @param videoId
     * @return
     */
    HashMap<String, Object> queryByVideoId(String videoId);

    List<HashMap<String, Object>> queryList();
}
