package com.lp.service.impl;

import com.lp.dto.Result;
import com.lp.entity.User;
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
        User user = new User();
        user = UserHolder.getUser();
        System.out.println(user);

        return Result.ok(user);
    }

}
