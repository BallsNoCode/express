package com.kkb.service;

import com.kkb.pojo.Admin;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest extends TestCase {

    @Resource
    private LoginService loginService;
    @Test
    public void testLogin() {
        Admin admin = loginService.queryByName("admin");
        System.out.println(admin);
    }
}