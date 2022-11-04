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

    /**
     * REGEX 校验
     */

    public static final String REGEX_PHONE = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";


    /**
     * database 数据库
     */

    /**
     * Table post
     */
    public static final String DATABASE_POST_NAME = "post_name";
    public static final String DATABASE_POST_ID = "post_id";

    /**
     * Table department
     */
    public static final String DATABASE_DEPARTMENT_ID = "department_id";
    public static final String DATABASE_DEPARTMENT_NAME = "department_name";

    /**
     * Table user
     */
    public static final String DATABASE_USER_ID = "user_id";
    public static final String DATABASE_USER_Name = "user_name";

    /**
     * Table wage
     */
    public static final String DATABASE_WAGE_ID = "wage_id";
    public static final String DATABASE_WAGE_NAME = "wage_name";

    /**
     * Table attendance
     */
    public static final String DATABASE_ATTENDANCE_ID = "attendance_id";
    public static final String DATABASE_ATTENDANCE_NAME = "attendance_name";
}
