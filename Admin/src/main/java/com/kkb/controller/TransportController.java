package com.kkb.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Transport;
import com.kkb.service.TransportService;
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
@RequestMapping("/transport")
public class TransportController {

    @Resource
    private TransportService transportService;

    /**
     * 分页查询运单
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param number 模糊查询单号
     * @return 查询集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultVo<Transport> queryByPage(Integer pageNum, Integer pageSize,String number) {
        if (ObjectUtils.isEmpty(pageNum) && pageNum == null) {
            pageNum = 1;
        }
        if (ObjectUtils.isEmpty(pageSize) && pageSize == null) {
            pageSize = 5;
        }
        PageInfo<Transport> transportPageInfo = transportService.queryByPage(pageNum, pageSize,number);
        return new ResultVo<>(transportPageInfo);
    }

    /**
     * 根据编号查询运单
     * @param id 查询编号
     * @return 查询对象
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultVo<Transport> queryById(@PathVariable("id") Integer id) {
        Transport transport = transportService.queryById(id);
        if (ObjectUtils.isEmpty(transport)) {
            return new ResultVo<>(500, "获取失败，请稍后重试！");
        }
        return new ResultVo<>(transport);
    }

    /**
     * 更新运单消息
     * @param transport 修改的运单信息
     * @return 消息对象
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVo updateInfo(Transport transport) {
        Integer result = transportService.update(transport);
        if (result > 0) {
            return new ResultVo(200, "更新成功！");
        } else {
            return new ResultVo(500, "更新失败，请稍后重试！");
        }
    }

    /**
     * 添加运单（寄快递）
     * @param transport 运单信息
     * @return 消息对象
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVo add(Transport transport) {
        Integer add = transportService.add(transport);
        if (add > 0) {
            return new ResultVo(200, "添加成功！");
        } else {
            return new ResultVo(500, "添加失败！");
        }
    }

    /**
     * 删除运单
     * @param id 删除运单编号
     * @return 消息对象
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.POST)
    public ResultVo del(@PathVariable("id") Integer id) {
        Integer result = transportService.del(id);
        if (result > 0) {
            return new ResultVo(200, "删除成功！");
        } else {
            return new ResultVo(500, "删除失败！");
        }
    }


}
