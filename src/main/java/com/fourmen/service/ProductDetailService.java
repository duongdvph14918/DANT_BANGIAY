package com.fourmen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fourmen.entity.ProductDetail;

public interface ProductDetailService {

	//Page<ProductDetail> selectProductDetailSpIdShoeType(Integer id, Pageable pageable);

	ProductDetail getById(Integer id);

	void delete(ProductDetail entity);

	void deleteById(Integer id);

	Optional<ProductDetail> findById(Integer id);

	List<ProductDetail> findAll(Sort sort);

	List<ProductDetail> findAll();

	<S extends ProductDetail> S save(S entity);

//	Page<ProductDetail> searchBCP(int brandId, int shoeTypeId, double price1, double price2,Pageable page);
//
//	Page<ProductDetail> searchBCP1(double price1, double price2,Pageable page);
//
//	Page<ProductDetail> searchBCP2(int shoeTypeId, double price1, double price2,Pageable page);
//
//	Page<ProductDetail> searchBCP6(int bran,Pageable page);
//
//	Page<ProductDetail> searchBCP3(int shoeTypeId,Pageable page);
//
//	Page<ProductDetail> searchBCP4(int brandId, int shoeTypeId,Pageable page);
//
//	Page<ProductDetail> searchBCP5(int brandId, double price1, double price2,Pageable page);
//
//
//	Page<ProductDetail> selectRandom1(Pageable page);
//
//	Page<ProductDetail> selectDateNew(Pageable page);
//
//	Page<ProductDetail> selectBanChayNhat(Pageable page);

	Page<ProductDetail> findAll(Pageable pageable);

//	List<ProductDetail> findTop2();
//
//	Page<ProductDetail> selectAllColor(String color,Pageable pageable);
//
//	Page<ProductDetail> selectAllMaterialfoop(String material,Pageable pageable);
//
//	Page<ProductDetail> selectAllthickness(String thickness,Pageable pageable);
//
//	List<ProductDetail> findTop6Img();
//
//	Page<ProductDetail> findSearch(String name,Pageable pageable);
//
//	Page<ProductDetail> selectProductDetailSpThongHieu(Integer id, Pageable pageable);
//
//	Page<ProductDetail> selectProductDetailSpLoai2(String id, Pageable pageable);
//
//	List<ProductDetail> top10a();
//
//	
	List<ProductDetail> findByName(String name,Boolean status);
//
	List<ProductDetail> findByStatus(Boolean status);
//
	List<ProductDetail> findByName1(String name);
//	//Page<ProductDetail> findAll1(Pageable pageable);
//	
//	Page<ProductDetail> findByGender(Long color,Pageable pageable);
//	Page<ProductDetail> getProductDetailByColor(Long color, Pageable pageable);
//	Page<ProductDetail> getProductDetailBySize(Long size, Pageable pageable);
//
	ProductDetail checkName(String name);
}
