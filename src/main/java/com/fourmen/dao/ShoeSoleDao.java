package com.fourmen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.ShoeSole;

@Repository
public interface ShoeSoleDao extends JpaRepository<ShoeSole, Integer>{
	@Query(nativeQuery = true, value = "SELECT TOP 4 * FROM ShoeSole o ORDER BY o.id ASC")
	List<ShoeSole> findTop4Img();
	
	@Query("SELECT o FROM ShoeSole o WHERE o.name LIKE ?1")
	ShoeSole findByName(String name);
	

	@Query("SELECT o FROM ShoeSole o WHERE o.status = true")
	List<ShoeSole> getAllStatus();

		@Query("SELECT o FROM ShoeSole o WHERE o.name LIKE ?1 and status = ?2")
	List<ShoeSole> findByName(String name,Boolean status);
	
	@Query("SELECT o FROM ShoeSole o WHERE o.status = ?1")
	List<ShoeSole> findByStatus(Boolean status);

	@Query("SELECT o FROM ShoeSole o WHERE o.name LIKE ?1")
	List<ShoeSole> findByName1(String name);
}
