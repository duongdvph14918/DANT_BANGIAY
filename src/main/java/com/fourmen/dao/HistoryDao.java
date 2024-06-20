package com.fourmen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.History;

@Repository
public interface HistoryDao extends JpaRepository<History, Integer>{
	
	
	
}
