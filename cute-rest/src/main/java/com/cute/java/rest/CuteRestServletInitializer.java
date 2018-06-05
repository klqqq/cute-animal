package com.cute.java.rest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Cute REST Web程序启动类
 *
 * @author liuqiang
 * @date 2018年9月29日09:00:42
 */
public class CuteRestServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CuteRestApplication.class);
    }

}
