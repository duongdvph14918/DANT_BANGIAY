package com.fourmen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fourmen.entity.ShoeType;

public interface ShoeTypeService {

	ShoeType getById(Integer id);

	void delete(ShoeType entity);

	void deleteById(Integer id);

	Optional<ShoeType> findById(Integer id);

	List<ShoeType> findAll();

	Page<ShoeType> findAll(Pageable pageable);

	<S extends ShoeType> S save(S entity);
	
	 List<ShoeType> findByName1(String string);

		List<ShoeType> findByName(String name,Boolean status);

		List<ShoeType> findByStatus(Boolean status);

		ShoeType findByName2(String name);

		List<ShoeType> getAllStatus();

}
