package com.lp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.entity.Attendance;
import com.lp.entity.Department;
import com.lp.mapper.AttendanceMapper;
import com.lp.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper , Attendance> implements AttendanceService {

    /**
     * Unit Select
     */
    /**
     * 查询
     */
    private Attendance selectAttendanceById(Attendance attendance){
        return getById(attendance.getAttendanceId());
    }

    private Attendance selectAttendanceByColumns(Attendance attendance){
        Map<String  , Object> map = new HashMap<>();
        BeanUtil.beanToMap(attendance,map,false,true);
        return getOne(new QueryWrapper<Attendance>().allEq(map));
    }


    private List<Attendance> selectAttendancesByIds(List<Attendance> list){
        List<Integer> ids = list.stream().map(attendance -> {
            Integer id = attendance.getAttendanceId();
            return id;
        }).collect(Collectors.toList());
        return (List<Attendance>) listByIds(ids);
    }

    /**
     * Unit Add
     */
    private boolean addAttendance(Attendance attendance){
        return save(attendance);
    }

    private boolean addAttendances(List<Attendance> attendances){
        return saveBatch(attendances);
    }

    /**
     * Unit Update
     */
    private boolean updateAttendanceById(Attendance attendance){
        return updateById(attendance);
    }

    /**
     * Unit Delete
     */

    private boolean delAttendanceById(Attendance attendance){
        return removeById(attendance.getAttendanceId());
    }

    private boolean delAttendances(List<Attendance> list){
        List<Integer> ids = list.stream().map(attendance -> {
            Integer id = attendance.getAttendanceId();
            return id;
        }).collect(Collectors.toList());
        return removeByIds(ids);
    }

}
