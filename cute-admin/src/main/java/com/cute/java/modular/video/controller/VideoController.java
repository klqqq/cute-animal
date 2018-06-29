package com.cute.java.modular.video.controller;

import com.cute.java.core.base.controller.BaseController;
import com.cute.java.core.log.LogObjectHolder;
import com.cute.java.core.util.AppBaseResult;
import com.cute.java.modular.video.model.Video;
import com.cute.java.modular.video.service.IVideoService;
import com.cute.java.modular.video.util.AliyunVideo.AliyunVideoAction;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 视频控制器
 *
 * @author liuqiang
 * @Date 2018-06-07 10:40:49
 */
@Controller
@RequestMapping("/video")
public class VideoController extends BaseController {

    private String PREFIX = "/video/video/";

    @Autowired
    private IVideoService videoService;

    /**
     * 跳转到视频首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "video.html";
    }

    /**
     * 跳转到添加视频
     */
    @RequestMapping("/video_add")
    public String videoAdd() {
        return PREFIX + "video_add.html";
    }

    /**
     * 获取播放凭证
     * 再说
     */

    /**
     * 得到客户端的视频ID
     * Request：客户端的视频信息（title ,描述，vid....）
     * 通过vid从阿里云服务器上获取该视频的其他信息，url
     * 保存到数据库
     * 返回保存成功
     */



    /**
     * 客户端拿ID来得到视频的url
     * 从数据库中得到
     */
    @ApiOperation(value = "url", notes = "获取视频url")
    @ResponseBody
    @RequestMapping(value = "/getVideoUrl/{video_id}", method = RequestMethod.POST)
    public AppBaseResult getVideoUrl(@PathVariable String video_id){
        //获取Url
        /*Long video_Width = null;
        Long video_Height = null;
        String video_url = null,video_FileURL = null,video_name = null,video_desc = null;
        DefaultAcsClient client = AliyunVideo.initVodClient("LTAIHpAsgOoCaNGw","LCqbRmj1AbbBEQCYYK3VLaPehS2IHs");
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        try {
            response = AliyunVideo.getPlayInfo(client,video_id);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                 video_url =playInfo.getPlayURL();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GetMezzanineInfoResponse res = new GetMezzanineInfoResponse();
        try {
            res = AliyunVideo.getMezzanineInfo(client,video_id);
            video_FileURL = res.getMezzanine().getFileURL();
            video_Width = res.getMezzanine().getWidth();
            video_Height = res.getMezzanine().getHeight();
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }

        GetVideoInfoResponse re = new GetVideoInfoResponse();

        try {
            re =AliyunVideo.getVideoInfo(client,video_id);
            video_name=re.getVideo().getTitle();
            video_desc = re.getVideo().getDescription();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Video sp = new Video();
        sp = AliyunVideoAction.GetMessage(video_id);
        int a = videoService.InsertMess(video_id,sp.getVideo_name(),sp.getVideo_url(),sp.getVideo_Width(),sp.getVideo_Height());
        Video video = videoService.getUrl(video_id);
        String url =video.getVideo_url();
        return AppBaseResult.success(url);

    }

    /**
     * 跳转到修改视频
     */
    @RequestMapping("/video_update/{videoId}")
    public String videoUpdate(@PathVariable Integer videoId, Model model) {
        Video video = videoService.selectById(videoId);
        model.addAttribute("item",video);
        LogObjectHolder.me().set(video);
        return PREFIX + "video_edit.html";
    }

    /**
     * 获取视频列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return videoService.selectList(null);
    }

    /**
     * 新增视频
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Video video) {
        videoService.insert(video);
        return SUCCESS_TIP;
    }

    /**
     * 删除视频
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer videoId) {
        videoService.deleteById(videoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改视频
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Video video) {
        videoService.updateById(video);
        return SUCCESS_TIP;
    }

    /**
     * 视频详情
     */
    @RequestMapping(value = "/detail/{videoId}")
    @ResponseBody
    public Object detail(@PathVariable("videoId") Integer videoId) {
        return videoService.selectById(videoId);
    }
}
