package com.java.cute.rest.modules.app.controller;

import com.google.gson.Gson;
import com.java.cute.rest.common.utils.AppBaseResult;
import com.java.cute.rest.modules.app.service.user.AppUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Api(value = "API - MemberController", description = "会员管理")
@RestController
@RequestMapping("/app")
public class ApiMemberController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "appUserService")
    private AppUserService appUserService;

    /**
    * 会员
    */
    @CrossOrigin
    @ApiOperation(value = "列表", notes = "会员列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "query", defaultValue = "")})
    @PostMapping("/member/list")
    public AppBaseResult list(@RequestBody AppBaseResult appBaseResult) throws Exception {
        logger.info("Member 信息", appBaseResult.decryptData());
        HashMap<String, Object> params = new Gson().fromJson(appBaseResult.decryptData().toString(), HashMap.class);
        List<HashMap<String, Object>> data = appUserService.queryList(params);
        return AppBaseResult.success().setEncryptData(data);
    }

}

