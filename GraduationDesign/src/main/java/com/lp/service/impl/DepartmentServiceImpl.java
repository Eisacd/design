package com.lp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.entity.Department;
import com.lp.mapper.DepartmentMapper;
import com.lp.service.DepartmentService;
import org.springframework.stereotype.Service;

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
}
