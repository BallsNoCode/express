package com.kkb.service;

import com.kkb.util.EmailUtil;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author APPDE
 * @date 2022/4/17 16:13
 * @Version 1.0
 **/
@Service
public class EmailService {

    private EmailUtil emailUtil = new EmailUtil();

    /**
     * @param name:    反馈用户名
     * @param content: 发送邮件正文
     * @Description: 用户发送反馈意见
     * @Author: APPDE
     * @Date: 2022/4/17 16:19
     * @return: java.lang.Boolean
     **/
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Boolean sendEmail(String name, String content) {
        try {
            val send = emailUtil.send("1657294192@qq.com", "用户:" + name + " 反馈意见", content);
            return send;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param returnEmail: 用户接收邮件
     * @param subject:     发送邮件主题
     * @param content:     发送邮件正文
     * @Description: 给用户发送回馈邮件
     * @Author: APPDE
     * @Date: 2022/4/17 16:20
     * @return: java.lang.Boolean
     **/
    public Boolean returnEmail(String returnEmail, String subject, String content) {
        try {
            val send = emailUtil.send(returnEmail, subject, content);
            return send;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
