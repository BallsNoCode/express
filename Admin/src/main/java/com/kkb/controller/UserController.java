package com.kkb.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.User;
import com.kkb.service.UserService;
import com.kkb.vo.ResultVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author APPDE
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 分页查询用户集合
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param name 模糊查询名字
     * @return 查询对象
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVo<User> queryByPage(Integer pageNum,Integer pageSize,String name){
        if (ObjectUtils.isEmpty(pageNum)){
            pageNum = 1;
        }
        if (ObjectUtils.isEmpty(pageSize)){
            pageSize = 5;
        }
        PageInfo<User> userPageInfo =  userService.queryByPage(pageNum, pageSize,name);
        return new ResultVo<>(userPageInfo);
    }

}
