package com.cute.java.modular.video.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cute.java.modular.video.dao.VideoMapper;
import com.cute.java.modular.video.model.Video;
import com.cute.java.modular.video.service.IVideoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 视频 服务实现类
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-07
 */
@Service
//public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService
public class VideoServiceImpl extends ServiceImpl<VideoMapper, com.cute.java.modular.video.model.Video> implements IVideoService
{
    @Override
    public Video getUrl(String video_id) {return this.baseMapper.getUrl(video_id);}

    @Override
    public int InsertMess(String video_id, String video_name, String video_url,Long video_Width,Long video_Height){return this.baseMapper.InsertMess(video_id,video_name,video_url,video_Width,video_Height);}
}
