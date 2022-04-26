package com.kkb.service;

import com.kkb.pojo.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest extends TestCase {

    @Resource
    private UserService userService;

    @Test
    public void TestQueryByPhone(){
        User user = userService.queryByPhone("13360721887");
        System.out.println(ObjectUtils.isEmpty(user));
    }

}