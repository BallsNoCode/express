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
@Table (name ="inventory")
public class Inventory implements Serializable {

	private static final long serialVersionUID =  9190651141711799513L;

	@Id
   	@Column(name = "e_id" )
	private Long eId;

   	@Column(name = "e_number" )
	private String eNumber;

   	@Column(name = "recipients" )
	private String recipients;

   	@Column(name = "e_phone" )
	private String ePhone;

   	@Column(name = "company" )
	private String company;

   	@Column(name = "code" )
	private String code;

   	@Column(name = "in_time" )
	private Timestamp inTime;

   	@Column(name = "out_time" )
	private Timestamp outTime;

	@Column(name = "is_sent")
	private Integer isSent;

   	@Column(name = "e_state" )
	private Integer eState;

}
