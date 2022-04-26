package com.kkb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Coupon;
import com.kkb.mapper.CouponMapper;
import lombok.val;
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
public class CouponService {

    @Resource
    private CouponMapper mapper;

    /**
     * 分页查询所有优惠券
     *
     * @return 分页数据
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Coupon> queryAll(Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Coupon> coupons = mapper.selectAll();
        return new PageInfo<>(coupons);
    }

    /**
     * 查询优惠券
     *
     * @param coupon 优惠券条件
     * @return 所有符合条件优惠券集合
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Coupon> queryCoupon(Coupon coupon) {
        Example example = new Example(Coupon.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(coupon)) {
            criteria.andEqualTo("cMoney", coupon.getCMoney());
            criteria.andEqualTo("cCondition", coupon.getCCondition());
            criteria.andEqualTo("cCost", coupon.getCCost());
            criteria.andEqualTo("cIntegral", coupon.getCIntegral());
            criteria.andEqualTo("cState", 0);
        }
        return mapper.selectByExample(example);
    }

    /**
     * 查询优惠券剩余数量
     *
     * @return 各优惠券剩余数量集合
     */
    public List<Integer> queryCouponNum() {
        return mapper.couponNum();
    }

    public List<Integer> queryMyCouponNum(String phone) {
        return mapper.mycouponNum(phone);
    }

    /**
     * 兑换优惠券
     *
     * @param coupon 优惠券
     * @param phone  兑换用户手机号
     * @return 操作条数
     */
    public Integer userCoupon(Coupon coupon, String phone) {
        coupon.setCPhone(phone);
        coupon.setCState(1L);
        return mapper.updateByPrimaryKeySelective(coupon);
    }

    /**
     * @Description: 查询用户最佳优惠
     * @Author: APPDE
     * @Date: 2022/4/16 13:11
     * @param phone: 用户手机号
     * @param cost: 运费
     * @return: com.kkb.pojo.Coupon
     **/
    public Coupon queryByUse(String phone, Integer cost){
        Example example = new Example(Coupon.class);
        val criteria = example.createCriteria();
        criteria.andEqualTo("cPhone",phone);
        criteria.andLessThanOrEqualTo("cCondition",cost);
        val coupons = mapper.selectByExample(example);
        if (coupons.size() == 1){
            return coupons.get(0);
        }
        Double discount = 0.00;
        Coupon coupon = new Coupon();
        for (int i = 0; i < coupons.size() -1; i++) {
            if (discount >= coupons.get(i).getCMoney()){
                continue;
            }
            for (int j = coupons.size() -1; j > i; j--) {
                if (coupons.get(i).getCMoney() >= coupons.get(j).getCMoney()){
                    coupon  = coupons.get(i);
                } else {
                    coupon  = coupons.get(j);
                    break;
                }
            }
        }
        return coupon;
    }

    /**
     * @Description: 删除优惠券
     * @Author: APPDE
     * @Date: 2022/4/16 13:17
     * @param cId: 优惠券id
     * @return: java.lang.Boolean
     **/
    public Boolean delCoupon(Long cId){
        val i = mapper.deleteByPrimaryKey(cId);
        if (i > 0){
            return true;
        }
        return false;
    }
}
