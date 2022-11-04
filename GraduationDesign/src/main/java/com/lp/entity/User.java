package com.lp.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @version v1.0
 *
 * @description 实体类 员工类
 *
 * @author lp
 *
 * @since 2022-10-28 16:21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;         //唯一ID 账号登陆账号

    private String password;    //登陆密码

    private Integer level;        //管理等级： 0：为普通员工  1：为管理人员

    private String name;           //名字

    private String phone;       //电话

    @JsonIgnore
    private Integer departmentId;

    @JsonIgnore
    private Integer postId;

    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)        //插入时进行填充
    private Date createTime;                //创建时间

    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)     //插入与更新时进行填充
    private Date updateTime;                //更新时间

    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;               //被谁创建(记录创建人的id)

    @JsonIgnore
    @TableField(fill = FieldFill.UPDATE)
    private Integer updateBy;               //被谁更新(记录被更新人id)

    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;             //是否被删除

    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private Integer version;                //版本 记录更新版本 版本不同则说明被修改过
}
