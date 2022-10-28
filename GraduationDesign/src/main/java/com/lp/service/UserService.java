package com.lp.service;

import com.lp.dto.LoginFormDTO;
import com.lp.dto.Result;

import javax.servlet.http.HttpSession;

/**
 * @version v1.0
 *
 * @description user业务接口
 *
 * @author lp
 *
 * @since 2022-10-27 16:30
 */
public interface UserService {

    Result sendCode(String phone , HttpSession session);

    Result loginByPassword(LoginFormDTO loginFormDTO, HttpSession session);
}
