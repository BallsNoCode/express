package com.kkb.result;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author APPDE
 */
@Data
public class UserResult {
    private Integer id;
    private String uUsername;
    private String uPhone;
    private Timestamp uLogintime;
    private Integer packageNum;
    private Integer returnNum;
    private Integer sendNum;
    private Integer state;
}
