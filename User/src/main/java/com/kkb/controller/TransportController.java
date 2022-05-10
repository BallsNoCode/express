package com.kkb.controller;

import com.kkb.pojo.Coupon;
import com.kkb.pojo.Transport;
import com.kkb.service.CouponService;
import com.kkb.service.TransportService;
import com.kkb.vo.ResultVo;
import lombok.val;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/transport")
public class TransportController {

    @Resource
    private TransportService transportService;

    @Resource
    private CouponService couponService;

    /**
     * 寄快递
     *
     * @param transport 快递信息
     * @return 结果对象
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultVo add(Transport transport, HttpSession session) {
        Long id = (Long) session.getAttribute("id");
        transport.setUserid(id);
        Integer add = transportService.add(transport);
        if (add <= 0) {
            return new ResultVo<>(500, "服务器错误，请稍后重试！");
        } else {
            return new ResultVo<>();
        }
    }

    /**
     * @param number: 查询快递单号
     * @Description: 根据运单单号查询快递
     * @Author: APPDE
     * @Date: 2022/4/15 14:45
     * @return: com.kkb.vo.ResultVo<com.kkb.pojo.Transport>
     **/
    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public ResultVo<Transport> queryByNumber(@PathVariable("number") String number) {
        if (StringUtils.isEmpty(number)){
            return new ResultVo<>(500,"参数错误！");
        }
        Transport transport = transportService.queryByNumber(number);
        if (ObjectUtils.isEmpty(transport)){
            return new ResultVo<>(404,"暂无快递信息");
        }
        return new ResultVo<>(transport);
    }

    /**
     * @Description: 查询用户所有运单信息
     * @Author: APPDE
     * @Date: 2022/4/15 15:05
     * @param session: session
     * @return: com.kkb.vo.ResultVo<com.kkb.pojo.Transport>
     **/
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVo<Transport> queryByUser(HttpSession session){
        Integer id = (Integer) session.getAttribute("id");
        List<Transport> transports = transportService.queryByUser(id);
        if (transports.size() == 0){
            return new ResultVo<>(404,"暂无寄件信息");
        }
        return new ResultVo<>(transports);
    }

    @RequestMapping(value = "/ispay" ,method = RequestMethod.POST)
    public ResultVo isPay(HttpSession session){
        Integer tid = (Integer) session.getAttribute("tid");
        Integer result = transportService.updateIsPay(tid);
        if (result <= 0){
            return new ResultVo<>(500,"付款异常，若已付款，请联系站点处理！");
        }
        Coupon coupon = (Coupon) session.getAttribute("coupon");
        session.removeAttribute("coupon");
        session.removeAttribute("tid");
        val aBoolean = couponService.delCoupon(coupon.getCId());
        if (aBoolean){
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"优惠券使用异常，请稍后重试！");
    }

    @RequestMapping(value = "/console",method = RequestMethod.GET)
    public ResultVo<Integer> console(Integer id){
        val console = transportService.console(id);
        return new ResultVo<>(console);
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public ResultVo del(Integer id){
        val del = transportService.del(id);
        if (del > 0){
            return new ResultVo<>();
        } else {
            return new ResultVo<>(500,"取消订单失败！");
        }
    }
}
