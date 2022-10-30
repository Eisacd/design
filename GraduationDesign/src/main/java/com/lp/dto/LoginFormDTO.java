package com.lp.dto;

import lombok.Data;

/**
 * @version v1.0
 *
 * @description 登录数据类 loginFormDTO  只传输登录所需的数据 防止被人获取其他数据
 *
 * @author lp
 *
 * @since 2022-10-27
 */
@Data
public class LoginFormDTO {

    private String phone;

    private String password;

    private String code;
}
