package com.lp.controller;


import com.lp.dto.Result;
import com.lp.service.TestService;
import com.lp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @Resource
    private UserService userService;

    @GetMapping("/{departmentId}")
    public Result test1(@PathVariable("departmentId") Integer departmentId , HttpSession session){
        return userService.getPersonByDepartmentId(departmentId , session);
    }

}
