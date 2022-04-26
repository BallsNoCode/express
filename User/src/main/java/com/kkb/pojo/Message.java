package com.kkb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;

import java.util.Date;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2022-03-26 
 */

@Data
@Entity
@Table ( name ="message" )
public class Message  implements Serializable {

	private static final long serialVersionUID =  4633305729514560281L;

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "message" )
	private String message;

   	@Column(name = "phone" )
	private String phone;

   	@Column(name = "create_time" )
	private Date createTime;

   	@Column(name = "state" )
	private Long state;

   	@Column(name = "type" )
	private Long type;

}
