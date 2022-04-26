package com.kkb.service;

import com.kkb.pojo.User;
import com.kkb.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;


/**
 * @author APPDE
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param loginName 用户名
     * @param password  密码
     * @return 成功用户对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User login(String loginName, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uUsername", loginName);
        criteria.andEqualTo("uPassword", password);
        return userMapper.selectOneByExample(example);
    }

    /**
     * 手机号查询用户信息
     *
     * @param phone 查询手机号
     * @return 用户信息对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User queryByPhone(String phone) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uPhone", phone);
        return userMapper.selectOneByExample(example);
    }

    /**
     * 用户注册
     *
     * @param user 注册用户信息
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 修改用户信息
     *
     * @param user 含修改信息的用户对象
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 用户注销(更新状态码)
     *
     * @param phone 注销用户手机号
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer delUser(String phone) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("uPhone", phone);
        User user = userMapper.selectOneByExample(example);
        user.setUState(0L);
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
