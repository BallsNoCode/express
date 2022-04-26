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
public class PayServiceTest extends TestCase {

    @Resource
    private PayService payService;

    @Test
    public void testCheckPassword() {
        val integer = payService.checkPassword(6L, "178011");
        System.out.println(integer);
    }

    public void testChangePassword() {
    }
}