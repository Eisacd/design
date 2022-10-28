package com.lp.interceptor;

import com.lp.utils.UserHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version v1.0
 *
 * @description 登录拦截器 拦截非法用户 判断UserHolder中是否含有user
 *
 * @author lp
 *
 * @since 2022-10-28 15:04
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.用户是否存在
        if(UserHolder.tl.get() == null){
            //不存在 返回错误
            response.setStatus(401);
        }
        //存在 放行
        return true;
    }
}
