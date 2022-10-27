package com.lp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.LoginFormDTO;
import com.lp.dto.Result;
import com.lp.entity.User;
import com.lp.mapper.UserMapper;
import com.lp.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @version v1.0
 *
 * @description user业务实现类
 *
 * @author lp
 *
 * @since 2022-10-27    16:33
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper , User> implements UserService {

    /**
     * @description 发送验证码
     *
     * @param phone
     * @return Result 其中含有验证码
     */

    @Override
    public Result sendCode(String phone , HttpSession session) {
        //1.手机号作为key 验证码作为value 形成缓存


        //2.向电话发送信息 携带验证码

        return Result.ok();
    }

    /**
     * @description 电话为账号 用密码登录
     *
     * @param loginFormDTO
     * @param session
     * @return  true or false
     */

    @Override
    public Result loginByPassword(LoginFormDTO loginFormDTO, HttpSession session) {
        return null;
    }

    /**
     * @description 电话登录 通过电话获取验证码
     *
     * @param phone
     * @param session
     * @return  true or false
     */

    @Override
    public Result loginByPhone(String phone, HttpSession session) {
        return null;
    }
}
