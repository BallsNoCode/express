package com.kkb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Transport;
import com.kkb.mapper.TransportMapper;
import com.kkb.util.RandomUtil;
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
public class TransportService {

    @Resource
    private TransportMapper transportMapper;

    private RandomUtil randomUtil = new RandomUtil();

    /**
     * 分页查询运单
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param number 查询单号
     * @return 查询集合
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public PageInfo<Transport> queryByPage(Integer pageNum, Integer pageSize,String number){
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Transport.class);
        Example.Criteria criteria = example.createCriteria();
        //判断是否为查询单号
        if (!ObjectUtils.isEmpty(number) && !"".equals(number.trim())){
            criteria.andEqualTo("tNumber",number);
        }
        List<Transport> transportList = transportMapper.selectByExample(example);
        return new PageInfo<>(transportList);
    }

    /**
     * 根据id查询运单
     * @param id 查询id
     * @return 运单对象
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Transport queryById(Integer id){
        return transportMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改运单对象
     * @param transport 修改信息
     * @return 操作对象
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer update(Transport transport){
        return transportMapper.updateByPrimaryKeySelective(transport);
    }

    /**
     * 添加运单
     * @param transport 添加信息
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer add(Transport transport){
        transport.setTTime(new Timestamp(System.currentTimeMillis()));
        transport.setTNumber(randomUtil.getRandomNumber(12));
        transport.setTState(0L);
        return transportMapper.insert(transport);
    }

    /**
     * 删除运单
     * @param id 删除id
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer del(Integer id){
        return transportMapper.deleteByPrimaryKey(id);
    }
}
