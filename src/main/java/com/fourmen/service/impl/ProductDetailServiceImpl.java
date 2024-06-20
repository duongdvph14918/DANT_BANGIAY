package com.fourmen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fourmen.dao.ProductDetailDao;
import com.fourmen.entity.ProductDetail;
import com.fourmen.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{
		
	@Autowired 
	ProductDetailDao productDao;

	@Override
	public <S extends ProductDetail> S save(S entity) {
		return productDao.save(entity);
	}

	@Override
	public List<ProductDetail> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<ProductDetail> findAll(Sort sort) {
		return productDao.findAll(sort);
	}

	@Override
	public Optional<ProductDetail> findById(Integer id) {
		return productDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		productDao.deleteById(id);
	}

	@Override
	public void delete(ProductDetail entity) {
		productDao.delete(entity);
	}

	@Override
	public ProductDetail getById(Integer id) {
		return productDao.getById(id);
	}

	
//	@Override
//	public Page<ProductDetail> selectProductDetailSpIdShoeType(Integer id,Pageable pageable) {
//		return productDao.selectProductDetailSpIdShoeType(id,pageable);
//	}
//
//	@Override
//	public Page<ProductDetail> searchBCP(int brandId, int shoeTypeId, double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP(brandId,shoeTypeId,price1,price2, page);
//	}
//
//	@Override
//	public Page<ProductDetail> searchBCP1(double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP1(price1,price2, page);
//	}
//
//	@Override
//	public Page<ProductDetail> searchBCP2(int shoeTypeId, double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP2(shoeTypeId,price1,price2, page);
//	}
//
//	@Override
//	public Page<ProductDetail> searchBCP6(int bran,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP6(bran, page);
//	}
//
//	@Override
//	public Page<ProductDetail> searchBCP3(int shoeTypeId,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP3(shoeTypeId,page);
//	}
//
//	@Override
//	public Page<ProductDetail> searchBCP4(int brandId, int shoeTypeId,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP4(brandId,shoeTypeId,page);
//	}
//
//	@Override
//	public Page<ProductDetail> searchBCP5(int brandId, double price1, double price2,Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.searchBCP5(brandId,price1,price2, page);
//	}
//
//	@Override
//	public Page<ProductDetail> selectRandom1(Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.selectRandom1(page);
//	}
//
//	@Override
//	public Page<ProductDetail> selectDateNew(Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.selectDateNew(page);
//	}
//
//	@Override
//	public Page<ProductDetail> selectBanChayNhat(Pageable page) {
//		// TODO Auto-generated method stub
//		return productDao.selectBanChayNhat(page);
//	}

	@Override
	public Page<ProductDetail> findAll(Pageable pageable) {
		return productDao.findAll(pageable);
	}

//	@Override
//	public List<ProductDetail> findTop2() {
//		// TODO Auto-generated method stub
//		return productDao.findTop2();
//	}
//
//	@Override
//	public Page<ProductDetail> selectAllColor(String color,Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectAllColor(color,pageable);
//	}
//
//	@Override
//	public Page<ProductDetail> selectAllMaterialfoop(String material,Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectAllMaterialfoop(material,pageable);
//	}
//
//	@Override
//	public Page<ProductDetail> selectAllthickness(String thickness,Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectAllthickness(thickness,pageable);
//	}
//
//	@Override
//	public List<ProductDetail> findTop6Img() {
//		// TODO Auto-generated method stub
//		return productDao.findTop6Img();
//	}
//
//	
//
//	@Override
//	public Page<ProductDetail> selectProductDetailSpThongHieu(Integer id, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectProductDetailSpThongHieu(id,pageable);
//	}
//
//	@Override
//	public Page<ProductDetail> selectProductDetailSpLoai2(String id, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.selectProductDetailSpLoai2(id,pageable);
//	}
//	public List<ProductDetail> top10a() {
//		// TODO Auto-generated method stub
//		return productDao.top10();
//	}
//	
	@Override
	public List<ProductDetail> findByName(String name,Boolean status) {
		// TODO Auto-generated method stub
		return productDao.findByName(name ,status);
	}

	@Override
	public List<ProductDetail> findByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return productDao.findByStatus(status);
	}

	@Override
	public List<ProductDetail> findByName1(String name) {
		// TODO Auto-generated method stub
		return productDao.findByName1(name);
	}
//
//	@Override
//	public Page<ProductDetail> findByGender(Long gender,Pageable pageable) {
//		return productDao.getProductDetailByGender(gender, pageable);
//	}
//
//	@Override
//	public Page<ProductDetail> getProductDetailByColor(Long color, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.getProductDetailByColor(color, pageable);
//	}
//
//	@Override
//	public Page<ProductDetail> getProductDetailBySize(Long size, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return productDao.getProductDetailBySize(size, pageable);
//	}
//
	@Override
	public ProductDetail checkName(String name) {
		return productDao.checkName(name);
	}
//


	
	

}
