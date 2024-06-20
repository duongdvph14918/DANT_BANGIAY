package com.fourmen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fourmen.entity.Color;

public interface ColorService {

	Color getById(Integer id);

	void delete(Color entity);

	void deleteById(Integer id);

	Optional<Color> findById(Integer id);

	List<Color> findAll();

	Page<Color> findAll(Pageable pageable);

	<S extends Color> S save(S entity);

	List<Color> findTop4Img();

	Color findByName(String name);
	
	List<Color> getAllStatus();
	
	List<Color> findByName1(String string);

	List<Color> findByName(String name,Boolean status);

	List<Color> findByStatus(Boolean status);

}
