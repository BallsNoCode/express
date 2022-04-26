package com.kkb.controller;

import com.kkb.pojo.Balance;
import com.kkb.pojo.Cdk;
import com.kkb.pojo.Coupon;
import com.kkb.service.BalanceService;
import com.kkb.service.CdkService;
import com.kkb.service.TransportService;
import com.kkb.service.UserService;
import com.kkb.vo.ResultVo;
import lombok.val;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/balance")
public class BalanceController extends thisController {

    private Balance balance;

    /**
     * 查询用户余额
     *
     * @param session session
     * @return 用户对象
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResultVo queryInfo(HttpSession session) {
        String phone = (String) session.getAttribute("user");
        balance = balanceService.queryInfo(phone);
        session.setAttribute("money",balance.getBalance());
        if (ObjectUtils.isEmpty(balance)) {
            return new ResultVo(500, "服务器错误，请稍后重试！");
        } else {
            return new ResultVo(balance);
        }
    }

    /**
     * 使用兑换码
     *
     * @param Num 兑换码
     * @return 结果对象
     */
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ResultVo pay(String Num) {
        Cdk cdk = cdkService.queryByNum(Num);
        if (ObjectUtils.isEmpty(cdk) || cdk.getKState() == 1) {
            return new ResultVo<>(500, "兑换码无效，请校验后重试！");
        } else {
            balance.setBalance(balance.getBalance() + cdk.getKMoney());
            balance.setIntegral(balance.getIntegral() + cdk.getKIntegral());
            Integer integer = cdkService.delCdk(cdk);
            Integer pay = balanceService.pay(balance);
            if (integer <= 0 || pay <= 0) {
                return new ResultVo<>(500, "充值失败，请稍后重试！");
            } else {
                return new ResultVo<>();
            }
        }
    }

    /**
     * @Description: 余额支付
     * @Author: APPDE
     * @Date: 2022/4/15 21:39
     * @param cost: 支付金额
     * @param session: session
     * @return: com.kkb.vo.ResultVo
     **/
    @RequestMapping(value = "/deduct",method = RequestMethod.POST)
    public ResultVo deduct(Double cost,Integer id,HttpSession session){
        String phone = String.valueOf(session.getAttribute("user"));
        val buy = balanceService.Buy(phone, cost);
        if (buy <= 0){
            return new ResultVo<>(500,"支付失败！");
        }
        transportService.updateIsPay(id);
        Coupon coupon = (Coupon) session.getAttribute("coupon");
        session.removeAttribute("coupon");
        couponService.delCoupon(coupon.getCId());
        return new ResultVo<>();
    }

}
