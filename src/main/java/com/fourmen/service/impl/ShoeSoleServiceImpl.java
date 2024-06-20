package com.fourmen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fourmen.dao.ShoeSoleDao;
import com.fourmen.entity.ShoeSole;
import com.fourmen.service.ShoeSoleService;

@Service
public class ShoeSoleServiceImpl implements ShoeSoleService{
	
	@Autowired
	private ShoeSoleDao shoeSoleDao;

	@Override
	public <S extends ShoeSole> S save(S entity) {
		return shoeSoleDao.save(entity);
	}

	@Override
	public Page<ShoeSole> findAll(Pageable pageable) {
		return shoeSoleDao.findAll(pageable);
	}

	@Override
	public List<ShoeSole> findAll() {
		return shoeSoleDao.findAll();
	}

	@Override
	public Optional<ShoeSole> findById(Integer id) {
		return shoeSoleDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		shoeSoleDao.deleteById(id);
	}

	@Override
	public void delete(ShoeSole entity) {
		shoeSoleDao.delete(entity);
	}

	@Override
	public ShoeSole getById(Integer id) {
		return shoeSoleDao.getById(id);
	}

	public List<ShoeSole> findTop4Img() {
		// TODO Auto-generated method stub
		return shoeSoleDao.findTop4Img();
	}

	@Override
	public ShoeSole findByName(String name) {
		// TODO Auto-generated method stub
		return shoeSoleDao.findByName(name);
	}
	
	@Override
	public List<ShoeSole> getAllStatus() {
		// TODO Auto-generated method stub
		return shoeSoleDao.getAllStatus();
	}

	@Override
	public List<ShoeSole> findByName1(String name) {
		// TODO Auto-generated method stub
		return shoeSoleDao.findByName1(name);
	}

	@Override
	public List<ShoeSole> findByName(String name, Boolean status) {
		// TODO Auto-generated method stub
		return shoeSoleDao.findByName(name,status);
	}

	@Override
	public List<ShoeSole> findByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return shoeSoleDao.findByStatus(status);
	}
	
}
