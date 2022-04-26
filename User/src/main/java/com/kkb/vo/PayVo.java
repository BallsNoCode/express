package com.kkb.vo;

import lombok.Data;

/**
 * @author APPDE
 * @date 2022/4/15 21:46
 * @Version 1.0
 **/
@Data
public class PayVo {
    private Double discounts;
    private Double money;

    public PayVo(Double discounts, Double money) {
        this.discounts = discounts;
        this.money = money;
    }

    public PayVo() {
    }
}
