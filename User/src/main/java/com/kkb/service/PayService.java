package com.kkb.service;

import com.kkb.mapper.PayMapper;
import com.kkb.pojo.Pay;
import com.kkb.util.MD5Util;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.net.Inet4Address;

/**
 * @author APPDE
 * @date 2022/4/15 20:22
 * @Version 1.0
 **/
@Service
public class PayService {

    @Resource
    private PayMapper payMapper;

    private MD5Util md5Util = new MD5Util();

    /**
     * @Description: 验证支付密码
     * @Author: APPDE
     * @Date: 2022/4/15 21:28
     * @param id: 用户id
     * @param password: 用户输入的密码
     * @return: java.lang.Boolean
     **/
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Boolean checkPassword(Long id,String password){
        Pay pay = payMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(pay)){
            return true;
        }
        if (md5Util.encrypt(password,"pay").equals(pay.getPayPassword())){
            return true;
        }
        return false;
    }

    /**
     * @Description: 修改支付密码/注册支付钱包
     * @Author: APPDE
     * @Date: 2022/4/15 20:32
     * @param id: 用户id
     * @param password: 修改密码
     * @return: java.lang.Integer
     **/
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer changePassword(Long id,String password){
        Pay pay = payMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(pay)){
            pay = new Pay();
            pay.setUid(id);
            pay.setPayPassword(md5Util.encrypt(password,"pay"));
            return payMapper.insert(pay);
        }
        pay.setPayPassword(md5Util.encrypt(password,"pay"));
        return payMapper.updateByPrimaryKeySelective(pay);
    }

}
