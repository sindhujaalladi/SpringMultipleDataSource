package com.springmultipledatasource.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springmultipledatasource.mysql.Entity.OrderMysql;
import com.springmultipledatasource.pojo.OrderDTO;

@Mapper
public interface OrderMapper {
	

	OrderMapper MAPPER_INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	OrderDTO toDTOmapper(OrderMysql payora);
	OrderMysql toEntitymapper(OrderDTO paydto);


}
