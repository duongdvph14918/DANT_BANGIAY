package com.fourmen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fourmen.entity.ShoeSole;

public interface ShoeSoleService {

	ShoeSole getById(Integer id);

	void delete(ShoeSole entity);

	void deleteById(Integer id);

	Optional<ShoeSole> findById(Integer id);

	List<ShoeSole> findAll();

	Page<ShoeSole> findAll(Pageable pageable);

	<S extends ShoeSole> S save(S entity);

	List<ShoeSole> findTop4Img();

	ShoeSole findByName(String name);
	
	List<ShoeSole> getAllStatus();
	
	List<ShoeSole> findByName1(String string);

	List<ShoeSole> findByName(String name,Boolean status);

	List<ShoeSole> findByStatus(Boolean status);

}
