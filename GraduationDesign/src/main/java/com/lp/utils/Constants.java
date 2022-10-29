package com.lp.utils;

/**
 * @version v1.0
 *
 * @description 常量类
 *
 * @author lp
 *
 * @since 2022-10-28 13:13
 */

public class Constants {
    /**
     * redis code  验证码
     */
    public static final String CODE_PREFIX = "cache:code:";
    public static final Integer CODE_TTL = 5;

    /**
     * redis login token
     */

    public static final String LOGIN_PREFIX = "cache:login:";   //登录缓存前缀
    public static final Integer LOGIN_TTL = 20;                 //token 有效期 在此时间 可凭借token进行登录 无需在此账密登录

    /**
     * ZhenZiSms
     */

    public static final String ZHENZISMS_APIURL = "https://sms_developer.zhenzikj.com";
    public static final String ZHENZISMS_APPID = "112412";
    public static final String ZHENZISMS_APPSECRET = "8af0c8f6-c7d4-4a57-9d8c-cc4c72c12ffc";
    public static final String ZHENZISMS_TEMPLATEID = "10484";
}
