package com.kkb.controller;

import com.kkb.pojo.Inventory;
import com.kkb.service.InventoryService;
import com.kkb.vo.InventoryVo;
import com.kkb.vo.ResultVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author APPDE
 */
@RestController
public class QRCodeController {

    @Resource
    private InventoryService inventoryService;

    /**
     * 储存快递二维码生成信息
     *
     * @param request  request
     * @param response response
     * @param session  session
     * @throws ServletException forward
     * @throws IOException      forward
     */
    @RequestMapping("/createQRCode")
    public void createQrcode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String code = request.getParameter("code");
        //express | user
        String type = request.getParameter("type");
        String userPhone = null;
        String qRCodeContent = null;
        if ("express".equals(type)) {
            //快递二维码:被扫后,展示单个快递的信息
            //code
            qRCodeContent = "express_" + code;
        } else {
            //用户二维码:被扫后,快递员(柜子)端展示用户所有快递
            //userPhone
            userPhone = (String) session.getAttribute("user");
            qRCodeContent = "userPhone_" + userPhone;
        }
        session.setAttribute("qrcode", qRCodeContent);
        request.getRequestDispatcher("/admin/personQRcode.html").forward(request, response);
    }

    /**
     * 生成二维码
     *
     * @param session session
     * @return 二维码信息
     */
    @RequestMapping("/qrcode")
    public ResultVo getQRCode(HttpSession session) {
        String qrcode = (String) session.getAttribute("qrcode");
        if (qrcode == null) {
            return new ResultVo<>(500, "取件码获取出错,请用户重新操作");
        } else {
            return new ResultVo<>(200, qrcode);
        }
    }

    /**
     * 扫码后更新信息
     *
     * @param request request
     * @return 扫描结果
     */
    @RequestMapping("/updateStatus")
    public ResultVo updateExpressStatus(HttpServletRequest request) {
        String code = request.getParameter("code");
        Inventory inventory = inventoryService.queryByCode(code);
        if (ObjectUtils.isEmpty(inventory)) {
            return new ResultVo<>(500, "取件码不存在,请用户更新二维码");
        } else {
            inventory.setEState(1);
            Integer integer = inventoryService.updateInventory(inventory);
            if (integer <= 0) {
                return new ResultVo<>(500, "取件失败,请用户更新二维码");
            } else {
                return new ResultVo<>();
            }
        }
    }

    /**
     * 查询扫描结果对象
     *
     * @param request request
     * @return 结果对象
     */
    @RequestMapping("/findExpressByCode")
    public ResultVo findExpressByCode(HttpServletRequest request) {
        String code = request.getParameter("code");
        Inventory inventory = inventoryService.queryByCode(code);
        InventoryVo vo = new InventoryVo(inventory.getENumber(), inventory.getCompany(), inventory.getEPhone(), Math.toIntExact(inventory.getEState()), inventory.getCode(), inventory.getInTime());
        if (ObjectUtils.isEmpty(vo)) {
            return new ResultVo<>(vo);
        } else {
            return new ResultVo<>(500, "取件码不存在");
        }
    }
}
