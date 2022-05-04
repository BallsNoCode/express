package com.kkb.service;

import com.kkb.mapper.AddressMapper;
import com.kkb.pojo.Address;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author APPDE
 * @date 2022/4/26 10:10
 * @Version 1.0
 **/
@Service
public class AddressService {

    @Resource
    private AddressMapper addressMapper;

    /**
     * @param userId: 用户id
     * @Description: 根据用户id查询地址信息
     * @Author: APPDE
     * @Date: 2022/5/4 0:19
     * @return: java.util.List<com.kkb.pojo.Address>
     **/
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Address> queryByUser(Integer userId, Integer id) {
        Example example = new Example(Address.class);
        val criteria = example.createCriteria();
        if (id != null) {
            criteria.andEqualTo("id", id);
        }
        criteria.andEqualTo("userId", userId);
        return addressMapper.selectByExample(example);
    }

    /**
     * @param address: 更新的地址信息
     * @Description: 更新地址信息
     * @Author: APPDE
     * @Date: 2022/5/4 0:23
     * @return: java.lang.Boolean
     **/
    public Boolean updateAddress(Address address) {
        val update = addressMapper.updateByPrimaryKeySelective(address);
        return update > 0;
    }

    /**
     * @param address: 地址信息
     * @Description: 新增地址信息
     * @Author: APPDE
     * @Date: 2022/5/4 0:24
     * @return: java.lang.Boolean
     **/
    public Boolean addAddress(Address address) {
        address.setIddefault(0L);
        val insert = addressMapper.insert(address);
        return insert > 0;
    }
}
