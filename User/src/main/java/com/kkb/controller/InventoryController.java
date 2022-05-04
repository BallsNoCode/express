package com.kkb.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Inventory;
import com.kkb.vo.ResultVo;
import com.kkb.vo.Top;
import lombok.val;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController extends thisController {

    /**
     * 查询用户所有快件
     *
     * @param pageNum 查询页数
     * @param session xxx
     * @return 结果对象
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ResultVo<Inventory> queryUserList(Integer pageNum, HttpSession session,String number) {
        String phone = (String) session.getAttribute("user");
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        PageInfo<Inventory> inventoryPageInfo = inventoryService.queryByPhone(pageNum, phone,number);
        return new ResultVo<>(inventoryPageInfo);
    }

    /**
     * @Description: 查询所有库存
     * @Author: APPDE
     * @Date: 2022/4/24 19:59
     * @param state: 查询条件（快递状态）
     * @return: com.kkb.vo.ResultVo<com.kkb.pojo.Inventory>
     **/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultVo<Inventory> queryAll(Integer state) {
        val list = inventoryService.queryAll(state);
        return new ResultVo<>(list);
    }

    /**
     * 根据单号查询快件
     *
     * @param number 单号
     * @return 快递对象
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResultVo<Inventory> queryByNum(String number) {
        val query = inventoryService.query(number);
        if (query.size() <= 0) {
            return new ResultVo<>(500, "暂无信息，请稍后重试！");
        } else {
            return new ResultVo<>(query);
        }
    }

    /**
     * 根据取件码查询
     *
     * @param code 取件码
     * @return 快递对象
     */
    @RequestMapping(value = "/queryByCode", method = RequestMethod.GET)
    public ResultVo<Inventory> queryByCode(String code) {
        Inventory inventory = inventoryService.queryByCode(code);
        if (ObjectUtils.isEmpty(inventory) || inventory.getEState() == 1) {
            return new ResultVo<>(500, "暂无信息，请稍后重试！");
        } else {
            return new ResultVo<>(inventory);
        }
    }

    /**
     * 添加快件
     *
     * @param inventory 快件信息对象
     * @return 结果对象
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultVo<Inventory> addInventory(Inventory inventory) {
        Integer integer = inventoryService.addInventory(inventory);
        if (integer == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "入库失败！");
    }

    /**
     * 删除快件（逻辑删除）
     *
     * @param code 删除快件取件码
     * @return 结果对象
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResultVo<Inventory> delInventory(String code) {
        Integer integer = inventoryService.delInventory(code);
        if (integer == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "取件失败,请稍后重试！");
    }

    /**
     * 更新快件信息
     *
     * @param id        快件id
     * @param inventory 更改信息对象
     * @return 结果对象
     */
    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public ResultVo<Inventory> updateInventory(@PathVariable("id") Long id, Inventory inventory) {
        inventory.setEId(id);
        Integer integer = inventoryService.updateInventory(inventory);
        if (integer == 1) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "修改失败！");
    }

    /**
     * 获取排行榜信息
     *
     * @param tableNumber 表页
     * @return 信息对象
     */
    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public ResultVo<Top> topInfo(Integer tableNumber) {
        List<Top> tops = inventoryService.topInfo(tableNumber);
        if (ObjectUtils.isEmpty(tops)) {
            return new ResultVo<>(500, "服务器错误，请稍后重试！");
        }
        return new ResultVo<>(tops);
    }


    /**
     * @Description: 主页数据输出
     * @Author: APPDE
     * @Date: 2022/4/24 18:51
     * @return: com.kkb.vo.ResultVo<java.lang.Integer>
     **/
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    public ResultVo<Integer> console() {
        List<Integer> list = inventoryService.console();
        return new ResultVo<>(list);
    }

    @RequestMapping(value = "/qrcodeUpdate",method = RequestMethod.POST)
    public ResultVo qrcodeUpdate(String num){
        val inventories = inventoryService.query(num);
        Inventory inventory = inventories.get(0);
        inventory.setEState(1);
        inventory.setOutTime(new Timestamp(System.currentTimeMillis()));
        val integer = inventoryService.updateInventory(inventory);
        if (integer > 0){
            return new ResultVo<>();
        }
        return new ResultVo<>(500,"出库失败，请稍后重试！");
    }
}
