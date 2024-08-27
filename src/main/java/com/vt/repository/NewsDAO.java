package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.News;

@Repository
public interface NewsDAO extends JpaRepository<News, String> {    
}
