package com.lp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.Result;
import com.lp.entity.User;
import com.lp.entity.Wage;
import com.lp.entity.vo.WageVo;
import com.lp.mapper.UserMapper;
import com.lp.mapper.WageMapper;
import com.lp.service.WageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WageServiceImpl extends ServiceImpl<WageMapper , Wage> implements WageService {

    @Resource
    private UserMapper userMapper;


    /**
     * 获取所有有工资条的员工
     * @return List<Wage>
     */

    @Override
    public Result getAllUsersForAllWages(){
        List<Wage> wages =  selectWages();
        List<WageVo> wageVos = wages.stream().map(wage -> {
            WageVo wageVo = new WageVo();
            BeanUtil.copyProperties(wage,wageVo,false);
            User wageUser = userMapper.selectById(wage.getUserId());
            wageVo.setWageUser(wageUser);
            return wageVo;
        }).collect(Collectors.toList());
        return Result.ok(wageVos);
    }




    /**
     * 添加一个人的工资信息
     */
    private boolean saveWage(Wage wage){
        return save(wage);
    }

    /**
     * 更新一个人的工资信息
     */
    private boolean updateWage(Wage wage){
        return updateById(wage);
    }
    /**
     * 添加或者更新一个人的工资信息
     */
    private boolean saveOrUpdateWage(Wage wage){
        return saveOrUpdate(wage);
    }
    /**
     * select 一个人的工资信息
     */
    private Wage getOneWage(Wage wage){
        return getById(wage.getWageId());
    }

    private List<Wage> selectWages(){
        return list(new QueryWrapper<Wage>());
    }

    private Wage selectWageByColumns(Wage wage){
        Map<String  , Object> map = new HashMap<>();
        BeanUtil.beanToMap(wage,map,false,true);
        return getOne(new QueryWrapper<Wage>().allEq(map));
    }
    /**
     * 删除 工资信息
     */
    private boolean deleteWage(Wage wage){
        return removeById(wage.getWageId());
    }

    private boolean delWagesByIds(List<Wage> list){
        List<Integer> ids = list.stream().map(wage -> {
            Integer id = wage.getWageId();
            return id;
        }).collect(Collectors.toList());
        return removeByIds(ids);
    }


}
