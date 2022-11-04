package com.lp.entity.vo;

import com.lp.entity.Attendance;
import com.lp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceVo extends Attendance {
    private User attendanceUser;
}
