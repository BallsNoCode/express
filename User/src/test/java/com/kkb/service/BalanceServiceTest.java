package com.kkb.service;

import com.kkb.pojo.Balance;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceServiceTest extends TestCase {

    @Resource

    private BalanceService balanceService;
    @Test
    public void testQueryInfo() {
        Balance balance = balanceService.queryInfo("16675982450");
        if (ObjectUtils.isEmpty(balance)){
            System.out.println('a');
        }
        System.out.println(balance);
    }
}