package com.kkb.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.kkb.config.AlipayConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliPayUtil {
    @Bean
    public AlipayClient alipayClient(){
        return new DefaultAlipayClient(AlipayConfig.gatewayUrl,
                AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json",
                AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);
    }
    @Bean
    public AlipayTradePagePayRequest alipayTradePagePayRequest(){
        return new AlipayTradePagePayRequest();
    }
}
