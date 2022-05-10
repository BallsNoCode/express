package com.kkb.controller;

import com.kkb.pojo.Vip;
import com.kkb.vo.ResultVo;
import lombok.Data;
import lombok.val;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

/**
 * @author APPDE
 * @date 2022/5/11 0:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("/vip")
public class VipController extends thisController {


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ResultVo checkUser(HttpSession session){
        Integer id = (Integer) session.getAttribute("id");
        val vip = vipService.checkUser(id);
        if (ObjectUtils.isEmpty(vip)){
            return new ResultVo<>(500,"该用户未充值VIP");
        }
        return new ResultVo<>(vip);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVo addVip(HttpSession session, Integer day){
        Integer id = (Integer) session.getAttribute("id");
        val integer = vipService.addVip(id, Long.valueOf(day));
        if (integer > 0){
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"充值失败，若已付款请联系客服！");
    }
}
