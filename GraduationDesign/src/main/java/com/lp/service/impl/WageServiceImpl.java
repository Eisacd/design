package com.lp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.entity.Wage;
import com.lp.mapper.WageMapper;
import com.lp.service.WageService;
import org.springframework.stereotype.Service;

@Service
public class WageServiceImpl extends ServiceImpl<WageMapper , Wage> implements WageService {

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
    /**
     * 删除 工资信息
     */
    private boolean deleteWage(Wage wage){
        return removeById(wage.getWageId());
    }
}
