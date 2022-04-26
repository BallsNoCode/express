package com.kkb.controller;

import com.kkb.vo.ResultVo;
import lombok.val;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author APPDE
 * @date 2022/4/17 21:29
 * @Version 1.0
 **/
@RestController
@RequestMapping("/email")
public class EmailController extends thisController {

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResultVo sendEmail(String name, String email, String message) {
        if (!StringUtils.isEmpty(email)){
            message += "</br>用户收件邮箱：" + email;
        }
        val result = emailService.sendEmail(name, message);
        if (result) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "邮件发送失败,请稍后重试");
    }

}
