package com.kkb.service;

import com.kkb.pojo.Balance;
import com.kkb.pojo.Transport;
import com.kkb.mapper.TransportMapper;
import com.kkb.util.RandomUtil;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.naming.ldap.PagedResultsControl;
import java.security.acl.LastOwnerException;
import java.util.List;

/**
 * @author APPDE
 */
@Service
public class TransportService {

    @Resource
    private TransportMapper transportMapper;

    /**
     * 寄快递
     *
     * @param transport 快递对象
     * @return 数据库操作数量
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer add(Transport transport) {
        RandomUtil randomUtil = new RandomUtil();
        transport.setTNumber(randomUtil.getRandomNickname(12));
        transport.setTState(0L);
        return transportMapper.insert(transport);
    }

    /**
     * @Description: 根据快递单号查询快递
     * @Author: APPDE
     * @Date: 2022/4/15 14:56
     * @param number: 查询的快递单号
     * @return: com.kkb.pojo.Transport
     **/
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Transport queryByNumber(String number){
        Example example = new Example(Transport.class);
        val criteria = example.createCriteria();
        criteria.andEqualTo("tNumber",number);
        return transportMapper.selectOneByExample(example);
    }

    /**
     * @Description: 根据手机号查询快递
     * @Author: APPDE
     * @Date: 2022/4/15 14:59
     * @param phone: 查询快递
     * @return: java.util.List<com.kkb.pojo.Transport>
     **/
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<Transport> queryByPhone(String phone){
        Example example = new Example(Transport.class);
        val criteria = example.createCriteria();
        //用户可能是手机人或者寄件人
        criteria.orEqualTo("sentPhone",phone);
        criteria.orEqualTo("pickPhone",phone);
        return transportMapper.selectByExample(example);
    }

    /**
     * @Description: 修改运单付款状态
     * @Author: APPDE
     * @Date: 2022/4/15 22:09
     * @param id: 快递id
     * @return: java.lang.Integer
     **/
    public Integer updateIsPay(Integer id){
        val transport = transportMapper.selectByPrimaryKey(id);
        transport.setTIspay(1L);
        return transportMapper.updateByPrimaryKeySelective(transport);
    }

}
