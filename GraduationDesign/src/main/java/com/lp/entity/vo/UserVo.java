package com.lp.entity.vo;

import com.lp.entity.User;
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
public class UserVo extends User{

    private String departmentName;

    private String postName;

}
