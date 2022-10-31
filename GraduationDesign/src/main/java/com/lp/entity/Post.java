package com.lp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 *
 * @description Table post
 *
 * @author lp
 *
 * @since 2022-10-31 13:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @TableId(type = IdType.AUTO)
    private Integer postId;

    private String postName;

    private Integer departmentId;   //属于那个部门
}
