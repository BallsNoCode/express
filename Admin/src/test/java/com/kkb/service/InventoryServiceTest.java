package com.kkb.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceTest extends TestCase {

    @Resource
    private InventoryService service;

    @Test
    public void testConsole() {
//        HashMap<Integer,Integer> list = service.console();
//        for(Integer key:list.keySet()) {
//            Integer value = list.get(key);
//            System.out.println("方法四：Key = " + key + ", Value = " + value);
//        }
        service.console().forEach(System.out::println);
    }
}