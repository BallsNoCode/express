package com.kkb.service;

import com.kkb.pojo.Balance;
import com.kkb.mapper.BalanceMapper;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author APPDE
 */
@Service
public class BalanceService {

    @Resource
    private BalanceMapper mapper;

    /**
     * 手机号查询用户钱包信息
     *
     * @param phone 查询手机号
     * @return 结果对象
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Balance queryInfo(String phone) {
        Example example = new Example(Balance.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bPhone", phone);
        Balance balance = mapper.selectOneByExample(example);
        if (ObjectUtils.isEmpty(balance)){
            add(phone);
            balance = mapper.selectOneByExample(example);
        }
        return balance;
    }

    /**
     * 消费余额扣款
     *
     * @param phone      用户手机号
     * @param consume 消费额度
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer Buy(String phone, Double consume) {
        val balance = queryInfo(phone);
        double result = balance.getBalance() - consume;
        if (result < 0) {
            return 0;
        } else {
            balance.setBalance(result);
            return mapper.updateByPrimaryKeySelective(balance);
        }
    }

    /**
     * 充值
     *
     * @param balance 充值对象
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer pay(Balance balance) {
        return mapper.updateByPrimaryKeySelective(balance);
    }

    /**
     * 积分扣除
     *
     * @param id  扣除用户id
     * @param del 扣除积分数
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer cash(Integer id, Double del) {
        Balance balance = mapper.selectByPrimaryKey(id);
        double result = balance.getIntegral() - del;
        if (result < 0) {
            return 0;
        } else {
            balance.setIntegral((long) result);
            return mapper.updateByPrimaryKeySelective(balance);
        }
    }

    /**
     * @Description: 注册钱包
     * @Author: APPDE
     * @Date: 2022/4/15 20:34
     * @param phone: 用户手机号
     * @return: java.lang.Integer
     **/
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer add(String phone){
        Balance balance = new Balance();
        balance.setBPhone(phone);
        balance.setBalance(0.00);
        balance.setIntegral(0L);
        balance.setBState(0L);
        return mapper.insert(balance);
    }
}
