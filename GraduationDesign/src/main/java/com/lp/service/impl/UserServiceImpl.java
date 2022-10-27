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
        System.out.println("----");
        return Result.ok();
    }

    /**
     * @description 用于人员登录登录
     *
     * @param loginFormDTO
     * @param session
     * @return Result 返回 true or false
     */

    @Override
    public Result login(LoginFormDTO loginFormDTO, HttpSession session) {
        return Result.fail("未实现 , 时间 : ");
    }
}
