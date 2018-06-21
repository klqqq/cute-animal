package com.cute.java.modular.video.dao;

import com.cute.java.modular.video.model.Video;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * 视频 Mapper 接口
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-07
 */
public interface VideoMapper extends BaseMapper<Video> {

    Video getUrl(@Param("vid") Integer videoId);
}
