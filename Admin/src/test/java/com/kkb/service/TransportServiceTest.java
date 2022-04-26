package com.kkb.service;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Transport;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransportServiceTest extends TestCase {

    @Resource
    private TransportService transportService;

    @Test
    public void testQueryByPage() {
        PageInfo<Transport> transportPageInfo = transportService.queryByPage(3, 2,"14646");
        transportPageInfo.getList().forEach(System.out::println);
    }

    @Test
    public void testQueryById() {
        Transport transport = transportService.queryById(37);
        System.out.println(transport);
    }

    @Test
    public void testUpdate() {
        Transport transport = transportService.queryById(37);
        transport.setTState(1L);
        transportService.update(transport);
        System.out.println(transportService.queryById(37));
    }

    @Test
    public void testAdd() {
        Transport transport = new Transport();
        transport.setCompany("testRun");
        transport.setTNumber("123456789");
        transport.setTTime(new Timestamp(System.currentTimeMillis()));
        Integer add = transportService.add(transport);
        System.out.println(add);
    }
}