package com.lp.utils;

import com.lp.entity.User;

/**
 * @version v1.0
 *
 * @description 在请求执行时 保存用户信息
 *
 * @author lp
 *
 * @since 2022-10-28 16:20
 */

public class UserHolder {
    public static final ThreadLocal<User> tl = new ThreadLocal<User>();

    public static void saveUser(User userDTO){
        tl.set(userDTO);
    }

    public static User getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
