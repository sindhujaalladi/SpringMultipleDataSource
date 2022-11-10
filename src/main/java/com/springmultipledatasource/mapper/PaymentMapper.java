package com.springmultipledatasource.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springmultipledatasource.oracle.Entity.PaymentOra;
import com.springmultipledatasource.pojo.PaymentDTO;

@Mapper
public interface PaymentMapper {
	
	

	PaymentMapper MAPPER_INSTANCE = Mappers.getMapper(PaymentMapper.class);
	
	PaymentDTO toDTOmapper(PaymentOra payora);
	PaymentOra toEntitymapper(PaymentDTO paydto);

}
