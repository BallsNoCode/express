package com.kkb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2022-02-13 
 */

@Data
@Entity
@Table ( name ="coupon" )
public class Coupon implements Serializable {

	private static final long serialVersionUID =  7098918104448023295L;

	@Id
   	@Column(name = "c_id" )
	private Long cId;

   	@Column(name = "c_phone" )
	private String cPhone;

   	@Column(name = "c_money" )
	private Double cMoney;

   	@Column(name = "c_condition" )
	private Double cCondition;

   	@Column(name = "c_cost" )
	private Double cCost;

   	@Column(name = "c_integral" )
	private Long cIntegral;

   	@Column(name = "c_state" )
	private Long cState;

}
