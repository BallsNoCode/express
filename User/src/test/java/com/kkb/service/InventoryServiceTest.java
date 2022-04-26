package com.kkb.service;

import com.kkb.pojo.Inventory;
import com.kkb.pojo.User;
import com.kkb.mapper.InventoryMapper;
import com.kkb.vo.Top;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceTest extends TestCase {

    @Resource
    private InventoryService service;
    @Resource
    private UserService userService;
    @Resource
    private InventoryMapper mapper;

    @Test
    public void TestQueryByNum() {
        Inventory inventory = service.queryByNum("1213456");
        System.out.println(inventory);
    }

    @Test
    public void TestMapper() {
        List<Top> count = mapper.count1();
        count.forEach(System.out::println);
        System.out.println("-----------------");
        List<Top> count2 = mapper.count2();
        count2.forEach(System.out::println);
        System.out.println("-----------------");
        List<Top> count3 = mapper.count3();
        count3.forEach(System.out::println);
    }

    @Test
    public void TestTop(){
        List<Top> tops = service.topInfo(1);
        tops.forEach(top -> {
            User user = userService.queryByPhone(top.getE_phone());
            top.setUserName(user.getUUsername());
        });
        tops.forEach(System.out::println);
    }

    @Test
    public void TestDel(){
        Integer integer = service.delInventory("1111");
        System.out.println(integer);
    }

}