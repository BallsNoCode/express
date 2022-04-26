package com.kkb.controller;

import com.kkb.pojo.Message;
import com.kkb.service.MessageService;
import com.kkb.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 获取用户所有消息
     *
     * @param session session
     * @return 消息集合
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResultVo<Message> getAll(HttpSession session) {
        String phone = (String) session.getAttribute("user");
        List<Message> messages = messageService.queryAll(phone);
        return new ResultVo<>(messages);
    }

    /**
     * 获取所有公告
     *
     * @return 公告集合
     */
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ResultVo<Message> getNotice() {
        List<Message> messages = messageService.queryNotice();
        return new ResultVo<>(messages);
    }

    /**
     * 获取所有用户通知
     *
     * @param session session
     * @return 通知集合
     */
    @RequestMapping(value = "/inform", method = RequestMethod.GET)
    public ResultVo<Message> getInform(HttpSession session) {
        String phone = String.valueOf(session.getAttribute("user"));
        List<Message> messages = messageService.queryByPhone(phone);
        return new ResultVo<>(messages);
    }


}
