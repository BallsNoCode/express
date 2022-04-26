package com.kkb.util;

import com.kkb.pojo.EmailMessage;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @Description: 邮件处理
 * @Author: APPDE
 * @Date: 2022/4/17 15:58
 * @return: null
 **/
public class EmailUtil extends EmailMessage {

    /**
     * @Description: 发送邮件
     * @Author: APPDE
     * @Date: 2022/4/17 15:59
     * @param receiveMailAccount: 接收邮件的邮箱
     * @param subject: 邮件主题
     * @param content: 邮件正文
     * @return: Boolean
     **/
    public Boolean send(String receiveMailAccount, String subject, String content) throws Exception {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        // 发件邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.host", EMAIL_SMTP_HOST);
        // 需要请求认证
        props.setProperty("mail.smtp.auth", "true");


        props.put("mail.smtp.ssl.enable", true);

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, EMAIL_ACCOUNT, receiveMailAccount, subject, content);
        if (ObjectUtils.isEmpty(message)){
            return false;
        }
        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        transport.connect(EMAIL_ACCOUNT, EMAIL_PASSWORD);
        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        // 7. 关闭连接
        transport.close();
        return true;
    }

    /**
     * @Description: 创建文本邮件
     * @Author: APPDE
     * @Date: 2022/4/17 16:01
     * @param session: 交互会话
     * @param sendMail: 发送邮箱
     * @param receiveMail: 接收邮箱
     * @param subject: 邮件主题
     * @param content: 邮件正文
     * @return: javax.mail.internet.MimeMessage
     **/
    private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String subject, String content) throws Exception {
        // 1. 创建邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "快递e栈", "UTF-8"));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "用户", "UTF-8"));
        /*
        To: 增加收件人（可选）
        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
        Cc: 抄送（可选）
        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
        Bcc: 密送（可选）
        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));
        */

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject(subject, "UTF-8");
        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent(content, "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }
}
