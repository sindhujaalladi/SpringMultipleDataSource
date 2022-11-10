package com.springmultipledatasource.service;

import com.springmultipledatasource.pojo.OrderDTO;

public interface MysqlService {
	
	void createOrder(OrderDTO orderDTO);

}
