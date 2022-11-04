package com.lp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

    @TableId(type = IdType.AUTO)
    private Integer attendanceId;

    private Integer user_id;

    private Integer leaveEarly;

    private Integer late;

    private Integer absenteeism;
}
