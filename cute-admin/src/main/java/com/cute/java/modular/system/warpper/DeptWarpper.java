package com.cute.java.modular.system.warpper;

import com.cute.java.core.common.constant.factory.ConstantFactory;
import com.cute.java.core.base.warpper.BaseControllerWarpper;
import com.cute.java.core.util.ToolUtil;

import java.util.Map;

/**
 * 部门列表的包装
 *
 * @author liuqiang
 * @date 2018年4月25日 18:10:31
 */
public class DeptWarpper extends BaseControllerWarpper {

    public DeptWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {

        Integer pid = (Integer) map.get("pid");

        if (ToolUtil.isEmpty(pid) || pid.equals(0)) {
            map.put("pName", "--");
        } else {
            map.put("pName", ConstantFactory.me().getDeptName(pid));
        }
    }

}
