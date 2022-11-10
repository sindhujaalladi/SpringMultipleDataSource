package com.springmultipledatasource.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO  implements Serializable {
	
	private int orderid;
	private String ordername;
	private String orderdate;
	private int ordercount;
	private String orderday;

}
