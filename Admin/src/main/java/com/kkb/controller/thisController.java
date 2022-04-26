package com.kkb.controller;

import com.kkb.pojo.User;
import com.kkb.service.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author APPDE
 * @date 2022/4/16 13:24
 * @Version 1.0
 **/
@Controller
public class thisController {


    @Resource
    LoginService loginService;
    @Resource
    UserService userService;

    @Resource
    InventoryService inventoryService;


}
