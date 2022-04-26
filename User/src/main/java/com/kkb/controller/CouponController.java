package com.kkb.controller;

import com.kkb.pojo.Balance;
import com.kkb.pojo.Coupon;
import com.kkb.service.BalanceService;
import com.kkb.service.CouponService;
import com.kkb.vo.PayVo;
import com.kkb.vo.ResultVo;
import lombok.val;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Resource
    private CouponService couponService;
    @Resource
    private BalanceService balanceService;

    /**
     * 查询各优惠券余量
     *
     * @return 封装结果集合
     */
    @RequestMapping(value = "/Num", method = RequestMethod.GET)
    public ResultVo<Integer> CouponNum() {
        List<Integer> integers = couponService.queryCouponNum();
        return new ResultVo<>(integers);
    }

    /**
     * 优惠券兑换
     *
     * @param coupon  优惠券对象
     * @param session session
     * @return 消息对象
     */
    @RequestMapping(value = "/cash", method = RequestMethod.POST)
    public ResultVo<Integer> CouponCash(Coupon coupon, HttpSession session) {
        String phone = (String) session.getAttribute("user");
        List<Coupon> coupons = couponService.queryCoupon(coupon);
        if (coupons.size() > 0) {
            Integer integer = couponService.userCoupon(coupons.get(0), phone);
            Balance balance = balanceService.queryInfo(phone);
            //积分扣除
            balanceService.cash(Math.toIntExact(balance.getBId()), coupon.getCCost());
            //余额扣除
            balanceService.Buy(phone, coupon.getCMoney());
            if (integer > 0) {
                return new ResultVo<>(integer);
            }
        }
        return new ResultVo<>(500,"服务器错误，请稍后重试");
    }

    /**
     * 获取我的优惠券数量
     *
     * @param session session
     * @return 数量集合
     */
    @RequestMapping(value = "/myNum", method = RequestMethod.GET)
    public ResultVo<Integer> myCouponNum(HttpSession session) {
        String phone = String.valueOf(session.getAttribute("user"));
        List<Integer> integers = couponService.queryMyCouponNum(phone);
        return new ResultVo<>(integers);
    }

    /**
     * @Description: 查询用户最佳优惠金额
     * @Author: APPDE
     * @Date: 2022/4/15 21:48
     * @param cost: 运费
     * @param session:  session
     * @return: com.kkb.vo.ResultVo<com.kkb.vo.PayVo>
     **/
    @RequestMapping(value = "/myDiscounts",method = RequestMethod.GET)
    public ResultVo<PayVo> myDiscounts(Integer cost,HttpSession session){
        String phone = String.valueOf(session.getAttribute("user"));
        if (ObjectUtils.isEmpty(cost)){
            return new ResultVo(500,"参数错误！");
        }
        val Coupon = couponService.queryByUse(phone, cost);
        session.setAttribute("coupon",Coupon);
        PayVo payVo = new PayVo(Coupon.getCMoney(), (Double) session.getAttribute("money"));
        return new ResultVo<>(payVo);
    }

}
