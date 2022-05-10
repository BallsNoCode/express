package com.kkb.service;

import junit.framework.TestCase;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VipServiceTest extends TestCase {

    @Resource
    private VipService service;

    @Test
    public void testCheckUser() {
        val vip = service.checkUser(2);
        System.out.println(vip);
    }
}