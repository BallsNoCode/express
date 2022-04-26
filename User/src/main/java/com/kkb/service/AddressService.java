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

    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<Address> queryByUser(Integer userId){
        Example example = new Example(Address.class);
        val criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        return addressMapper.selectByExample(example);
    }
}
