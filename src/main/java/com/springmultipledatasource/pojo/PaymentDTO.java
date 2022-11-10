package com.springmultipledatasource.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO implements Serializable{
	
	
	private int paymentid;	
	private int paymentcount;	
	private LocalDate paymentDate;	
	private String paymentday;	
	private String payeename;

}
