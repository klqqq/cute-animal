package com.cute.java.modular.video.util.AliyunVideo;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.*;
import com.cute.java.modular.video.model.AliyunVideoEntiry;
import com.aliyuncs.vod.model.v20170321.GetVideoInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;


// 每个API都需要引入对应的类，此处以调用GetVideoPlayAuth接口为例
// 点播服务所在的Region，国内请填cn-shanghai，不要填写别的区域
/**
 * Created by liuqiang on 2018/6/21.
 */
public class AliyunVideo {
    GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client,String video_id) {
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(video_id);
        GetVideoPlayAuthResponse response = null;
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            throw new RuntimeException("GetVideoPlayAuthRequest Server failed");
        } catch (ClientException e) {
            throw new RuntimeException("GetVideoPlayAuthRequest Client failed");
        }
        response.getPlayAuth();              // 播放凭证
        response.getVideoMeta();             // 视频Meta信息
        return response;
    }

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {
        //点播服务所在的Region，国内请填cn-shanghai，不要填写别的区域
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    /*获取上传地址和凭证函数*/
    public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client, AliyunVideoEntiry aliyunVideo) throws Exception {
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle(aliyunVideo.getTitle());
        request.setDescription(aliyunVideo.getDescription());
        request.setFileName(aliyunVideo.getFileName());
        request.setTags(aliyunVideo.getTags());
        request.setCoverURL(aliyunVideo.getCoverURL());
        return client.getAcsResponse(request);
    }

    /*获取视频信息函数*/
    public static GetVideoInfoResponse getVideoInfo(DefaultAcsClient client,String video_id) throws Exception {
        GetVideoInfoRequest request = new GetVideoInfoRequest();
        request.setVideoId(video_id);
        return client.getAcsResponse(request);
    }

    /*修改视频信息函数*/
    public static UpdateVideoInfoResponse updateVideoInfo(DefaultAcsClient client) throws Exception {
        UpdateVideoInfoRequest request = new UpdateVideoInfoRequest();
        request.setTitle("New Title");
        request.setDescription("New Description");
        request.setTags("new 标签1,new 标签2");
        return client.getAcsResponse(request);
    }

    /*删除视频函数*/
    public static DeleteVideoResponse deleteVideo(DefaultAcsClient client) throws Exception {
        DeleteVideoRequest request = new DeleteVideoRequest();
        //多个用逗号分隔，最多支持20个
        request.setVideoIds("视频ID1,视频ID2");
        return client.getAcsResponse(request);
    }
    /*以下为调用示例*/
    public static void main(String[] argv) {
        String accessKeyId ="LTAIHpAsgOoCaNGw";
        String accessKeySecret="LCqbRmj1AbbBEQCYYK3VLaPehS2IHs";
        DefaultAcsClient client = initVodClient(accessKeyId, accessKeySecret);
        DeleteVideoResponse response = new DeleteVideoResponse();
        try {
            response = deleteVideo(client);
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
    }


    /*根据Date时间生成UTC时间函数*/
    public static String generateUTCTime(Date time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
        dateFormat.setLenient(false);
        return dateFormat.format(time);
    }
    /*获取视频列表函数*/
    public static GetVideoListResponse getVideoList(DefaultAcsClient client) throws Exception {
        GetVideoListRequest request = new GetVideoListRequest();
        // 分别取一个月前、当前时间的UTC时间作为筛选视频列表的起止时间
        String monthAgoUTCTime = generateUTCTime(new Date(System.currentTimeMillis() - 30 * 86400L));
        String nowUTCTime = generateUTCTime(new Date(System.currentTimeMillis()));
        // 视频创建的起始时间，为UTC格式
        request.setStartTime(monthAgoUTCTime);
        // 视频创建的结束时间，为UTC格式
        request.setEndTime(nowUTCTime);
        // 视频状态，默认获取所有状态的视频，多个用逗号分隔
        // request.setStatus("Uploading,Normal,Transcoding");
        request.setPageNo(1L);
        request.setPageSize(20L);
        return client.getAcsResponse(request);
    }

    /*获取播放地址函数*/
    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client,String video_id) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(video_id);
        return client.getAcsResponse(request);
    }

    /*获取源文件信息函数*/
    public static GetMezzanineInfoResponse getMezzanineInfo(DefaultAcsClient client,String video_id) throws Exception {
        GetMezzanineInfoRequest request = new GetMezzanineInfoRequest();
        request.setVideoId(video_id);
        //源片下载地址过期时间
        request.setAuthTimeout(3600L);
        return client.getAcsResponse(request);
    }


}
