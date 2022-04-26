package com.kkb.controller;

import com.kkb.pojo.Balance;
import com.kkb.service.BalanceService;
import com.kkb.service.PayService;
import com.kkb.service.UserService;
import com.kkb.vo.ResultVo;
import lombok.val;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author APPDE
 * @date 2022/4/15 20:38
 * @Version 1.0
 **/

@RestController
public class PayController extends thisController {

    /**
     * @Description: 验证支付密码
     * @Author: APPDE
     * @Date: 2022/4/15 20:51
     * @param password: 支付密码
     * @param session: sessionx
     * @return: com.kkb.vo.ResultVo
     **/
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public ResultVo checkPassword(String password, HttpSession session) {
        String phone = String.valueOf(session.getAttribute("user"));
        val user = userService.queryByPhone(phone);
        val result = payService.checkPassword(user.getUId(), password);
        if (result) {
            return new ResultVo<>();
        }
        return new ResultVo(500,"密码错误！");
    }

    /**
     * @Description: 修改支付密码，修改前需先验证支付密码
     * @Author: APPDE
     * @Date: 2022/4/15 20:51
     * @param password: 修改的支付密码
     * @param session: session
     * @return: com.kkb.vo.ResultVo
     **/
    @RequestMapping(value = "/changePay",method = RequestMethod.POST)
    public ResultVo changePassword(String password, HttpSession session) {
        String phone = String.valueOf(session.getAttribute("user"));
        val user = userService.queryByPhone(phone);
        val result = payService.changePassword(user.getUId(), password);
        if (result <= 0) {
            return new ResultVo<>(500, "修改失败！");
        }
        return new ResultVo<>();
    }

}
