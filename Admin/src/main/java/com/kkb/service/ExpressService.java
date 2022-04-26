package com.kkb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Inventory;
import com.kkb.mapper.InventoryMapper;
import com.kkb.util.RandomUtil;
import com.kkb.util.SMSUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author APPDE
 */
@Service
public class ExpressService {

    @Resource
    private InventoryMapper inventoryMapper;
    private RandomUtil randomUtil = new RandomUtil();
    private SMSUtil smsUtil = new SMSUtil();

    /**
     * 分页查询库存
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param number 查询单号
     * @return 查询结果集合
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Inventory> queryByPage(Integer pageNum, Integer pageSize, String number) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Inventory.class);
        Example.Criteria criteria = example.createCriteria();
        //判断是否查询单号
        if (!ObjectUtils.isEmpty(number) && !"".equals(number.trim())){
            criteria.andEqualTo("eNumber",number);
        }
        List<Inventory> inventories = inventoryMapper.selectByExample(example);
        return new PageInfo<>(inventories);
    }

    /**
     * 根据id查询库存
     * @param id id
     * @return 查询对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Inventory queryById(Integer id) {
        return inventoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改库存快递消息
     * @param inventory 修改消息
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer update(Inventory inventory) {
        return inventoryMapper.updateByPrimaryKeySelective(inventory);
    }

    /**
     * 发送短信通知
     * @param inventory 发送消息快递
     * @return 发送结果
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Boolean sentSsm(Inventory inventory){
        if (ObjectUtils.isEmpty(inventory)){
            return false;
        }
        return smsUtil.send(inventory.getEPhone(), inventory.getCode(), inventory.getRecipients());
    }

    /**
     * 快递入库
     * @param inventory 入库信息
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer add(Inventory inventory) {
        //设置入库时间，随机生成取件码，设置默认未发送短信，未取件
        inventory.setInTime(new Timestamp(System.currentTimeMillis()));
        inventory.setCode(randomUtil.getCode());
        inventory.setIsSent(0);
        inventory.setEState(0);
        return inventoryMapper.insert(inventory);
    }

    /**
     * 删除库存快递
     * @param id 删除快递id
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer del(Integer id) {
        return inventoryMapper.deleteByPrimaryKey(id);
    }

}
