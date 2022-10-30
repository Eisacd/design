package com.lp.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.lp.dto.UserDTO;
import com.lp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.lp.utils.Constants.LOGIN_PREFIX;
import static com.lp.utils.Constants.LOGIN_TTL;

/**
 * @version v1.0
 *
 * @description token TTL刷新 维持用户登录时效
 *
 * @author lp
 *
 * @since 2022-10-28 15:07
 */

public class RefreshTokenInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取token
        String token = request.getHeader("token");
        //判断 是否为空
        if(StrUtil.isBlank(token)){
            //为空
            //放行 如果时非法用户让登录拦截器拦截
            return true;
        }
        //存在
        //获取用户 提取信息
        Map<Object , Object> map =  stringRedisTemplate.opsForHash().entries(LOGIN_PREFIX + token);
        //判断是否存在用户
        if(map.isEmpty()){
            //不存在用户 放行
            return true;
        }
        //存在用户 将对缓存进行刷新
        //将map装还我userDTO
        UserDTO userDTO = BeanUtil.fillBeanWithMap(map,new UserDTO(),false);

        //进行缓存
        UserHolder.saveUser(userDTO);
        //刷新token有效时间
        stringRedisTemplate.expire(LOGIN_PREFIX + token , LOGIN_TTL , TimeUnit.MINUTES);
        //放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //移除用户
        UserHolder.removeUser();
    }
}
