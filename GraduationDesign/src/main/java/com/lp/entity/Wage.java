package com.lp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 *
 * @description 薪资表 Table wage
 *
 * @author lp
 *
 * @since 2022-10-31 13:39
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wage {

    private Integer index;

    private Double basicSalary;

}
