package com.kkb.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleServiceTest extends TestCase {

    @Resource
    ConsoleService consoleService;
    @Test
    public void testCountAll() {
        List<Integer> list = consoleService.countAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testCountTimeTest(){
        List<Integer> list = consoleService.countTime();
        list.forEach(System.out::println);
    }

}