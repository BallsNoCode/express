package com.kkb.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author APPDE
 */
public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000119661431";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC4aV3DskqoBVdtAJz+PK2Zo05TW7z7eG6t57u673S5mH8VUuJkegs+7K9WqKb/UMRPmkn1bU3XB3REvPyNYwXGeDdwIBcovTJnIjv9UQowT2iawp+GjnepLlEsndktHG1pC28sWAjSw7xO9yJhNoBp6MwLj4f//ZTfeu4vrr3T9L0GR3q9ATRKlJtzB6KgLmRf2o9/LLrrpc1qtkdzNtileeS4z+MuFK1tPRZvjywH4SHUSKIEq86N2SOBe9Tu/lWo5nMvCuZManSAsu+Zz0RYYG8+R4K8STQJZ1I6VQoDneYw4hdHJavaTWvDme+GKca6cDGoUweK67nowAt1o/1DAgMBAAECggEAcZQTt/AboxiHHA+AoeVlVncKSrT51Df8kwdizGOnFJgjzVJbNV8lhf/ojgsZr65i+lQgsRQ9GO7yYVO0iLAwYmiwXFKncOP2Iycmo4JCMDb4SjkMX6dnc7+fJ0eg9vPHPydXtYwTAxyi4k+70PvsY06KPaSNMtFP28Su5pdNOzk2x9jkuo26Te/HwXK+BUk+S3+gpSRFICenfqMZSbVzbpci0+WMliCiBWST2ZHAx52OKBThRJAWSi1OQilyYYIXEsMEWLo4ZuA5pcpYcFf8QCLd8f0LV7pNqwpvnevYXAeAiTL2/m6CYykGHdBdpuQdetJ1Nsj/3Q7r2trZZTkoIQKBgQD6edN9JMf5OkZK0ZSLJsEf6dd+WHCeaFhXggHzOkoLZgRiTUZWxSR8C4xVma3wvsqExvTH3RAVAwhJBsHnm2oih+OzULO4NTtPuu35eABi0syR5bOwK1OnRYF/h9hqrsHW+GJ1hacFFhWGGAJkwAnOKE3sJuEq0aQNUdgb5z4lxQKBgQC8eotnFUCiEIVhcU74KyruBgu3iuloAj6sLzbUDWZJjnE2jA7it8Cf8+1Trw4LQMce6AQBxazBNvkwBwt8Q0n3RxoYQZf9tGSK2F1w88+p4vEOwnmBm8GIxhQuVAp432a/vBdqCU4j892GMC5Dd0qwtPDTqprXiQ+aQv470L9PZwKBgQCfQD3a3zvVlduDTmUnY+h+JetBBXH1BVrFqH8c6f6R6Lb42TDTklx0EdOTyTXyTxvr96NCP6ct9NObupQmcYW1lriLFdBuWknvk2Yiqs10B5rRWD460BFL1MFVGEXc7meICjxvhB6A+V2N+E3tSLvzO2TvtHiNBOVNIrBIbWnyEQKBgEb6PxUKw9RENHaFnR+H4hrQ3Ai6nzsz3TYqcZNZmHOK2MeZ5uEqIbgau/0Pp1JFirbw2NFyB6SbdyvG+2RIUsp0VDdePEamcFZ5NHcc2c84T18njWpppXBEZ8UqkOcD+kWqJ4cfCfYwF/Q4oLN3cQEqoqaTUMxqKR4GrIcKDYFxAoGAY4Ka6Lx2wXcDePy6FDA5A7K+f6SmS8NlEggEJKZXW6I/b29zvMxmHhCZj3EFPu7/iiynsOIG1XBoDCcz7raTjc9Fe5mcNL4apFIpflEPKfEX+mA5VlsYgl09y67oSLrqlQwCU8c/Zowaum7Gi1CQsd0Nj1H9TeohmZ/t15WlomA=";
    // 支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx8emp138gchJVu7AVCk2Y6fmbnlmxbpS3IjqQmqWiSnkSmpRDHLMZiMuFukKU/o/0zXpUkEj6QOUBpWp3XNVPnQwuGZRtknR47C54DxeMyn644Nbhe8aPo6v0u6zRPLH+UJ/VhdjnoCnbeJ6PzC0ImF3OPwlwx7K511zL4VBa7nhKq0UaCBL2P1p5YndWat0DtNvCqqPG73RVovMKzUUEXPbf10JQzoT9Hk5qPbvTKGCEEuJzkYuTAajvSWb6RrcGVsVIYho18aIdQz7wP9VgmgkOR6F9DajRE/0B0/qK5843F3B/+sdmJG7gSNsMVXdpf09V/VWXwb9+CBcHMrnCwIDAQAB";
    // 服务器异步通知页面路径
    //需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "https://www.a76813637.com/notifyUrl";
    // 页面跳转同步通知页面路径
    //需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "https://www.a76813637.com/returnUrl";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关,注意这些使用的是沙箱的支付宝网关，与正常网关的区别是多了dev
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";
    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" +
                    System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
