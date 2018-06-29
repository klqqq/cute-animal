package com.java.cute.rest.common.validator;

import com.java.cute.rest.common.exception.MCException;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据校验
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new MCException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new MCException(message);
        }
    }
    public static boolean checkCellphone(String cellphone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        return check(cellphone, regex);
    }
    static boolean flag = false;
    public static boolean check(String str, String regex) {
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
