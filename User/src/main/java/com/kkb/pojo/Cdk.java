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
@Table ( name ="cdk" )
public class Cdk implements Serializable {

	private static final long serialVersionUID =  6459977653051231683L;

	@Id
   	@Column(name = "k_id" )
	private Integer kId;

   	@Column(name = "k_number" )
	private String kNumber;

   	@Column(name = "k_integral" )
	private Long kIntegral;

   	@Column(name = "k_money" )
	private Double kMoney;

   	@Column(name = "k_state" )
	private Integer kState;

}
