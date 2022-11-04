package com.lp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Table wage
 *
 * @version v1.0
 *
 * @author lp
 *
 * @since 2022-11-3
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wage {

    @TableId(type = IdType.AUTO)
    private Integer wageId;

    private Double basicSalary;             //基础工资

    private Integer userId;
}
