package com.java.cute.rest.modules.app.controller;
import com.google.gson.Gson;
import com.java.cute.rest.common.utils.AppBaseResult;
import com.java.cute.rest.common.utils.R;
import com.java.cute.rest.common.validator.Assert;
import com.java.cute.rest.modules.app.annotation.AuthIgnore;
import com.java.cute.rest.modules.app.annotation.Login;
import com.java.cute.rest.modules.app.annotation.LoginUser;
import com.java.cute.rest.modules.app.dao.DaoSupport;
import com.java.cute.rest.modules.app.service.ServiceSupport;
import com.java.cute.rest.modules.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * APP测试接口
 *
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/app")
public class ApiTestController {

//    /**
//     * 获取用户信息
//     */
//    @Login
//    @GetMapping("userInfo")
//    public R userInfo(@LoginUser UserEntity user){
//        return R.ok().put("user", user);
//    }
    @Autowired
    private DaoSupport daoSupport;


    @PostMapping("member/userInfo")
    public AppBaseResult userInfo(@RequestBody AppBaseResult appBaseResult){

        HashMap<String,Object> pd = new Gson().fromJson(appBaseResult.decryptData().toString(),HashMap.class);
        String username = pd.get("username").toString();

        HashMap<String,Object> user = null;
        try {
            user = daoSupport.findForObject("app.AppUserDao.queryObject", username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.isNull(user, "用户不存在");

        //密码错误
//        String userpassword = DigestUtils.sha256Hex(password);
//        if(!user.get("password").equals(userpassword)){
//            throw new MCException("密码错误");
//        }
        return AppBaseResult.success().setEncryptData(user);

    }

    /**
     * 获取用户ID
     */
    @Login
    @GetMapping("userId")
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    /**
     * 忽略Token验证测试
     */
    @AuthIgnore
    @GetMapping("notToken")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

}
