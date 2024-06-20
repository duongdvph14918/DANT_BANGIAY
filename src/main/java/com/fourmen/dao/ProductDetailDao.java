package com.fourmen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.ProductDetail;

@Repository
public interface ProductDetailDao extends JpaRepository<ProductDetail ,Integer>{
/* @Query("select o from Orders o where o.account.username=?1") */
	
//	@Query(value = "select p from ProductDetail p where p.shoeType.shoeTypeId=?1")
//	Page<ProductDetail> selectProductDetailSpIdShoeType(Integer id,Pageable pageable);
//
//	@Query(value = "select p from ProductDetail p where p.brand.brandId=?1 and p.shoeType.shoeTypeId=?2 and (p.price BETWEEN ?3 AND ?4)")
//	Page<ProductDetail> searchBCP(Integer brandId, Integer shoeTypeId, Double price1, Double price2,Pageable page);
//	
//	@Query(value = "select p from ProductDetail p where p.price BETWEEN ?1 AND ?2")
//	Page<ProductDetail> searchBCP1(double price1, double price2,Pageable page);
//	
//	@Query(value = "select p from ProductDetail p where p.shoeType.shoeTypeId=?1 and p.price BETWEEN ?2 AND ?3")
//	Page<ProductDetail> searchBCP2(int shoeTypeId, double price1, double price2,Pageable page);
//	
//	@Query(value = "select p from ProductDetail p where p.brand.brandId=?1")
//	Page<ProductDetail> searchBCP6(int bran,Pageable page);
//	
//	@Query(value = "select p from ProductDetail p where p.shoeType.shoeTypeId=?1")
//	Page<ProductDetail> searchBCP3(int shoeTypeId,Pageable page);
//	
//	@Query(value = "select p from ProductDetail p where p.brand.brandId=?1 and p.shoeType.shoeTypeId=?2")
//	Page<ProductDetail> searchBCP4(int brandId, int shoeTypeId,Pageable page);
//	
//	@Query(value = "select p from ProductDetail p where p.brand.brandId=?1 and p.price BETWEEN ?2 AND ?3")
//	Page<ProductDetail> searchBCP5(int brandId, double price1, double price2,Pageable page);
//	
//	
//	@Query(value = "SELECT brand_id,product.shoeType_id,product.create_date,description,image,product.name,\r\n"
//			+ "origin,product.price,product.product_id,product.gender,product.style_id,product.shoeSole_id,product.size_id,product.material_id,product.color_id,product.update_date,product.quantity,product.status\r\n"
//			+ "FROM product, discount, shoeType\r\n"
//			+ "WHERE product.shoeType_id = shoeType.shoeType_id and shoeType.discount_id = discount.discount_id \r\n"
//			+ "order by percent_discount desc",nativeQuery = true)
//	Page<ProductDetail> selectRandom1(Pageable page);
//	
//	@Query(value = "select * from product order by create_date desc",nativeQuery = true)
//	Page<ProductDetail> selectDateNew(Pageable page);
//
//	@Query(value = "SELECT brand_id,shoeType_id,product.create_date,description,image,name,\r\n"
//			+ "origin,product.price,product.product_id,product.gender,product.style_id,product.shoeSole_id,product.size_id,product.material_id,product.color_id,product.update_date,product.quantity,product.status, count(order_detail.product_id) as 'tongspmua'\r\n"
//			+ "FROM  product ,orders, order_detail where  product.product_id = order_detail.product_id\r\n"
//			+ "and  order_detail.order_id = orders.order_id\r\n"
//			+ "GROUP BY brand_id,shoeType_id,product.create_date,description,image,name,\r\n"
//			+ "origin,product.price,product.product_id,product.gender,product.style_id,product.shoeSole_id,product.size_id,product.material_id,product.color_id,product.update_date,product.quantity,product.status\r\n"
//			+ "HAVING count(order_detail.product_id) > 0\r\n"
//			+ "order by tongspmua desc",nativeQuery = true)
//	Page<ProductDetail> selectBanChayNhat(Pageable page);
//	
//	@Query(value = "SELECT top(4) brand_id,shoeType_id,product.create_date,description,image,name,\r\n"
//			+ "			origin,product.price,product.product_id,product.gender,product.style_id,product.shoeSole_id,product.size_id,product.material_id,product.color_id,product.update_date,product.quantity,product.status, count(order_detail.product_id) as 'tongspmua'\r\n"
//			+ "			FROM  product ,orders, order_detail where  product.product_id = order_detail.product_id\r\n"
//			+ "			and  order_detail.order_id = orders.order_id\r\n"
//			+ "			GROUP BY brand_id,shoeType_id,product.create_date,description,image,name,\r\n"
//			+ "			origin,product.price,product.product_id,product.gender,product.style_id,product.shoeSole_id,product.size_id,product.material_id,product.color_id,product.update_date,product.quantity,product.status\r\n"
//			+ "			HAVING count(order_detail.product_id) > 0\r\n"
//			+ "			order by tongspmua desc",nativeQuery = true)
//	List<ProductDetail> findTop2();
//
//	@Query(value = "select p from ProductDetail p where color =?1")
//	Page<ProductDetail> selectAllColor(String color,Pageable pageable);
//
//	@Query(value = "select p from ProductDetail p where material =?1")
//	Page<ProductDetail> selectAllMaterialfoop(String material,Pageable pageable);
//
//	@Query(value = "select p from ProductDetail p where  size =?1")
//	Page<ProductDetail> selectAllthickness(String thickness,Pageable pageable);
//	
//	@Query(nativeQuery = true, value = "SELECT TOP 6 * FROM ProductDetail o ORDER BY o.create_Date DESC")
//	List<ProductDetail> findTop6Img();
//	
////	@Query(value = "select p from ProductDetail p where p.name like %?1% or p.shoeType.name like %?1% or p.brand.name like %?1%")
////	Page<ProductDetail> findSearch(String name,Pageable pageable);
//	
//	@Query(value = "SELECT TOP(5) * FROM ProductDetail\r\n"
//			+ "order by create_date desc", 
//			nativeQuery = true)
//	//@Query("select p from ProductDetail p where p.shoeType.id=?1")
//	List<ProductDetail> top10();
//	@Query(value = "select p from ProductDetail p where p.brand.id=?1")
//	Page<ProductDetail> selectProductDetailSpThongHieu(Integer id, Pageable pageable);
//	@Query(value = "select p from ProductDetail p where p.shoeType.name like %?1%")
//	Page<ProductDetail> selectProductDetailSpLoai2(String id, Pageable pageable);
//	
//	@Query(value = "SELECT TOP(10) * FROM ProductDetail\r\n"
//			+ "order by create_date desc", 
//			nativeQuery = true)
//	List<ProductDetail> top10a();
//
	@Query(value = "SELECT * FROM product_detail  join product on product.product_id = product_detail.product_id WHERE product.product_code LIKE ?1 and product_detail.status = ?2",nativeQuery = true )
	List<ProductDetail> findByName(String name,Boolean status);
	
	@Query(value = "SELECT * FROM product_detail  WHERE product_detail.status = ?1",nativeQuery = true)
	List<ProductDetail> findByStatus(Boolean status);

	@Query(value = "SELECT * FROM product_detail  join product  on product.product_id = product_detail.product_id WHERE product.product_code LIKE ?1",nativeQuery = true )
	List<ProductDetail> findByName1(String name);
	
	@Query(value="select * from product_detail order by product_id desc",nativeQuery = true)
	List<ProductDetail> getAllProductDetail();
//	
//	@Query(value="select * from product where gender = ?1",nativeQuery = true)
//	Page<ProductDetail> getProductDetailByGender(Long gender, Pageable pageable);
//	
//	@Query(value="select * from product where status = 1 and color_id = ?1", nativeQuery = true)
//	Page<ProductDetail> getProductDetailByColor(Long gender, Pageable pageable);
//	
//	@Query(value="select * from product where status = 1 and size_id = ?1",nativeQuery = true)
//	Page<ProductDetail> getProductDetailBySize (Long size, Pageable pageable);
//	@Query(value="select * from product join order_detail on product.product_id = order_detail.product_id\n"
//			+ "where order_detail.order_id = ?1",nativeQuery = true)
//	List<ProductDetail> getProductDetailByOrders(Integer id);
//	
//	@Query(value="select * from product\r\n"
//			+ "inner join order_detail on product.product_id = order_detail.product_id\r\n"
//			+ "where order_detail_id = ?1",nativeQuery = true)
//	ProductDetail getProductDetailByOrderDetail(Integer id);
//
	@Query(value="select * from product where name = ?1",nativeQuery = true)
	ProductDetail checkName(String name);
}
