package com.vt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> { 

}
