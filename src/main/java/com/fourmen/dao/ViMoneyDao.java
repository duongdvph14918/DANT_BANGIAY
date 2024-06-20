package com.fourmen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fourmen.entity.News;
import com.fourmen.entity.ViMoney;

public interface ViMoneyDao extends JpaRepository<ViMoney, String>{
	
	
	
}
