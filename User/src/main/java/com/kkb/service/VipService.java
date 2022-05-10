package com.kkb.service;

import com.kkb.mapper.VipMapper;
import com.kkb.pojo.Vip;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author APPDE
 * @date 2022/5/11 0:53
 * @Version 1.0
 **/
@Service
public class VipService {

    @Resource
    private VipMapper vipMapper;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Vip checkUser(Integer id){
        return vipMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer addVip(Integer id,Long day){
        Timestamp data = new Timestamp(System.currentTimeMillis());
        data.setTime(data.getTime() + day *1000*60*60*24);
        val vip1 = checkUser(id);
        //判断续费还是充值
        if (ObjectUtils.isEmpty(vip1)){
            Vip vip = new Vip();
            vip.setLev(Long.valueOf(id));
            vip.setTime(data);
            vip.setLev(1L);
            return vipMapper.insert(vip);
        }
        vip1.setTime(data);
        return vipMapper.updateByPrimaryKeySelective(vip1);
    }
}
