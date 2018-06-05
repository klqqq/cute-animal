package com.cute.java.core.util;

import com.baomidou.mybatisplus.toolkit.IdWorker;

/**
 * 唯一id生成器
 *
 * @author liuqiang
 * @date 2018-05-23 11:10
 */
public class IdGenerator {

    public static String getId() {
        return String.valueOf(IdWorker.getId());
    }

    public static long getIdLong() {
        return IdWorker.getId();
    }
}
