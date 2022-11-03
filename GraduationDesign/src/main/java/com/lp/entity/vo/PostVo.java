package com.lp.entity.vo;

import com.lp.entity.Post;
import com.lp.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @version v1.0
 *
 * @description 岗位VO
 *
 * @author lp
 *
 * @since 2022-11-2
 */

@Data
public class PostVo extends Post {

    /**
     * post user 一对一关系
     */
    private List<User> postUsers;
}
