package com.springmultipledatasource.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmultipledatasource.mysql.Entity.OrderMysql;

@Repository
public interface OrderMysqlRepository  extends JpaRepository<OrderMysql,Integer>{

}
