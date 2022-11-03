package com.lp.controller;


import com.lp.dto.Result;
import com.lp.entity.Department;
import com.lp.mapper.PostMapper;
import com.lp.mapper.UserMapper;
import com.lp.service.DepartmentService;
import com.lp.service.PostService;
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

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PostService postService;

    @GetMapping("/{departmentId}")
    public Result test1(@PathVariable("departmentId") Integer departmentId , HttpSession session){
        return userService.getAllPersonByDepartmentId(departmentId , session);
    }

    @PostMapping("/mapper")
    public Result test2(@RequestParam("departmentName") String departmentName , HttpSession session){
        return userService.getAllPersonUseDepartmentName(departmentName, session);
    }

    @PostMapping("/d")
    public Result test3(@RequestBody Department department){
//        return departmentService.getAllPersonForAllDepartment();
        return postService.getPersonForPost();
    }
}
