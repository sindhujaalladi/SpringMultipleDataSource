package com.springmultipledatasource.oracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmultipledatasource.oracle.Entity.PaymentOra;

@Repository
public interface PaymentOraRepository  extends JpaRepository<PaymentOra,Integer>{

}
