package com.kkb.controller;

import com.kkb.pojo.User;
import com.kkb.service.UserService;
import com.kkb.util.RandomUtil;
import com.kkb.util.SMSUtil;
import com.kkb.vo.ResultVo;

import java.io.IOException;
import java.sql.Timestamp;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 账号登录/注册
     *
     * @param loginName 登录用户名
     * @param password  密码
     * @param session   session
     * @return 用户对象
     */
    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    public ResultVo<User> Login(String loginName, String password, HttpSession session) {
        User user = this.userService.login(loginName, password);
        if (ObjectUtils.isEmpty(user)) {
            return new ResultVo(500, "服务器错误，请稍后重试！");
        } else {
            session.setAttribute("user", loginName);
            return new ResultVo(user);
        }
    }

    /**
     * 手机号登录
     *
     * @param userPhone 登录手机号
     * @param code      验证码
     * @param session   session
     * @return 用户对象
     */
    @RequestMapping(
            value = {"/phoneLogin"},
            method = {RequestMethod.POST}
    )
    public ResultVo phoneLogin(String userPhone, String code, HttpSession session) {
        String c = (String) session.getAttribute(userPhone);
        if (c == null) {
            return new ResultVo(500, "手机号码未获取短信");
        } else if (c.equals(code)) {
            User user = this.userService.queryByPhone(userPhone);
            if (ObjectUtils.isEmpty(user)){
                return new ResultVo(500,"用户未注册，请先注册后使用！");
            }
            user.setULogintime(new Timestamp(System.currentTimeMillis()));
            this.userService.updateUser(user);
            session.setAttribute("user", userPhone);
            session.setAttribute("id", user.getUId());
            return new ResultVo();
        } else {
            return new ResultVo(500, "验证码不一致,请检查");
        }
    }

    public ResultVo register(String userPhone) {
        User user = new User();
        user.setUPhone(userPhone);
        user.setUState(0L);
        user.setULogintime(new Timestamp(System.currentTimeMillis()));
        user.setUCreatetime(new Timestamp(System.currentTimeMillis()));
        Integer insert = this.userService.insert(user);
        if (insert <= 0) {
            return new ResultVo<>(500, "注册失败，请稍后重试！");
        }
        return new ResultVo<>();
    }

    /**
     * 手机验证码获取
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping({"/loginSms"})
    public ResultVo sendSms(HttpServletRequest request, HttpSession session) {
        String userPhone = request.getParameter("userPhone");
        RandomUtil randomUtil = new RandomUtil();
        String code = "";
        Boolean flag;
        //13333333333 123456 测试账号不获取验证码
        if ("13333333333".equals(userPhone) || "18888888888".equals(userPhone) || "16666666666".equals(userPhone)) {
            code = "123456";
            flag = true;
        } else {
            code = randomUtil.getRandomNickname(6) + "";
            flag = SMSUtil.send(userPhone, code);
        }

        session.setAttribute(userPhone, code);
        return flag ? new ResultVo<>(200, "验证码已发送,请查收!") : new ResultVo<>(500, "验证码下发失败,请检查手机号或稍后再试");
    }

    /**
     * 退出登录
     *
     * @param session session
     * @return 清除session数据
     */
    @RequestMapping({"/logOut"})
    public ResultVo loginOut(HttpSession session, HttpServletResponse response) {
        session.invalidate();
        try {
            response.sendRedirect("/land.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResultVo();
    }
}
