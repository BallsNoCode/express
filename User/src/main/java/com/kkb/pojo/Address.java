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
 * @Date 2022-04-26 
 */

@Data
@Entity
@Table ( name ="address" )
public class Address  implements Serializable {

	private static final long serialVersionUID =  3399505848560136230L;

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "address" )
	private String address;

   	@Column(name = "iddefault" )
	private Long iddefault;

   	@Column(name = "user_id" )
	private Long userId;

}
