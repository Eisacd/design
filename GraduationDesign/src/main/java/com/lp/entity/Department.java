package com.lp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lp.entity.vo.UserVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version v1.0
 *
 * @description Table department
 *
 * @author lp
 *
 * @since 2022-10-31 12:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @TableId(type = IdType.AUTO)
    private Integer departmentId;

    private String departmentName;

}
