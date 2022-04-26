package com.kkb.controller;

import com.kkb.pojo.Admin;
import com.kkb.service.LoginService;
import com.kkb.util.MD5Util;
import com.kkb.util.VerifyCodeUtil;
import com.kkb.vo.ResultVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author APPDE
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    private String verifyCode;
    private MD5Util md5Util = new MD5Util();

    /**
     * 登录
     *
     * @param session  session
     * @param username username
     * @param password password
     * @param code     code
     * @return 用户对象
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVo<Admin> Login(HttpSession session, String username, String password, String code) {
        if (code.equals(verifyCode)) {
            return new ResultVo<>(500, "验证码不正确！");
        }
        Admin admin = loginService.queryByName(username);
        if (ObjectUtils.isEmpty(admin)) {
            return new ResultVo<>(500, "用户不存在！");
        }
        if (admin.getPassword().equals(md5Util.encrypt(password, "password"))) {
            session.setAttribute("user", admin.getUsername());
            return new ResultVo<>(admin);
        }
        return new ResultVo<>(500, "账号或密码不正确！");
    }

    /**
     * 图片验证码生成
     *
     * @param response response
     * @param request  request
     */
    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.GET)
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            int width = 200;
            int height = 69;
            VerifyCodeUtil codeUtil = new VerifyCodeUtil();
            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //生成对应宽高的初始图片
            verifyCode = codeUtil.drawRandomText(width, height, verifyImg);
            //单独的一个类方法，出于代码复用考虑，进行了封装。
            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            request.getSession().setAttribute("cc", verifyCode);
            //必须设置响应内容类型为图片，否则前台不识别
            response.setContentType("image/png");
            //获取文件输出流
            OutputStream os = response.getOutputStream();
            //输出图片流
            ImageIO.write(verifyImg, "png", os);
            os.flush();
            os.close();//关闭流
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 退出登录
     *
     * @param session session
     * @return 清除session数据
     */
    @RequestMapping({"/logOut"})
    public void loginOut(HttpSession session,HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/admin/login.html");
    }
}
