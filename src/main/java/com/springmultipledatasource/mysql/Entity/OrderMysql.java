package com.springmultipledatasource.mysql.Entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "OrdersHistory",schema = "demomysql")
public class OrderMysql {
	
	@Id
	private int orderid;
	
	@Column(name = "Order_Name")
	private String ordername;
	
	@Column(name = "Order_Date")
	private LocalDate orderdate;
	
	@Column(name = "Order_Count")
	private int ordercount;
	
	@Column(name = "Order_Day")
	private String orderday;
	

}
