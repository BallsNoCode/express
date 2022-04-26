package com.kkb.controller;

import com.kkb.pojo.User;
import com.kkb.service.UserService;
import com.kkb.vo.ResultVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author APPDE
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 查询用户信息
     *
     * @param session session
     * @return 用户对象
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ResultVo<User> userInfo(HttpSession session) {
        String phone = (String) session.getAttribute("user");
        User user = userService.queryByPhone(phone);
        if (ObjectUtils.isEmpty(user)) {
            return new ResultVo<>(500, "服务器错误，请稍后重试！");
        } else {
            return new ResultVo<>(user);
        }
    }

    /**
     * 更新用户对象
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVo updateInfo(User user, HttpSession session) {
        String phone = (String) session.getAttribute("user");
        User user2 = userService.queryByPhone(phone);
        user2.setUUsername(user.getUUsername());
        user2.setUPhone(user.getUPhone());
        user2.setUPassword(user.getUPassword());
        user2.setUIdCard(user.getUIdCard());
        Integer integer = userService.updateUser(user2);
        if (integer <= 0) {
            return new ResultVo<>(500, "修改失败，请稍后重试！");
        } else {
            return new ResultVo();
        }
    }

    /**
     * 更新用户登录信息
     *
     * @param user    信息对象
     * @param session session
     * @return 结果对象
     */
    @RequestMapping(value = "/updateLogin", method = RequestMethod.POST)
    public ResultVo update(User user, HttpSession session) {
        String phone = (String) session.getAttribute("user");
        User user2 = userService.queryByPhone(phone);
        user2.setUTrueName(user.getUTrueName());
        user2.setUPhone(user.getUPhone());
        Integer integer = userService.updateUser(user2);
        if (integer <= 0) {
            return new ResultVo<>(500, "修改失败，请稍后重试！");
        } else {
            return new ResultVo();
        }
    }


}
