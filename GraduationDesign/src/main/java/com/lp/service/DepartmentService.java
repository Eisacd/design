package com.lp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.Result;
import com.lp.entity.Department;
import com.lp.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 *
 * @description departmenService
 *
 * @author lp
 *
 * @since 2022-10-31 14:09
 */

public interface DepartmentService {
    Result addDepartment(Department department);

    Result getAllDepartmentInfo();

    Result getOneUseDepartment(Department department);

    Result getDepartmentsUseLike(Department department);
}
