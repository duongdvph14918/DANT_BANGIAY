package com.fourmen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fourmen.entity.Style;

public interface StyleService {

	Style getById(Integer id);

	void delete(Style entity);

	void deleteById(Integer id);

	Optional<Style> findById(Integer id);

	List<Style> findAll();

	Page<Style> findAll(Pageable pageable);

	<S extends Style> S save(S entity);

	List<Style> findTop4Img();

	Style findByName(String name);
	
	List<Style> getAllStatus();
	
	List<Style> findByName1(String string);

	List<Style> findByName(String name,Boolean status);

	List<Style> findByStatus(Boolean status);

}
