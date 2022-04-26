package com.kkb.mapper;

import com.kkb.pojo.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author APPDE
 */
@Mapper
public interface CouponMapper extends tk.mybatis.mapper.common.Mapper<Coupon> {

    @Select("SELECT COUNT(*) AS num FROM coupon WHERE c_state=0 GROUP BY c_cost")
    List<Integer> couponNum();
    @Select("SELECT COUNT(*) AS num FROM coupon WHERE c_state=1 AND c_phone=#{phone} GROUP BY c_cost")
    List<Integer> mycouponNum(@Param("phone") String phone);
}
