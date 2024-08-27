package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.Cart;
import com.vt.model.CartId;

@Repository
public interface CartDAO extends JpaRepository<Cart, CartId> {   
     
}
