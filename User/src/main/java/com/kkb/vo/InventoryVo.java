package com.kkb.vo;

import java.sql.Timestamp;

/**
 * @author APPDE
 */
public class InventoryVo {

    private String e_number;
    private String company;
    private String e_phone;
    private Integer e_state;
    private String code;
    private Timestamp inTime;

    public InventoryVo(String e_number, String company, String e_phone, Integer e_state, String code, Timestamp inTime) {
        this.e_number = e_number;
        this.company = company;
        this.e_phone = e_phone;
        this.e_state = e_state;
        this.code = code;
        this.inTime = inTime;
    }

    public InventoryVo() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public String getE_number() {
        return e_number;
    }

    public void setE_number(String e_number) {
        this.e_number = e_number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public Integer getE_state() {
        return e_state;
    }

    public void setE_state(Integer e_state) {
        this.e_state = e_state;
    }
}
