package com.springmultipledatasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmultipledatasource.mapper.PaymentMapper;
import com.springmultipledatasource.oracle.Entity.PaymentOra;
import com.springmultipledatasource.oracle.repository.PaymentOraRepository;
import com.springmultipledatasource.pojo.PaymentDTO;


@Service
public class OracleServiceImp implements OracleService{
	
	@Autowired
	private PaymentOraRepository paymentOraRepository;

	@Override
	public void createPayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		
		PaymentOra payora = PaymentMapper.MAPPER_INSTANCE.toEntitymapper(paymentDTO);
		paymentOraRepository.save(payora);
		
	}

}
