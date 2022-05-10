package com.kkb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2022-05-11 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="vip" )
public class Vip  implements Serializable {

	private static final long serialVersionUID =  2789193200768765696L;

	@Id
   	@Column(name = "uid" )
	private Long uid;

   	@Column(name = "time" )
	private Timestamp time;

   	@Column(name = "lev" )
	private Long lev;

}
