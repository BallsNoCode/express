package com.kkb.controller;

import com.kkb.pojo.Address;
import com.kkb.vo.ResultVo;
import lombok.val;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author APPDE
 * @date 2022/4/26 10:13
 * @Version 1.0
 **/
@RestController
@RequestMapping("/address")
public class AddressController extends thisController {

    /**
     * @param session: session
     * @Description: 查询用户所有地址信息
     * @Author: APPDE
     * @Date: 2022/5/4 0:19
     * @return: com.kkb.vo.ResultVo<com.kkb.pojo.Address>
     **/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultVo<Address> queryUserAddress(HttpSession session,Integer id) {
        Integer uid = (Integer) session.getAttribute("id");
        if (uid == null) {
            return new ResultVo<>(500, "用户状态异常，请重新登录！");
        }
        val addresses = addressService.queryByUser(uid,id);
        return new ResultVo<>(addresses);
    }

    /**
     * @Description: 新增地址
     * @Author: APPDE
     * @Date: 2022/5/4 1:01
     * @param address: 新增地址信息
     * @return: com.kkb.vo.ResultVo
     **/
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVo addAddress(Address address,HttpSession session) {
        if (ObjectUtils.isEmpty(address)) {
            return new ResultVo<>(500, "数据错误，请重新填写！");
        }
        Integer id = (Integer) session.getAttribute("id");
        address.setUserId(Long.valueOf(id));
        val aBoolean = addressService.addAddress(address);
        return aBoolean ? new ResultVo<>() : new ResultVo<>(500, "添加失败！");
    }

    /**
     * @Description: 修改地址信息
     * @Author: APPDE
     * @Date: 2022/5/4 1:35
     * @param address: 地址信息
     * @return: com.kkb.vo.ResultVo
     **/
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultVo updateAddress(Address address){
        val aBoolean = addressService.updateAddress(address);
        if (ObjectUtils.isEmpty(address)) {
            return new ResultVo<>(500, "数据错误，请重新填写！");
        }
        return aBoolean ? new ResultVo<>() : new ResultVo<>(500, "修改失败！");
    }


}
