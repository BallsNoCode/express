package com.kkb.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Inventory;
import com.kkb.service.ExpressService;
import com.kkb.vo.ResultVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/inventory")
public class ExpressController {

    @Resource
    private ExpressService expressService;

    /**
     * 库存集合
     * @param pageNum 页数
     * @param pageSize 大小
     * @param number 查询单号
     * @return pageInfo对象
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultVo<Inventory> queryByPage(Integer pageNum, Integer pageSize, String number) {
        if (ObjectUtils.isEmpty(pageNum)) {
            pageNum = 1;
        }
        if (ObjectUtils.isEmpty(pageSize)) {
            pageSize = 5;
        }
        PageInfo<Inventory> inventoryPageInfo = expressService.queryByPage(pageNum, pageSize, number);
        return new ResultVo<>(inventoryPageInfo);
    }

    /**
     * 通过id查询库存
     * @param id 查询id
     * @return 查询结果对象
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultVo<Inventory> queryById(@PathVariable("id") Integer id) {
        Inventory inventory = expressService.queryById(id);
        return new ResultVo<>(inventory);
    }

    /**
     * 快递入库
     * @param inventory 入库快递基本信息（公司，单号，手机号，姓名）
     * @return 信息对象
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVo add(Inventory inventory) {
        if (!ObjectUtils.isEmpty(inventory)) {
            Integer add = expressService.add(inventory);
            if (add <= 0) {
                return new ResultVo<>(500, "添加失败，请稍后重试！");
            }
            return new ResultVo<>(200, "添加成功！");
        }
        return new ResultVo<>("数据有误，请稍后重试！");
    }

    /**
     * 快递信息更新
     * @param inventory 快递修改信息（单号，公司，姓名，手机号，取件码）
     * @return 信息对象
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVo update(Inventory inventory) {
        if (!ObjectUtils.isEmpty(inventory)) {
            Integer update = expressService.update(inventory);
            if (update <= 0) {
                return new ResultVo<>(500, "修改失败，请稍后重试！");
            }
            return new ResultVo<>();
        }
        return new ResultVo<>("数据有误，修改失败！");
    }

    /**
     *  发送短信
     * @param inventory 发送短信快递对象（姓名，手机号，取件码）
     * @return 消息对象
     */
    @RequestMapping(value = "/sentSMS", method = RequestMethod.POST)
    public ResultVo sent(Inventory inventory) {
        if (ObjectUtils.isEmpty(inventory)) {
            return new ResultVo<>(500, "发送失败，请检查用户信息！");
        }
        Boolean aBoolean = expressService.sentSsm(inventory);
        if (aBoolean) {
            return new ResultVo<>();
        }
        return new ResultVo<>(500, "发送失败，请稍后重试！");
    }

    /**
     * 删除快递
     * @param id 快递编号
     * @return 消息对象
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.POST)
    public ResultVo del(@PathVariable("id") Integer id) {
        if (!ObjectUtils.isEmpty(id)) {
            Integer del = expressService.del(id);
            if (del <= 0) {
                return new ResultVo<>("删除失败，请稍后重试！");
            }
            return new ResultVo<>();
        }
        return new ResultVo<>("数据有误，请稍后重试！");
    }


}
