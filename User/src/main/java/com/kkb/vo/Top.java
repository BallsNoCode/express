package com.kkb.vo;

public class Top {

    private String e_phone;

    private Integer count;

    private String userName;

    @Override
    public String toString() {
        return "Top{" +
                "e_phone='" + e_phone + '\'' +
                ", count=" + count +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
