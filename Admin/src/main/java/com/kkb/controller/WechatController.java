package com.kkb.controller;

import com.kkb.util.SignatureUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author APPDE
 */
@RestController
public class WechatController {

    /**
     * 微信接口数据
     *
     * @param request  request
     * @param response response
     * @throws IOException 无数据
     */
    @RequestMapping(value = "/WechatConfig", method = RequestMethod.GET)
    public void WechatConfig(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        String urlText = request.getParameter("xurl");
        try {
            String json = SignatureUtil.getConfig(urlText).toJSON();
            pw.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.close();
    }
}
