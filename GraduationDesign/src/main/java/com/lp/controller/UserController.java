package com.lp.controller;


import com.lp.dto.LoginFormDTO;
import com.lp.dto.Result;
import com.lp.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @version v1.0
 *
 * @description userController 员工控制层  登录相关功能
 *
 * @author lp
 *
 * @since 2022-10-28 16:23
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/code")
    public Result sendCode(@RequestParam("phone") String phone , HttpSession session) throws Exception {
        return userService.sendCode(phone , session);
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginFormDTO, HttpSession session){
        return userService.loginByCode(loginFormDTO , session);
    }

}
