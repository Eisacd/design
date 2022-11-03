package com.lp.entity.vo;

import com.lp.dto.DepartmentDTO;
import com.lp.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentVo extends DepartmentDTO {

    private List<User> departmentUsers;

}
