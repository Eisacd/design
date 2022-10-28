package com.lp.utils;

import com.lp.dto.UserDTO;

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
    public static final ThreadLocal<UserDTO> tl = new ThreadLocal<UserDTO>();

    public static void saveUser(UserDTO userDTO){
        tl.set(userDTO);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
