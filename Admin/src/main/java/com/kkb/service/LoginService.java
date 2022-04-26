package com.kkb.service;

import com.kkb.pojo.Admin;
import com.kkb.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author APPDE
 */
@Service
public class LoginService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 根据用户名查询
     *
     * @param userName userName
     * @return 用户对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Admin queryByName(String userName) {
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(userName)) {
            criteria.andEqualTo("username", userName);
            return adminMapper.selectOneByExample(example);
        }
        return null;
    }
}
