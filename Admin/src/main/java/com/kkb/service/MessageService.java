package com.kkb.service;

import com.kkb.pojo.Message;
import com.kkb.mapper.MessageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * @author APPDE
 */
@Service
public class MessageService {

    @Resource
    private MessageMapper messageMapper;

    /**
     * 发送用户通知
     * @param note 通知
     * @param phone 用户手机号
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer add(String note,String phone){
        Message message = new Message();
        message.setMessage(note);
        message.setPhone(phone);
        message.setCreateTime(new Timestamp(System.currentTimeMillis()));
        message.setState(0L);
        message.setType(0L);
        return messageMapper.insert(message);
    }

    /**
     *  发送公告
     * @param note 公告
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer addNotice(String note){
        Message message = new Message();
        message.setMessage(note);
        message.setCreateTime(new Timestamp(System.currentTimeMillis()));
        message.setState(0L);
        message.setType(1L);
        return messageMapper.insert(message);
    }


}
