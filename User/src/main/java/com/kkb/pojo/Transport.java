package com.kkb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Description
 * @Author Hunter
 * @Date 2022-05-10
 */

@Setter
@Getter
@ToString
@Entity
@Table(name = "transport")
public class Transport implements Serializable {

    private static final long serialVersionUID = 2412288321351861702L;

    @Id
    @Column(name = "t_id")
    private Long tId;

    @Column(name = "t_number")
    private String tNumber;

    @Column(name = "company")
    private String company;

    @Column(name = "t_cost")
    private Double tCost;

    @Column(name = "t_state")
    private Long tState;

    @Column(name = "t_time")
    private Date tTime;

    @Column(name = "t_ispay")
    private Long tIspay;

    @Column(name = "pickid")
    private Long pickid;

    @Column(name = "sentid")
    private Long sentid;

    @Column(name = "userid")
    private Long userid;

}
