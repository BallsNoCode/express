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
 * @Date 2022-04-15 
 */

@Data
@Entity
@Table ( name ="pay" )
public class Pay  implements Serializable {

	private static final long serialVersionUID =  5181211117386478946L;

	@Id
   	@Column(name = "uid" )
	private Long uid;

   	@Column(name = "payPassword" )
	private String payPassword;

}
