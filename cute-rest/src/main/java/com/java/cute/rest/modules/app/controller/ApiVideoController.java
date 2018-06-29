package com.java.cute.rest.modules.app.controller;

import com.java.cute.rest.common.utils.AppBaseResult;
import com.java.cute.rest.modules.app.service.video.AppVideoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Api(value = "API - VideoController", description = "视频")
@RestController
@RequestMapping("/app")
public class ApiVideoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "appVideoService")
    private AppVideoService appVideoService;

    @CrossOrigin
    @GetMapping("/video/list")
    public AppBaseResult list(){
        List<HashMap<String, Object>> data = appVideoService.queryList();
        return AppBaseResult.success().setEncryptData(data);
    }

}
