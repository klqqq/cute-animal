package com.cute.java.modular.video.controller;

import com.cute.java.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.cute.java.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.cute.java.modular.video.model.Video;
import com.cute.java.modular.video.service.IVideoService;

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
