package com.java.cute.rest.modules.app.dao.video;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository("appvideodao")
public interface AppVideoDao {

    /**
     * 根据videoTd 查询
     * @param videoId
     * @return
     */
    HashMap<String, Object> queryByVideoId(String videoId);

    List<HashMap<String, Object>> queryList();
}
