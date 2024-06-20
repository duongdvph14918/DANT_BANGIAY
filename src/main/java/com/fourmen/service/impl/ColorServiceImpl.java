package com.fourmen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fourmen.dao.ColorDao;
import com.fourmen.entity.Color;
import com.fourmen.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService{
	
	@Autowired
	private ColorDao colorDao;

	@Override
	public <S extends Color> S save(S entity) {
		return colorDao.save(entity);
	}

	@Override
	public Page<Color> findAll(Pageable pageable) {
		return colorDao.findAll(pageable);
	}

	@Override
	public List<Color> findAll() {
		return colorDao.findAll();
	}

	@Override
	public Optional<Color> findById(Integer id) {
		return colorDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		colorDao.deleteById(id);
	}

	@Override
	public void delete(Color entity) {
		colorDao.delete(entity);
	}

	@Override
	public Color getById(Integer id) {
		return colorDao.getById(id);
	}

	public List<Color> findTop4Img() {
		// TODO Auto-generated method stub
		return colorDao.findTop4Img();
	}

	@Override
	public Color findByName(String name) {
		// TODO Auto-generated method stub
		return colorDao.findByName(name);
	}
	
	@Override
	public List<Color> getAllStatus() {
		// TODO Auto-generated method stub
		return colorDao.getAllStatus();
	}

	@Override
	public List<Color> findByName1(String name) {
		// TODO Auto-generated method stub
		return colorDao.findByName1(name);
	}

	@Override
	public List<Color> findByName(String name, Boolean status) {
		// TODO Auto-generated method stub
		return colorDao.findByName(name,status);
	}

	@Override
	public List<Color> findByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return colorDao.findByStatus(status);
	}
	
}
