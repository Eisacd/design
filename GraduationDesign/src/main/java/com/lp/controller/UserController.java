package com.lp.controller;


import com.lp.dto.LoginFormDTO;
import com.lp.dto.Result;
import com.lp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/code")
    public Result sendCode(@RequestParam("phone")String phone , HttpSession session){
        return userService.sendCode(phone , session);
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginFormDTO, HttpSession session){
        return userService.login(loginFormDTO , session);
    }

}
