package com.fourmen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.ShoeType;
@Repository
public interface ShoeTypeDao extends JpaRepository<ShoeType, Integer>{

	@Query("SELECT o FROM ShoeType o WHERE o.name LIKE ?1 and status = ?2")
	List<ShoeType> findByName(String name,Boolean status);

	@Query("SELECT o FROM ShoeType o WHERE o.status = ?1")
	List<ShoeType> findByStatus(Boolean status);

	@Query("SELECT o FROM ShoeType o WHERE o.name LIKE ?1")
	List<ShoeType> findByName1(String name);
	
	@Query("SELECT o FROM ShoeType o WHERE o.name LIKE ?1")
	ShoeType findByName2(String name);

	@Query("SELECT o FROM ShoeType o WHERE o.status ='1'")
	List<ShoeType> getAllStatus();
}
