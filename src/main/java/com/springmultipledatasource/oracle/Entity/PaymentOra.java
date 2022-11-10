package com.springmultipledatasource.oracle.Entity;

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
@Entity
@Table(name = "Payment")
@Builder
public class PaymentOra {
	
	
	@Id
	private int paymentid;
	
	@Column(name = "Payment_Count")
	private int paymentcount;
	
	@Column(name = "Payment_Date")
	private LocalDate paymentDate;
	
	@Column(name = "Payment_Day")
	private String paymentday;
	
	@Column(name = "Payee_Name")
	private String payeename;
	

}
