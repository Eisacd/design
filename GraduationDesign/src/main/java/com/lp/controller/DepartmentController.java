package com.lp.controller;

import com.lp.dto.Result;
import com.lp.entity.Department;
import com.lp.service.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version v1.0
 *
 * @description 部门控制层
 *
 * @author lp
 *
 * @since 2022-11-1 14:44
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 添加部门
     */

    @PostMapping("/add")
    public Result addDepartment(@RequestBody Department department ){
        return departmentService.addDepartment(department);
    }

    /**
     * 获取所有部门信息
     */

    @PostMapping("/getAll")
    public Result getAllDepartmentInfo(){
        return departmentService.getAllDepartmentInfo();
    }

    /**
     * 查找部门 use departmentName
     */

    @PostMapping("/getOneUseDepartment")
    public Result getOneUseDepartment(@RequestBody Department department){
        return departmentService.getOneUseDepartment(department);
    }

    /**
     * 模糊查询 error
     */

    @PostMapping("/getDepartmentsUseLike")
    public Result getDepartmentsLike(@RequestBody Department department){
        return departmentService.getDepartmentsUseLike(department);
    }

    /**
     * 修改某部门
     */

}
