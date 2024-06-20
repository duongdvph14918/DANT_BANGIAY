package com.fourmen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.Style;

@Repository
public interface StyleDao extends JpaRepository<Style, Integer>{
	@Query(nativeQuery = true, value = "SELECT TOP 4 * FROM Style o ORDER BY o.id ASC")
	List<Style> findTop4Img();
	
	@Query("SELECT o FROM Style o WHERE o.name LIKE ?1")
	Style findByName(String name);
	

	@Query("SELECT o FROM Style o WHERE o.status = true")
	List<Style> getAllStatus();

		@Query("SELECT o FROM Style o WHERE o.name LIKE ?1 and status = ?2")
	List<Style> findByName(String name,Boolean status);
	
	@Query("SELECT o FROM Style o WHERE o.status = ?1")
	List<Style> findByStatus(Boolean status);

	@Query("SELECT o FROM Style o WHERE o.name LIKE ?1")
	List<Style> findByName1(String name);
}
