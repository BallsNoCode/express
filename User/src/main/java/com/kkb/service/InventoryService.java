package com.kkb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Inventory;
import com.kkb.pojo.User;
import com.kkb.mapper.InventoryMapper;
import com.kkb.util.RandomUtil;
import com.kkb.vo.Top;
import lombok.val;
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
public class InventoryService {

    @Resource
    private InventoryMapper inventoryMapper;

    @Resource
    private UserService userService;

    private RandomUtil randomUtil = new RandomUtil();

    /**
     * @Description: 查询所有库存
     * @Author: APPDE
     * @Date: 2022/4/24 19:57
     * @param state: 查询条件（快递状态）
     * @return: java.util.List<com.kkb.pojo.Inventory>
     **/
    public List<Inventory> queryAll(Integer state){
        Example example = new Example(Inventory.class);
        val criteria = example.createCriteria();
        if (state != null) {
            criteria.andEqualTo("eState", state);
        }
        return inventoryMapper.selectByExample(example);
    }

    /**
     * 根据单号查询快递
     *
     * @param number 单号
     * @return 查询对象
     */
    public Inventory queryByNum(String number) {
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eNumber", number);
        return inventoryMapper.selectOneByExample(example);
    }

    /**
     * 根据手机号查询快件
     *
     * @param pageNum 页数
     * @param phone   查询手机号
     * @return 分页数据
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Inventory> queryByPhone(Integer pageNum, String phone) {
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ePhone", phone);
        List<Inventory> inventories = inventoryMapper.selectByExample(example);
        PageHelper.startPage(pageNum, 5);
        return new PageInfo<>(inventories);
    }

    /**
     * 根据取件码查询
     *
     * @param code 取件码
     * @return Inventory对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Inventory queryByCode(String code) {
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("code", code);
        return inventoryMapper.selectOneByExample(example);
    }

    /**
     * 添加快件
     *
     * @param inventory 快件信息
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer addInventory(Inventory inventory) {
        inventory.setInTime(new Timestamp(System.currentTimeMillis()));
        inventory.setEState(0);
        inventory.setCode(randomUtil.getCode());
        return inventoryMapper.insert(inventory);
    }

    /**
     * 删除快件（逻辑删除）
     *
     * @param code 删除快件取件码
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer delInventory(String code) {
        Inventory inventory = queryByCode(code);
        inventory.setOutTime(new Timestamp(System.currentTimeMillis()));
        inventory.setEState(1);
        return updateInventory(inventory);
    }

    /**
     * 更新快件信息
     *
     * @param inventory 更新对象信息
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer updateInventory(Inventory inventory) {
        return inventoryMapper.updateByPrimaryKeySelective(inventory);
    }

    /**
     * 查询用户排行榜信息
     *
     * @param tableNum 表页
     * @return 信息对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Top> topInfo(Integer tableNum) {
        switch (tableNum) {
            //总排行榜
            case 1: {
                List<Top> tops = inventoryMapper.count1();
                tops.forEach(top -> {
                    User user = userService.queryByPhone(top.getE_phone());
                    top.setUserName(user.getUUsername());
                });
                return tops;
            }
            //年排行榜
            case 2: {
                List<Top> tops = inventoryMapper.count2();
                tops.forEach(top -> {
                    User user = userService.queryByPhone(top.getE_phone());
                    top.setUserName(user.getUUsername());
                });
                return tops;
            }
            //月排行榜
            case 3: {
                List<Top> tops = inventoryMapper.count3();
                tops.forEach(top -> {
                    User user = userService.queryByPhone(top.getE_phone());
                    top.setUserName(user.getUUsername());
                });
                return tops;
            }
            default: {
                return null;
            }
        }
    }

    /**
     * @Description: 管理员手机端数据统计
     * @Author: APPDE
     * @Date: 2022/4/24 19:55
     * @return: java.util.List<java.lang.Integer>
     **/
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<Integer> console(){
        val i = inventoryMapper.selectCount(null);
        Example example = new Example(Inventory.class);
        val criteria = example.createCriteria();
        criteria.orEqualTo("eState",0);
        Integer i1 = inventoryMapper.selectCountByExample(example);
        criteria.orEqualTo("eState",2);
        Integer i2 = inventoryMapper.selectCountByExample(example);
        criteria.orEqualTo("eState",3);
        Integer i3 = inventoryMapper.selectCountByExample(example);
        List<Integer> list = new ArrayList<>();
        i3 = i3 -i2;
        i2 = i2 -i1;
        list.add(i);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        return list;
    }
}
