package com.cute.java.modular.video.util.AliyunVideo;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetMezzanineInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse;
import com.cute.java.modular.video.model.Video;

import java.util.List;

// 每个API都需要引入对应的类，此处以调用GetVideoPlayAuth接口为例

/**
 * Created by daiweitao on 2018/6/29.
 */
public class AliyunVideoAction {
    public static Video GetMessage(String video_id) {
        Video video = new Video();
        DefaultAcsClient client = AliyunVideo.initVodClient("LTAIHpAsgOoCaNGw", "LCqbRmj1AbbBEQCYYK3VLaPehS2IHs");
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        try {
            response = AliyunVideo.getPlayInfo(client,video_id);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                video.setVideo_url(playInfo.getPlayURL());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GetMezzanineInfoResponse res = new GetMezzanineInfoResponse();
        try {
            res = AliyunVideo.getMezzanineInfo(client, video_id);
            video.setVideo_Width(res.getMezzanine().getWidth());
            video.setVideo_Height(res.getMezzanine().getHeight());
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }

        GetVideoInfoResponse re = new GetVideoInfoResponse();

        try {
            re = AliyunVideo.getVideoInfo(client, video_id);
            video.setVideo_name(re.getVideo().getTitle());
            video.setVideo_desc(re.getVideo().getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return video;
    }
}
