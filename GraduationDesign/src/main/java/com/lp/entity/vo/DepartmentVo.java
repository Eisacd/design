package com.lp.entity.vo;

import com.lp.entity.Department;
import com.lp.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentVo extends Department {

    private List<User> departmentUsers;

}
