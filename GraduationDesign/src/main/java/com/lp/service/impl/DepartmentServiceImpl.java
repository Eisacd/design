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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.lp.utils.Constants.*;

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
     * Unit Select
     */
    /**
     * 查询部门
     */
    private Department selectDepartmentById(Department department){
        return getById(department.getDepartmentId());
    }

    private Department selectDepartmentByColumns(Department department){
        Map<String  , Object> map = new HashMap<>();
        BeanUtil.beanToMap(department,map,false,true);
        return getOne(new QueryWrapper<Department>().allEq(map));
    }

    private List<Department> selectDepartmentsByIds(List<Department> list){
        List<Integer> ids = list.stream().map(department -> {
            Integer id = department.getDepartmentId();
            return id;
        }).collect(Collectors.toList());
        return (List<Department>) listByIds(ids);
    }

    /**
     * Unit Add
     */
    private boolean addDepartment(Department department){
        return save(department);
    }

    private boolean addDepartments(List<Department> departments){
        return saveBatch(departments);
    }

    /**
     * Unit Update
     */
    private boolean updateDepartmentById(Department department){
        return updateById(department);
    }

    /**
     * Unit Delete
     */

    private boolean delDepartmentById(Department department){
        return removeById(department.getDepartmentId());
    }

    private boolean delDepartmentsByIds(List<Department> list){
        List<Integer> ids = list.stream().map(department -> {
            Integer id = department.getDepartmentId();
            return id;
        }).collect(Collectors.toList());
        return removeByIds(ids);
    }





    /**
     * @Description 添加部门
     *
     * @param department
     * @return  ture or false
     */

    @Override
    public Result saveDepartment(Department department) {
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
    public Result getAllPersonForAllDepartment() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        //判断
        List<Department> departmentList = list(queryWrapper);

        List<DepartmentVo> departmentVoList = departmentList.stream().map(department ->{
            DepartmentVo departmentVo = new DepartmentVo();
            BeanUtil.copyProperties(department,departmentVo);
            List<User> userList = (userMapper.selectList(new QueryWrapper<User>().eq(DATABASE_DEPARTMENT_ID,departmentVo.getDepartmentId())));
            departmentVo.setDepartmentUsers(userList);
            return departmentVo;
        }).collect(Collectors.toList());

        return Result.ok(departmentVoList);
    }


    /**
     * 添加部门
     */
    private boolean Department(Department department){
        return save(department);
    }
    /**
     * 修改 部门信息
     */
    private boolean updateDepartment(Department department){
        return updateById(department);
    }
    /**
     * 删除部门
     */
    private boolean deleteDepartment(Department department){
        return removeById(department.getDepartmentId());
    }
    /**
     * 查询某个部门
     */
    private Department selectOneForDepartmentsById(Department department){
        return getById(department.getDepartmentId());
    }
    /**
     *根据名字查询部门
     */
    private List<Department> selectOneForDepartmentsByName(Department department){
        return list(new QueryWrapper<Department>().eq(DATABASE_DEPARTMENT_NAME,department.getDepartmentName()));
    }


}
