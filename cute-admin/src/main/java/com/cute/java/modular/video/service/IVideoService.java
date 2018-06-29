package com.cute.java.modular.video.service;

import com.baomidou.mybatisplus.service.IService;
import com.cute.java.modular.video.model.Video;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 视频 服务类
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-07
 */
//public interface IVideoService extends IService<Video>{
public interface IVideoService extends IService<com.cute.java.modular.video.model.Video>{

    Video getUrl(@Param("video_id") String video_id);

    int InsertMess(@Param("video_id") String video_id, @Param("video_name") String video_name, @Param("video_url") String video_url,@Param("video_Width") Long video_Width,@Param("video_Height") Long video_Height);}
