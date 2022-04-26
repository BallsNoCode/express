package com.kkb.controller;

import com.kkb.pojo.Inventory;
import com.kkb.service.InventoryService;
import com.kkb.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author APPDE
 * @date 2022/4/24 15:13
 * @Version 1.0
 **/
@RestController
@RequestMapping("/inventory")
public class InventoryController extends thisController {

    @PutMapping("/insert")
    public ResultVo insert(Inventory inventory){
        Integer result = inventoryService.add(inventory);
        if (result < 1){
            return new ResultVo<>(500,"快递入库失败");
        }
        return new ResultVo<>();
    }

    @GetMapping("/list")
    public ResultVo<Inventory> queryAll(){
        List<Inventory> list = inventoryService.queryAll();
        return new ResultVo<>(list);
    }
}
