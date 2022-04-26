package com.kkb.pojo;

/**
 * @author APPDE
 * @date 2022/4/17 16:04
 * @Version 1.0
 **/
public class EmailMessage {
    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,

    public final static String EMAIL_ACCOUNT = "zhangrunrong7681@163.com";

    // 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）

    public final static String EMAIL_PASSWORD = "YAUQWDWGCDPNUWZE";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com

    public final static String EMAIL_SMTP_HOST = "smtp.163.com";
}
