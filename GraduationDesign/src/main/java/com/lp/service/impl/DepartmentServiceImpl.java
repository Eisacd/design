package com.lp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.Result;
import com.lp.entity.Department;
import com.lp.entity.User;
import com.lp.entity.vo.DepartmentVo;
import com.lp.mapper.DepartmentMapper;
import com.lp.mapper.UserMapper;
import com.lp.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @version v1.0
 *
 * @description departmentServiceImpl
 *
 * @author lp
 *
 * @since 2022-10-31 14:11
 */

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper , Department> implements DepartmentService {

    /**
     * @Description 添加部门
     *
     * @param department
     * @return  ture or false
     */

    @Override
    public Result addDepartment(Department department) {
        //判断核心 id name
        if (StrUtil.isBlank(department.getDepartmentName())) {
            return Result.fail("Info error");
        }
        boolean result = save(department);
        //存入是否成功
        if(result == false){
            return Result.fail("已存在");
        }

        return Result.ok();
    }

    /**
     * 获取所有部门信息
     * @return List<Department>
     */

    @Override
    public Result getAllDepartmentInfo() {
        Wrapper wrapper = new QueryWrapper<Department>();
        return Result.ok(list(wrapper),(long)this.count(wrapper));
    }

    /**
     * 凭借部门名 查询部门 部门名应该不一致
     * @param department
     * @return  Department
     */
    @Override
    public Result getOneUseDepartment(Department department) {
        //判断
        String departmentName = department.getDepartmentName();

        if(StrUtil.isBlank(departmentName)){
            return Result.fail("Info error");
        }
        //获取
        Department d = getOne(new QueryWrapper<Department>().eq("department_name",departmentName));
        //是否存在
        if(d == null){
            return Result.fail("无此部门");
        }
        return Result.ok(d);
    }

    /**
     * @description 模糊查询 departments
     * @param department
     * @return  List<Department>
     */
    @Override
    public Result getDepartmentsUseLike(Department department) {
        //判断
        if(department == null){
            return Result.fail("Info error");
        }

        String departmentName = department.getDepartmentName();

        QueryWrapper wrapper = new QueryWrapper<Department>();
        wrapper.like(StrUtil.isBlank(departmentName),"department_name",departmentName);


        List<Department> list = list(wrapper);

        return Result.ok(list);
    }

    /**
     * @description 查询一个部门的所有人
     * @param
     * @return
     */

    @Resource
    private UserMapper userMapper;

    @Override
    public Result getAllPersonForAllDepartmentName() {
        //判断
        List<Department> departmentList = list(new QueryWrapper<Department>());

        List<DepartmentVo> departmentVoList = departmentList.stream().map(department ->{
            DepartmentVo departmentVo = new DepartmentVo();
            BeanUtil.copyProperties(department,departmentVo);
            departmentVo.setUsers(userMapper.selectList(new QueryWrapper<User>().eq("department_id",departmentVo.getDepartmentId())));
            return departmentVo;
        }).collect(Collectors.toList());

        return Result.ok(departmentVoList);
    }
}
