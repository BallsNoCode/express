package com.kkb.service;

import com.kkb.pojo.Cdk;
import com.kkb.mapper.CdkMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author APPDE
 */
@Service
public class CdkService {

    @Resource
    private CdkMapper mapper;

    /**
     * 查找cdk
     *
     * @param Num cdk
     * @return 结果对象
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Cdk queryByNum(String Num) {
        Example example = new Example(Cdk.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("kNumber", Num);
        return mapper.selectOneByExample(example);
    }

    /**
     * 使用兑换码
     *
     * @param cdk 兑换码
     * @return 操作条数
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer delCdk(Cdk cdk) {
        cdk.setKState(1);
        return mapper.updateByPrimaryKey(cdk);
    }
}
