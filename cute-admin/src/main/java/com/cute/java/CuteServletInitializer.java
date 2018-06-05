package com.cute.java;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Cute Web程序启动类
 *
 * @author liuqiang
 * @date 2018-05-21 9:43
 */
public class CuteServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CuteApplication.class);
    }
}
