package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.FoodCategory;
import com.vt.model.FoodCategoryId;

@Repository
public interface FoodCategoryDAO extends JpaRepository<FoodCategory, FoodCategoryId> {    
}
