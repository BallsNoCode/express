package com.kkb.service;

import com.kkb.pojo.Inventory;
import com.kkb.pojo.Transport;
import com.kkb.mapper.InventoryMapper;
import com.kkb.mapper.TransportMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author APPDE
 */
@Service
public class ConsoleService {

    @Resource
    private InventoryMapper inventoryMapper;
    @Resource
    private TransportMapper transportMapper;

    /**
     * 查询主页数据
     * @return 数据集合
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<Integer> countAll(){
        List<Integer> list = new ArrayList<>();
        //总快件数
        list.add(inventoryMapper.selectCount(null));
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eState",0);
        //待取件数
        list.add(inventoryMapper.selectCountByExample(example));
        Example example2 = new Example(Inventory.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("eState",2);
        //待取件数
        list.add(inventoryMapper.selectCountByExample(example2));
        //退回数
        list.add(transportMapper.selectCount(null));
        return list;
    }

    /**
     * 查询主页当天数据
     * @return 数据集合
     */
    public List<Integer> countTime(){
        List<Integer> list = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThanOrEqualTo("inTime",timestamp);
        //总快件数
        list.add(inventoryMapper.selectCountByExample(example));
        Example example1 = new Example(Inventory.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andGreaterThanOrEqualTo("outTime",timestamp);
        criteria1.andEqualTo("eState",1);
        //待取件数
        list.add(inventoryMapper.selectCountByExample(example1));
        Example example2 = new Example(Transport.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andGreaterThanOrEqualTo("tTime",timestamp);
        //待取件数
        list.add(transportMapper.selectCountByExample(example2));
        Example example3 = new Example(Inventory.class);
        Example.Criteria criteria3 = example3.createCriteria();
        criteria3.andGreaterThanOrEqualTo("inTime",timestamp);
        criteria3.andEqualTo("eState",2);
        //退回数
        list.add(inventoryMapper.selectCountByExample(example3));
        return list;
    }

}
