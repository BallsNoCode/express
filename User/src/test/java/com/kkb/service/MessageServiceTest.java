package com.kkb.service;

import com.kkb.pojo.Message;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest extends TestCase {

    @Resource
    private MessageService service;

    @Test
    public void queryAllTest() {
        List<Message> messages = service.queryAll("13333333333");
        messages.forEach(System.out::println);
    }

    @Test
    public void qyeryByPhoneTest() {
        List<Message> messages = service.queryByPhone("13333333333");
        messages.forEach(System.out::println);
    }

    @Test
    public void queryNoticTest() {
        List<Message> messages = service.queryNotice();
        messages.forEach(System.out::println);
    }

}