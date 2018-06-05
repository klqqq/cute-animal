package com.cute.java.core.util;

import com.cute.java.config.properties.CuteProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(CuteProperties.class).getKaptchaOpen();
    }
}