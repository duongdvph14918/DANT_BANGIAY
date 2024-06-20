package com.fourmen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fourmen.dao.StyleDao;
import com.fourmen.entity.Style;
import com.fourmen.service.StyleService;

@Service
public class StyleServiceImpl implements StyleService{
	
	@Autowired
	private StyleDao styleDao;

	@Override
	public <S extends Style> S save(S entity) {
		return styleDao.save(entity);
	}

	@Override
	public Page<Style> findAll(Pageable pageable) {
		return styleDao.findAll(pageable);
	}

	@Override
	public List<Style> findAll() {
		return styleDao.findAll();
	}

	@Override
	public Optional<Style> findById(Integer id) {
		return styleDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		styleDao.deleteById(id);
	}

	@Override
	public void delete(Style entity) {
		styleDao.delete(entity);
	}

	@Override
	public Style getById(Integer id) {
		return styleDao.getById(id);
	}

	public List<Style> findTop4Img() {
		// TODO Auto-generated method stub
		return styleDao.findTop4Img();
	}

	@Override
	public Style findByName(String name) {
		// TODO Auto-generated method stub
		return styleDao.findByName(name);
	}
	
	@Override
	public List<Style> getAllStatus() {
		// TODO Auto-generated method stub
		return styleDao.getAllStatus();
	}

	@Override
	public List<Style> findByName1(String name) {
		// TODO Auto-generated method stub
		return styleDao.findByName1(name);
	}

	@Override
	public List<Style> findByName(String name, Boolean status) {
		// TODO Auto-generated method stub
		return styleDao.findByName(name,status);
	}

	@Override
	public List<Style> findByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return styleDao.findByStatus(status);
	}
	
}
