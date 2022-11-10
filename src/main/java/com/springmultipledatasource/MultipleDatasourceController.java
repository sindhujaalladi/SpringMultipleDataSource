package com.springmultipledatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmultipledatasource.pojo.OrderDTO;
import com.springmultipledatasource.pojo.PaymentDTO;
import com.springmultipledatasource.service.MysqlService;
import com.springmultipledatasource.service.OracleService;

@RestController
@RequestMapping("/v1/api/multipledatasource")
public class MultipleDatasourceController {
	
	
	@Autowired
	OracleService oracleService;
	
	@Autowired
	MysqlService mysqlService;
	
	
	@PostMapping("/createpayment")
	public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO PaymentDTO) {
		this.oracleService.createPayment(PaymentDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PostMapping("/createorder")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
		this.mysqlService.createOrder(orderDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

}
