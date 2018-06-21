package com.cute.java.modular.video.service;

import com.cute.java.modular.video.dao.VideoMapper;
import com.cute.java.modular.video.model.Video;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * <p>
 * 视频 服务类
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-07
 */
public interface IVideoService extends IService<Video> {


    Video getUrl(Integer videoId);
}
