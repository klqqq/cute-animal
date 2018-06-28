package com.java.cute.rest.modules.app.controller;


import com.google.gson.Gson;
import com.java.cute.rest.common.utils.AppBaseResult;
import com.java.cute.rest.common.utils.SmsUtils;
import com.java.cute.rest.common.validator.Assert;
import com.java.cute.rest.modules.app.service.member.AppMemberService;
import com.java.cute.rest.modules.app.service.user.AppUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 注册
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
public class ApiRegisterController {

    @Resource(name = "appUserService")
    private AppUserService appUserService;

    @Resource(name = "appMemberService")
    private AppMemberService appMemberService;

    /**
     * 注册
     */
    @PostMapping("register")
    public AppBaseResult register(@RequestBody AppBaseResult appBaseResult) throws Exception {
        HashMap<String, Object> pd = new Gson().fromJson(appBaseResult.decryptData().toString(), HashMap.class);

        Assert.isNull(pd.get("username"), "手机号不能为空");
        //Assert.isNull(pd.get("password"), "密码不能为空");
//        String code = getCode();
//        SmsUtils.sendSms((String) pd.get("username"), code);

        String username = pd.get("username").toString();

        HashMap<String, Object> map = appMemberService.queryByUserName(username);
        if (map == null) {
            // 注册
            appMemberService.registerMember(pd);
            return AppBaseResult.success("注册成功");

        }
        //appUserService.save(pd);
        return AppBaseResult.error("注册失败");

    }


    /**
     * 随机生成6位数字作为验证码
     * @return
     */
    public static String getCode(){
        int code=(int)(Math.random()*9000+100000);
        return code + "";
    }
}
