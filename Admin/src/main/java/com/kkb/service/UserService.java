package com.kkb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Inventory;
import com.kkb.pojo.Transport;
import com.kkb.pojo.User;
import com.kkb.mapper.InventoryMapper;
import com.kkb.mapper.TransportMapper;
import com.kkb.mapper.UserMapper;
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
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private InventoryMapper inventoryMapper;
    @Resource
    private TransportMapper transportMapper;

    /**
     * 分页查询用户对象
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param name 查询名字
     * @return 查询集合
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<User> queryByPage(Integer pageNum, Integer pageSize,String name) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //判断是否查询名字
        if (!ObjectUtils.isEmpty(name) && !"".equals(name.trim())){
            criteria.andEqualTo("uUsername",name);
        }
        List<User> users = userMapper.selectByExample(example);
        users.forEach(user -> {
            Example example0 = new Example(Inventory.class);
            Example.Criteria criteria0 = example0.createCriteria();
            criteria0.andEqualTo("ePhone",user.getUPhone());
            criteria0.andEqualTo("eState",0);
            //用户未取快递数
            int packageNum = inventoryMapper.selectCountByExample(example0);
            Example example1 = new Example(Inventory.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("ePhone",user.getUPhone());
            criteria1.andEqualTo("eState",2);
            //用户退回快递数
            int returnNum = inventoryMapper.selectCountByExample(example1);
            Example example2 = new Example(Transport.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("sentPhone",user.getUPhone());
            criteria2.andEqualTo("tState",0);
            //用户寄件数量
            int sentNum = transportMapper.selectCountByExample(example2);
            user.setPackageNum(packageNum);
            user.setSendNum(sentNum);
            user.setReturnNum(returnNum);
        });
        return new PageInfo<>(users);
    }

    /**
     * 根据id查询用户
     * @param id 查询id
     * @return 查询对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User queryById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改用户基本信息
     * @param user 修改信息
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 已废弃
     * 删除用户
     * @param id 删除id
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer del(Integer id) {
        User user = queryById(id);
        user.setUState(1L);
        return update(user);
    }
}
