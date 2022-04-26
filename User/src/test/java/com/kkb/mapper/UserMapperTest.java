package com.kkb.mapper;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest extends TestCase {

    @Resource
    private UserMapper mapper;

    @Test
    public void testMapper(){
        mapper.selectAll().forEach(System.out::println);
    }
}