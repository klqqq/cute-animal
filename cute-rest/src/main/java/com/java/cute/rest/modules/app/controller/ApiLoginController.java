package com.java.cute.rest.modules.app.controller;


import com.google.gson.Gson;
import com.java.cute.rest.common.utils.AppBaseResult;
import com.java.cute.rest.common.validator.Assert;
import com.java.cute.rest.modules.app.service.user.AppUserService;
import com.java.cute.rest.modules.app.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * APP登录授权
 *
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-03-23 15:31
 */

@RestController
@RequestMapping("/app")
public class ApiLoginController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "appUserService")
    private AppUserService appUserService;
    @Autowired
    private JwtUtils jwtUtils;

    @ApiOperation(value = "用户登录", notes = "用户登录后返回token和用户信息", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 401, message = "token失效"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @CrossOrigin
    @PostMapping("login")
    public AppBaseResult login(@RequestBody AppBaseResult appBaseResult) throws Exception {
        logger.info("用户登录",appBaseResult.decryptData());
        HashMap<String,Object> pd = new Gson().fromJson(appBaseResult.decryptData().toString(),HashMap.class);
        Assert.isNull(pd.get("username"), "手机号不能为空");
        //Assert.isNull(pd.get("password"), "密码不能为空");
//        if (!Assert.checkCellphone(pd.get("mobile").toString())){
//            throw new MCException("请输入正确的手机号");
//        }

        //用户登录
        HashMap<String,Object> user = appUserService.queryByMobile(pd);
        //生成token
        String token = jwtUtils.generateToken(user.get("username"));
        user.put("token", token);
        user.put("expire", jwtUtils.getExpire());
        return AppBaseResult.success().setEncryptData(user);
    }

}
