package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.OrderDetail;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, String> {    
}
