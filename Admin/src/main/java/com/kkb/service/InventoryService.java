package com.kkb.service;

import com.kkb.mapper.InventoryMapper;
import com.kkb.pojo.Inventory;
import com.kkb.util.RandomUtil;
import lombok.val;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author APPDE
 * @date 2022/4/24 12:58
 * @Version 1.0
 **/
@Service
public class InventoryService {

    @Resource
    private InventoryMapper inventoryMapper;

    private RandomUtil randomUtil = new RandomUtil();

    public List<Integer> console(){
        Example example = new Example(Inventory.class);
        val i = inventoryMapper.selectCount(null);
        val criteria = example.createCriteria();
        criteria.orEqualTo("eState",0);
        val i1 = inventoryMapper.selectCountByExample(example);
        criteria.orEqualTo("eState",3);
        Integer i2 = inventoryMapper.selectCountByExample(example);
        criteria.orEqualTo("eState",4);
        Integer i3 = inventoryMapper.selectCountByExample(example);
        List<Integer> list = new ArrayList<>();
        i3 = i3 - i2;
        i2 = i2 - i1;
        list.add(i);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        return list;
    }


    public List<Inventory> queryAll(){
        return inventoryMapper.selectAll();
    }


    public Integer add(Inventory inventory){
        inventory.setCode(randomUtil.getCode());
        inventory.setInTime(new Timestamp(System.currentTimeMillis()));
        inventory.setEState(0);
        return inventoryMapper.insert(inventory);
    }
}
