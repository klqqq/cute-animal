package com.cute.java.modular.video.util.AliyunVideo;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.exceptions.ClientException;
// 每个API都需要引入对应的类，此处以调用GetVideoPlayAuth接口为例
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;


import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.DefaultAcsClient;
import com.cute.java.modular.video.model.AliyunVideoEntiry;
// 点播服务所在的Region，国内请填cn-shanghai，不要填写别的区域
/**
 * Created by liuqiang on 2018/6/21.
 */
public class AliyunVideo {

    String accessKeyId ="LTAIHpAsgOoCaNGw";
    String accessKeySecret="LCqbRmj1AbbBEQCYYK3VLaPehS2IHs";

    DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", accessKeyId, accessKeySecret);
    GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client) {
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId("视频ID");
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

}
