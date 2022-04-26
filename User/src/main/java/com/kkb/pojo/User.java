package com.kkb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2022-02-13 
 */

@Data
@Entity
@Table ( name ="user" )
public class User implements Serializable {

	private static final long serialVersionUID =  2370061766436963797L;

	@Id
   	@Column(name = "u_id" )
	private Long uId;

   	@Column(name = "u_username" )
	private String uUsername;

   	@Column(name = "u_password" )
	private String uPassword;

   	@Column(name = "u_idCard" )
	private String uIdCard;

   	@Column(name = "u_trueName" )
	private String uTrueName;

   	@Column(name = "u_sex" )
	private Long uSex;

   	@Column(name = "u_age" )
	private Long uAge;

   	@Column(name = "u_phone" )
	private String uPhone;

   	@Column(name = "u_createtime" )
	private Timestamp uCreatetime;

   	@Column(name = "u_logintime" )
	private Timestamp uLogintime;

   	@Column(name = "u_state" )
	private Long uState;

}
