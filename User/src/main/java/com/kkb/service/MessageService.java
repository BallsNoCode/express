package com.kkb.service;

import com.kkb.pojo.Message;
import com.kkb.mapper.MessageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author APPDE
 */
@Service
public class MessageService {

    @Resource
    private MessageMapper mapper;

    /**
     * 查询公告
     *
     * @return 公告集合
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Message> queryNotice() {
        Example example = new Example(Message.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", 1);
        return mapper.selectByExample(example);
    }

    /**
     * 根据用户手机号查询通知
     *
     * @param phone 查询手机号
     * @return 通知集合
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Message> queryByPhone(String phone) {
        Example example = new Example(Message.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(phone)) {
            criteria.andEqualTo("phone", phone);
            return mapper.selectByExample(example);
        }
        return null;
    }

    /**
     * 根据用户手机号查询消息
     *
     * @param phone 查询手机号
     * @return 消息集合
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Message> queryAll(String phone) {
        Example example = new Example(Message.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(phone)) {
            criteria.orEqualTo("phone", phone);
            criteria.orEqualTo("type", 1);
            return mapper.selectByExample(example);
        }
        return null;
    }

}
