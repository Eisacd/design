package com.lp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 *
 * @description Post DTO
 *
 * @author lp
 *
 * @since 2022-11-3 11:14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Integer postId;

    private String postName;

    private Integer departmentId;   //属于那个部门
}
