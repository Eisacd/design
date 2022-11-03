package com.lp.entity.vo;

import com.lp.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 *
 * @description userVo 类
 *
 * @author lp
 *
 * @since 2022-10-31 21:26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo extends UserDTO {

    /**
     * 一个员工只能属于一个部门
     */
    private String departmentName;

    /**
     * 一个员工只能属于一个岗位
     */
    private String postName;

}
