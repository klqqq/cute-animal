package com.cute.java.modular.system.controller;

import com.cute.java.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.cute.java.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.cute.java.modular.system.model.MemberShop;
import com.cute.java.modular.system.service.IMemberShopService;

/**
 * 控制器
 *
 * @author liuqiang
 * @Date 2018-06-05 15:18:20
 */
@Controller
@RequestMapping("/memberShop")
public class MemberShopController extends BaseController {

    private String PREFIX = "/system/memberShop/";

    @Autowired
    private IMemberShopService memberShopService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "memberShop.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/memberShop_add")
    public String memberShopAdd() {
        return PREFIX + "memberShop_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/memberShop_update/{memberShopId}")
    public String memberShopUpdate(@PathVariable Integer memberShopId, Model model) {
        MemberShop memberShop = memberShopService.selectById(memberShopId);
        model.addAttribute("item",memberShop);
        LogObjectHolder.me().set(memberShop);
        return PREFIX + "memberShop_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return memberShopService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(MemberShop memberShop) {
        memberShopService.insert(memberShop);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer memberShopId) {
        memberShopService.deleteById(memberShopId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(MemberShop memberShop) {
        memberShopService.updateById(memberShop);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{memberShopId}")
    @ResponseBody
    public Object detail(@PathVariable("memberShopId") Integer memberShopId) {
        return memberShopService.selectById(memberShopId);
    }
}
