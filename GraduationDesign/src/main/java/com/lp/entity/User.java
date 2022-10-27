package com.lp.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;         //唯一ID 账号登陆账号

    private String password;    //登陆密码

    private Integer level;        //管理等级： 0：为普通员工  1：为管理人员

    private String name;           //名字

    @TableField(fill = FieldFill.INSERT)        //插入时进行填充
    private Date createTime;                //创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)     //插入与更新时进行填充
    private Date updateTime;                //更新时间

    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;               //被谁创建(记录创建人的id)

    @TableField(fill = FieldFill.UPDATE)
    private Integer updateBy;               //被谁更新(记录被更新人id)

    @TableField(fill = FieldFill.INSERT)
    private Integer deleteFlag;             //是否被删除

    @TableField(fill = FieldFill.INSERT)
    private Integer version;                //版本 记录更新版本 版本不同则说明被修改过
}
