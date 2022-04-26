package com.kkb.service;

import com.kkb.pojo.Cdk;
import com.kkb.mapper.CdkMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CdkServiceTest extends TestCase {

    @Resource
    private CdkService cdkService;
    @Resource
    private CdkMapper mapper;

    @Test
    public void TestDel(){
        Cdk cdk = new Cdk();
        cdk.setKId(2);
        cdk.setKState(1);
        System.out.println(cdkService.delCdk(cdk));
    }
}