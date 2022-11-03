package com.lp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 *
 * @description Department DTO
 *
 * @author lp
 *
 * @since 2022-11-3 11:14
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Integer departmentId;

    private String departmentName;
}
