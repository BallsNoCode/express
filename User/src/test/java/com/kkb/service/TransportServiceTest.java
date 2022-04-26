package com.kkb.service;

import com.kkb.pojo.Transport;
import com.kkb.util.RandomUtil;
import junit.framework.TestCase;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransportServiceTest extends TestCase {

    @Resource
    private TransportService transportService;

    @Test
    public void TestAdd() {
        RandomUtil randomUtil = new RandomUtil();
        Transport transport = new Transport();
        transport.setTNumber(String.valueOf(randomUtil.getRandomNickname(4)));
        transport.setTState(0L);
        transport.setCompany("sf");
        System.out.println(transportService.add(transport));
    }

    @Test
    public void queryByNum() {
        Transport transport = transportService.queryByNumber("401919588149");
        System.out.println(transport);
    }

    @Test
    public void queryByPhone(){
        List<Transport> list = transportService.queryByPhone("13333333333");
        list.forEach(System.out::println);
    }

}