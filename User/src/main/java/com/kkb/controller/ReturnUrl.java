package com.kkb.controller;

import com.alipay.api.internal.util.AlipaySignature;
import com.kkb.config.AlipayConfig;
import com.kkb.service.TransportService;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller //回调请求
public class ReturnUrl {

    @RequestMapping("/returnUrl")
    public void returnUrl(HttpServletRequest request, HttpServletResponse
            response) throws Exception {
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        Iterator<String> iter = requestParams.keySet().iterator();
        while (iter.hasNext()) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //RSA2验证
        boolean signVerified = AlipaySignature.rsaCheckV2(params,
                AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        //调用SDK验证签名
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String out_trade_no = request.getParameter("out_trade_no");
        //支付宝交易号
        String trade_no = request.getParameter("trade_no");
        //付款金额
        String total_amount = request.getParameter("total_amount");
        response.sendRedirect("/user/index.html?delete=1");
    }
}