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
@Table ( name ="balance" )
public class Balance  implements Serializable {

	private static final long serialVersionUID =  5064777253470623544L;

	@Id
   	@Column(name = "b_id" )
	private Long bId;

   	@Column(name = "b_phone" )
	private String bPhone;

   	@Column(name = "balance" )
	private Double balance;

   	@Column(name = "integral" )
	private Long integral;

   	@Column(name = "b_state" )
	private Long bState;

}
