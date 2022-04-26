package com.kkb.controller;

import com.kkb.service.MessageService;
import com.kkb.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 给用户发现消息
     * @param note note
     * @param phone 用户手机号
     * @return 消息对象
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVo add(String note,String phone){
        Integer result = messageService.add(note,phone);
        if (result <= 0){
            return new ResultVo(500,"发送失败！");
        }
        return new ResultVo();
    }

    /**
     * 发送公告
     * @param note note
     * @return 消息对象
     */
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST)
    public ResultVo addNotice(String note){
        Integer result = messageService.addNotice(note);
        if (result <= 0){
            return new ResultVo(500,"发送失败！");
        }
        return new ResultVo();
    }
}
