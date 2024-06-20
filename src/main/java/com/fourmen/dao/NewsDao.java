package com.fourmen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.News;

@Repository
public interface NewsDao extends JpaRepository<News, Integer>{
	
	
	
}
