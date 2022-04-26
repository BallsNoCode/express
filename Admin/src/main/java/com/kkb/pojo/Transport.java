package com.kkb.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2022-02-13 
 */

@Data
@Entity
@Table (name ="transport")
public class Transport implements Serializable {

	private static final long serialVersionUID =  8484601833971624923L;

	@Id
   	@Column(name = "t_id" )
	private Long tId;

   	@Column(name = "t_number" )
	private String tNumber;

	@Column(name = "t_time" )
	private Timestamp tTime;

   	@Column(name = "sent_name" )
	private String sentName;

   	@Column(name = "sent_phone" )
	private String sentPhone;

   	@Column(name = "sent_location" )
	private String sentLocation;

   	@Column(name = "pick_name" )
	private String pickName;

   	@Column(name = "pick_phone" )
	private String pickPhone;

   	@Column(name = "pick_location" )
	private String pickLocation;

   	@Column(name = "company" )
	private String company;

   	@Column(name = "t_cost" )
	private Double tCost;

   	@Column(name = "t_state" )
	private Long tState;

}
