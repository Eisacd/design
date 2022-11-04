package com.lp.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import com.lp.entity.User;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.lp.utils.Constants.LOGIN_PREFIX;
import static com.lp.utils.Constants.LOGIN_TTL;

/**
 * @version v1.0
 *
 * @description 过滤信息 生产redis cache 返回redis key
 */

public class MakeRedisLoginCache {

    private StringRedisTemplate stringRedisTemplate;

    private User user ;

    public MakeRedisLoginCache(StringRedisTemplate stringRedisTemplate , User user){
        this.stringRedisTemplate = stringRedisTemplate;
        this.user = user;
    }

    public String buildRedisCacheAndToken(){

        //将user的信息存入redis
        //形成map
        Map<String,Object> userMap = BeanUtil.beanToMap(user,new HashMap<>(), CopyOptions.create()
                .setIgnoreNullValue(true)
                .setFieldValueEditor((fieldName , fieldValue) -> fieldValue.toString()));

        //形成token uuid
        String token = UUID.randomUUID(true).toString(true);
        //redis cache and cache ttl
        stringRedisTemplate.opsForHash().putAll(LOGIN_PREFIX + token,userMap);
        stringRedisTemplate.expire(LOGIN_PREFIX + token,LOGIN_TTL,TimeUnit.MINUTES);
        return token;
    }
}
