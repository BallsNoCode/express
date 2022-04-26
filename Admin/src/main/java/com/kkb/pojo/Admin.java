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
 * @Date 2022-03-27 
 */

@Data
@Entity
@Table (name ="admin")
public class Admin  implements Serializable {

	private static final long serialVersionUID =  1815957523238855000L;

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "username" )
	private String username;

   	@Column(name = "password" )
	private String password;

   	@Column(name = "state" )
	private Long state;

   	@Column(name = "type" )
	private Long type;

}
