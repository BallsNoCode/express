package com.kkb.service;

import com.kkb.pojo.User;
import com.kkb.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author APPDE
 */
@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param loginName 登录用户名
     * @param password  密码
     * @return 结果对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> login(String loginName, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uUsername", loginName);
        criteria.andEqualTo("uPassword", password);

        List<User> users = userMapper.selectByExample(example);
        return users;
    }
}
