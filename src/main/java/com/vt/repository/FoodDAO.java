package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.Food;

@Repository
public interface FoodDAO extends JpaRepository<Food, String> {   
     
}
