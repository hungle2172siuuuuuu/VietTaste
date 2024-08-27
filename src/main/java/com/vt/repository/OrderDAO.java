package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, String> {    
}
