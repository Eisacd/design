package com.lp.utils;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lp.utils.Constants.REGEX_PHONE;

/**
 * @version v1.0
 *
 * @description
 *
 * @author lp
 *
 * @since 2022-10-29 16:19
 */

public class CheckPhone {

    public static boolean isPhone(String phone){
        //是否为空
        if(StrUtil.isBlank(phone)){
            //true 空 返回false
            return false;
        }
        //不为空
        //正则表达式筛选掉错误的phone
        //创建一个用于对比的正则表达式模板
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        //添加对比对象
        Matcher matcher = pattern.matcher(phone);
        if(!matcher.matches()){
            //不符合 return false
            return false;
        }
        //符合 true
        return true;
    }

}
