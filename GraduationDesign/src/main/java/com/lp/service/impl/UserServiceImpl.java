package com.lp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.LoginFormDTO;
import com.lp.dto.Result;
import com.lp.dto.UserDTO;
import com.lp.entity.User;
import com.lp.entity.vo.UserVo;
import com.lp.mapper.UserMapper;
import com.lp.service.UserService;
import com.lp.utils.CheckPhone;
import com.lp.utils.MakeRedisLoginCache;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.lp.utils.Constants.*;

/**
 * @version v1.1
 *
 * @description user业务实现类
 *
 * @author lp
 *
 * @since 2022-10-27    16:33
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper , User> implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @description 发送验证码
     *
     * @param phone
     * @return Result 其中含有验证码
     */

    @Override
    public Result sendCode(String phone , HttpSession session){
        //1.手机号作为key 验证码作为value 形成缓存
        //1.1 校验是否符合正规手机号
        if(!CheckPhone.isPhone(phone)){
            //不符合
            return Result.fail("phone error");
        }
        //1.2 生产验证码 进行redis缓存
        String code = RandomUtil.randomNumbers(6);
        stringRedisTemplate.opsForValue().set(CODE_PREFIX + phone,code,CODE_TTL, TimeUnit.MINUTES);
        //2.向电话发送信息 携带验证码
        //2.1 实例化 ZhenziSmsClient
        ZhenziSmsClient client = new ZhenziSmsClient(ZHENZISMS_APIURL,ZHENZISMS_APPID,ZHENZISMS_APPSECRET);
        //2.2 准备信息参数
        Map<String , Object> params = new HashMap<>();
        params.put("number",phone);
        params.put("templateId",ZHENZISMS_TEMPLATEID);
        String[] templateParams = new String[2];
        templateParams[0] = code;
        templateParams[1] = CODE_TTL.toString();
        params.put("templateParams",templateParams);
        try {
            //发送
            String result = client.send(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.ok(code);
    }

    /**
     * @description 电话为账号 用密码登录
     *
     * @param loginFormDTO
     * @param session
     * @return  true or false and token
     */

    @Override
    public Result loginByPassword(LoginFormDTO loginFormDTO, HttpSession session) {
        //校验电话 密码
        String phone = loginFormDTO.getPhone();
        String password = loginFormDTO.getPassword();

        //根据手机好 密码 查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        User user = getOne(queryWrapper.eq("phone",phone).eq("password",password));

        // 判断是否存在
        if(user == null){
            return Result.fail("无此用户");
        }

        String token = new MakeRedisLoginCache(stringRedisTemplate,user).buildRedisCacheAndToken();

        return Result.ok(token);
    }

    /**
     * @description 手机号获取验证码 手机号 + 验证码 进行登录
     *
     * @param loginFormDTO
     * @param session
     * @return true or false and token
     */

    @Override
    public Result loginByCode(LoginFormDTO loginFormDTO, HttpSession session) {
        //判断手机号与code是否为空
        String phone = loginFormDTO.getPhone();
        String code = loginFormDTO.getCode();
        if(StrUtil.isBlank(phone) || StrUtil.isBlank(code)){
            return Result.fail("Info error");
        }
        //根据手机号获取redis
        String codeCache = stringRedisTemplate.opsForValue().get(CODE_PREFIX + loginFormDTO.getPhone());

        if(StrUtil.isBlank(codeCache)){
            return Result.fail("no have codeCache");
        }
        //对比code
        if(!code.equals(codeCache)){
            Result.fail("code error");
        }
        //登陆成功 记录信息
        User user = getOne(new QueryWrapper<User>().eq("phone",phone));

        if(user == null){
            return Result.fail("understand error");
        }

        String token = new MakeRedisLoginCache(stringRedisTemplate,user).buildRedisCacheAndToken();

        //返回token 前端访问需此
        return Result.ok(token);
    }

    @Override
    public Result getPersonByDepartmentId(Integer departmentId, HttpSession session) {
        //判断
        if(departmentId == null){
            return Result.fail("department error");
        }
        //从数据库获取数据
        List<Map<String,Object>> list = listMaps(new QueryWrapper<User>().eq("department_id", departmentId));
        //过滤一些数据
        List<UserDTO> listUserDTO = new ArrayList<>();

        UserDTO userDTO;

        for(Map<String,Object> map : list){
            userDTO = BeanUtil.fillBeanWithMap(map,new UserDTO(),false);
            listUserDTO.add(userDTO);
        }
        return Result.ok(listUserDTO);
    }

    @Resource
    private UserMapper userMapper;

    @Override
    public Result getAllPersonUseDepartmentName(String departmentName, HttpSession session) {
        List<UserVo> userVoList = userMapper.getAllPersonUseDepartmentName(departmentName, session);
        return Result.ok(userVoList);
    }
}
