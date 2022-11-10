package com.springmultipledatasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmultipledatasource.mapper.OrderMapper;
import com.springmultipledatasource.mysql.Entity.OrderMysql;
import com.springmultipledatasource.mysql.repository.OrderMysqlRepository;
import com.springmultipledatasource.pojo.OrderDTO;



@Service
public class MysqlServiceImp  implements MysqlService{
	
	@Autowired
	private OrderMysqlRepository orderMysqlRepository;

	
	@Transactional
	@Override
	public void createOrder(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		
		OrderMysql ordermysql = OrderMapper.MAPPER_INSTANCE.toEntitymapper(orderDTO);
		orderMysqlRepository.save(ordermysql);
		
		
		
	}

}
