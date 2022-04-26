package com.kkb.service;

import com.kkb.pojo.Coupon;
import junit.framework.TestCase;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponServiceTest extends TestCase {

    @Resource
    private CouponService service;
    @Test
    public void t(){
        Coupon coupon = new Coupon();
        coupon.setCMoney(15.0000);
        coupon.setCCondition(40.1000);
        coupon.setCCost(5.0000);
        coupon.setCIntegral(2000L);
        List<Coupon> coupons = service.queryCoupon(coupon);
        coupons.forEach(System.out::println);
    }

    @Test
    public void TestUse(){
        val query = service.queryByUse("13333333333",20);
        System.out.println(query);
    }


}