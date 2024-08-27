package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.Stall;

@Repository
public interface StallDAO extends JpaRepository<Stall, String> {
    
}
