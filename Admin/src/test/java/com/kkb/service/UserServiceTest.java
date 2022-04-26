package com.kkb.service;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.User;
import com.kkb.mapper.InventoryMapper;
import com.kkb.mapper.UserMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest extends TestCase {

    @Resource
    private UserMapper userMapper;
    @Resource
    private InventoryMapper mapper;
    @Resource
    private UserService service;

    @Test
    public void testQueryByPage() {
        PageInfo<User> pageInfo = service.queryByPage(1,5,"admin");
        System.out.println(pageInfo);

    }

    public void testQueryById() {
    }

    public void testUpdate() {
    }

    public void testDel() {
    }
}