package com.kkb.controller;

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
    UserService userService;
    @Resource
    BalanceService balanceService;
    @Resource
    CdkService cdkService;
    @Resource
    TransportService transportService;
    @Resource
    CouponService couponService;
    @Resource
    PayService payService;
    @Resource
    InventoryService inventoryService;
    @Resource
    AddressService addressService;
    @Resource
    EmailService emailService;


}
