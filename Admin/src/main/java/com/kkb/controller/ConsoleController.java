package com.kkb.controller;

import com.kkb.service.ConsoleService;
import com.kkb.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Resource
    private ConsoleService consoleService;

    /**
     * 主页数据
     * @return 数据集合
     */
    @RequestMapping(value = "/num",method = RequestMethod.GET)
    public ResultVo all(){
        List<Integer> list = consoleService.countAll();
        return new ResultVo<>(list);
    }

    /**
     * 主页当天数据
     * @return 数据集合
     */
    @RequestMapping(value = "/numTime",method = RequestMethod.GET)
    public ResultVo countTime(){
        List<Integer> list = consoleService.countTime();
        return new ResultVo<>(list);
    }



}
