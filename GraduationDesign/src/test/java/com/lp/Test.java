package com.lp;

import com.lp.entity.User;
import com.lp.service.UserService;
import com.lp.service.impl.UserServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Test {

    @Resource
    private UserServiceImpl userServiceImpl;

   @org.junit.jupiter.api.Test
    public void t(){
       User user1 = new User();
       User user2 = new User();
       user1.setId(1);
       user2.setId(2);
       List<User> list = new ArrayList<>();
       list.add(user1);
       list.add(user2);



       System.out.println("---");
   }
}
