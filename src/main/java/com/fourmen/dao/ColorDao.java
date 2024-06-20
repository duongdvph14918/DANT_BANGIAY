package com.fourmen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer>{
	@Query(nativeQuery = true, value = "SELECT TOP 4 * FROM Color o ORDER BY o.id ASC")
	List<Color> findTop4Img();
	
	@Query("SELECT o FROM Color o WHERE o.name LIKE ?1")
	Color findByName(String name);
	

	@Query("SELECT o FROM Color o WHERE o.status = true")
	List<Color> getAllStatus();

		@Query("SELECT o FROM Color o WHERE o.name LIKE ?1 and status = ?2")
	List<Color> findByName(String name,Boolean status);
	
	@Query("SELECT o FROM Color o WHERE o.status = ?1")
	List<Color> findByStatus(Boolean status);

	@Query("SELECT o FROM Color o WHERE o.name LIKE ?1")
	List<Color> findByName1(String name);
}
