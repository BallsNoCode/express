package com.kkb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2022-05-04 
 */

@Data
@Entity
@Table ( name ="address" )
public class Address  implements Serializable {

	private static final long serialVersionUID =  4765047234530289261L;

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "info" )
	private String info;

   	@Column(name = "iddefault" )
	private Long iddefault;

   	@Column(name = "user_id" )
	private Long userId;

   	@Column(name = "area" )
	private String area;

   	@Column(name = "phone" )
	private String phone;

}
