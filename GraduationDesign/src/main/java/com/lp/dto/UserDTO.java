package com.lp.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 *
 * @description userInfo
 *
 * @author lp
 *
 * @since 2022-10-28 16:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;         //唯一ID 账号登陆账号

    private String password;    //登陆密码

    private Integer level;        //管理等级： 0：为普通员工  1：为管理人员

    private String name;           //名字

    private String phone;

    private Integer departmentId;

    private Integer postId;

}
