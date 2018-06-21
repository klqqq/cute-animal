package com.cute.java.modular.video.service.impl;

import com.cute.java.modular.video.model.Video;
import com.cute.java.modular.video.dao.VideoMapper;
import com.cute.java.modular.video.service.IVideoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 视频 服务实现类
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-07
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Resource
    VideoMapper videoDao;

    @Override
    public Video getUrl(Integer videoId) {
        return videoDao.getUrl(videoId);
    }
}
