package com.lp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lp.dto.Result;
import com.lp.entity.User;
import com.lp.entity.vo.UserVo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @version v1.0
 *
 * @description user mapper 接口 继承 mybatis baseMapper
 *
 * @author lp
 *
 * @since 2022-10-27
 */

public interface UserMapper extends BaseMapper<User> {
    List<UserVo> getAllPersonUseDepartmentName(String departmentName , HttpSession session);
}
