package com.fourmen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fourmen.dao.ProductDao;
import com.fourmen.entity.Product;
import com.fourmen.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
		
	@Autowired 
	ProductDao productDao;

	@Override
	public <S extends Product> S save(S entity) {
		return productDao.save(entity);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productDao.findAll(sort);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		productDao.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productDao.delete(entity);
	}

	@Override
	public Product getById(Integer id) {
		return productDao.getById(id);
	}

	
//	@Override
//	public Page<Product> selectProductSpIdShoeType(Integer id,Pageable pageable) {
//		return productDao.selectProductSpIdShoeType(id,pageable);
//	}
//
//	@Override
//	public Page<Product> searchBCP(int brandId, int shoeTypeId, double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP(brandId,shoeTypeId,price1,price2, page);
//	}
//
//	@Override
//	public Page<Product> searchBCP1(double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP1(price1,price2, page);
//	}
//
//	@Override
//	public Page<Product> searchBCP2(int shoeTypeId, double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP2(shoeTypeId,price1,price2, page);
//	}
//
//	@Override
//	public Page<Product> searchBCP6(int bran,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP6(bran, page);
//	}
//
//	@Override
//	public Page<Product> searchBCP3(int shoeTypeId,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP3(shoeTypeId,page);
//	}
//
//	@Override
//	public Page<Product> searchBCP4(int brandId, int shoeTypeId,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP4(brandId,shoeTypeId,page);
//	}
//
//	@Override
//	public Page<Product> searchBCP5(int brandId, double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP5(brandId,price1,price2, page);
//	}
//
//	@Override
//	public Page<Product> selectRandom1(Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.selectRandom1(page);
//	}
//
//	@Override
//	public Page<Product> selectDateNew(Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.selectDateNew(page);
//	}
//
//	@Override
//	public Page<Product> selectBanChayNhat(Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.selectBanChayNhat(page);
//	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDao.findAll(pageable);
	}

//	@Override
//	public List<Product> findTop2() {
//		// TODO Auto-generated method stub
//		return productDao.findTop2();
//	}
//
//	@Override
//	public Page<Product> selectAllColor(String color,Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectAllColor(color,pageable);
//	}
//
//	@Override
//	public Page<Product> selectAllMaterialfoop(String material,Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectAllMaterialfoop(material,pageable);
//	}
//
//	@Override
//	public Page<Product> selectAllthickness(String thickness,Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectAllthickness(thickness,pageable);
//	}
//
//	@Override
//	public List<Product> findTop6Img() {
//		// TODO Auto-generated method stub
//		return productDao.findTop6Img();
//	}
//
//	public Page<Product> findSearch(String name,Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.findSearch(name,pageable);
//	}
//
//	@Override
//	public Page<Product> selectProductSpThongHieu(Integer id, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectProductSpThongHieu(id,pageable);
//	}
//
//	@Override
//	public Page<Product> selectProductSpLoai2(String id, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectProductSpLoai2(id,pageable);
//	}
//	public List<Product> top10a() {
//		// TODO Auto-generated method stub
//		return productDao.top10();
//	}
//	
	@Override
	public List<Product> findByName(String name,Boolean status) {
		// TODO Auto-generated method stub
		return productDao.findByName(name ,status);
	}

	@Override
	public List<Product> findByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return productDao.findByStatus(status);
	}

	@Override
	public List<Product> findByName1(String name) {
		// TODO Auto-generated method stub
		return productDao.findByName1(name);
	}
//
//	@Override
//	public Page<Product> findByGender(Long gender,Pageable pageable) {
//		return productDao.getProductByGender(gender, pageable);
//	}
//
//	@Override
//	public Page<Product> getProductByColor(Long color, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.getProductByColor(color, pageable);
//	}
//
//	@Override
//	public Page<Product> getProductBySize(Long size, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.getProductBySize(size, pageable);
//	}
//
	@Override
	public Product checkName(String name) {
		return productDao.checkName(name);
	}

	
	

}
