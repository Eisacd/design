package com.lp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.entity.Attendance;
import com.lp.mapper.AttendanceMapper;
import com.lp.service.AttendanceService;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper , Attendance> implements AttendanceService {
}
