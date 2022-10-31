package com.lp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dto.Result;
import com.lp.dto.UserDTO;
import com.lp.service.TestService;
import com.lp.utils.UserHolder;
import org.springframework.stereotype.Service;

/**
 * @description test
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public Result test1() {
        UserDTO user = new UserDTO();
        user = UserHolder.getUser();
        System.out.println(user);

        return Result.ok(user);
    }

}
