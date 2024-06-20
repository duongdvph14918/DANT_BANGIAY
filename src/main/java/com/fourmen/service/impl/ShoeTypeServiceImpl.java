package com.fourmen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fourmen.dao.ShoeTypeDao;
import com.fourmen.entity.ShoeType;
import com.fourmen.service.ShoeTypeService;
@Service
public class ShoeTypeServiceImpl implements ShoeTypeService{
	@Autowired
	private ShoeTypeDao shoeTypeDao;

	@Override
	public <S extends ShoeType> S save(S entity) {
		return shoeTypeDao.save(entity);
	}

	@Override
	public Page<ShoeType> findAll(Pageable pageable) {
		return shoeTypeDao.findAll(pageable);
	}

	@Override
	public List<ShoeType> findAll() {
		return shoeTypeDao.findAll();
	}

	@Override
	public Optional<ShoeType> findById(Integer id) {
		return shoeTypeDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		shoeTypeDao.deleteById(id);
	}

	@Override
	public void delete(ShoeType entity) {
		shoeTypeDao.delete(entity);
	}

	@Override
	public ShoeType getById(Integer id) {
		return shoeTypeDao.getById(id);
	}
	
	@Override
	public List<ShoeType> findByName1(String name) {
		// TODO Auto-generated method stub
		return shoeTypeDao.findByName1(name);
	}

	@Override
	public List<ShoeType> findByName(String name, Boolean status) {
		// TODO Auto-generated method stub
		return shoeTypeDao.findByName(name,status);
	}

	@Override
	public List<ShoeType> findByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return shoeTypeDao.findByStatus(status);
	}

	@Override
	public ShoeType findByName2(String name) {
		return shoeTypeDao.findByName2(name);
	}

	@Override
	public List<ShoeType> getAllStatus() {
		return shoeTypeDao.getAllStatus();
	}
	
	
}
