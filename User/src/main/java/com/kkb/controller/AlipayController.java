package com.kkb.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.kkb.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author APPDE
 */
@Controller
public class AlipayController {

    @Resource
    private AlipayClient alipayClient;
    @Resource
    private AlipayTradePagePayRequest alipayTradePagePayRequest;

    //商户订单号，商户网站订单系统中唯一订单号，必填 WIDout_trade_no
    //付款金额，必填 WIDtotal_amount
    //订单名称，必填 WIDsubject
    //商品描述，可空 WIDbody
    @GetMapping("/Alipay")
    public void payUtil(String WIDout_trade_no, String WIDtotal_amount, String WIDsubject, String WIDbody, Integer id, HttpServletResponse response, HttpSession session) throws Exception {
        //1.获得初始化的AlipayClient
        //2.设置请求参数AlipayTradePagePayRequest
        alipayTradePagePayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayTradePagePayRequest.setNotifyUrl(AlipayConfig.notify_url);
        alipayTradePagePayRequest.setBizContent("{\"out_trade_no\":\"" + WIDout_trade_no + "\","
                + "\"total_amount\":\"" + WIDtotal_amount + "\","
                + "\"subject\":\"" + WIDsubject + "\","
                + "\"body\":\"" + WIDbody + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();

        //输出
        response.setContentType("text/html;charset=utf-8");
        session.setAttribute("tid",id);
        response.getWriter().println(result);
    }

}

